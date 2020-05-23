import time

from alpha_vantage.foreignexchange import ForeignExchange
from alpha_vantage.timeseries import TimeSeries
import pandas as pd

from conexao_mysql import MySQL
from constants import USD_BRL, TABLE_NAMES, TIPO_INVESTIMENTO, TICKERS as tk


def main():
    # https://alpha-vantage.readthedocs.io/en/latest/index.html
    mysql_user = input('Insert your MySQL username')
    mysql_password = input('Insert your MySQL password')
    with open('.api_key') as f:
        api_key = f.readline().strip()
    mysql_obj = MySQL('localhost', mysql_user, mysql_password, 'sistema_investimento')
    import_obj = Import(mysql_obj, api_key)
    import_obj.run()
    mysql_obj.connection.close()


class Import:
    def __init__(self, mysql_obj, api_key):
        self.mysql_obj = mysql_obj
        self.api_key = api_key
        self.entity = None
        self.df = None

    def run(self):
        five_api_calls_per_minute = 60 / 5

        self.insert_entity_type()

        # Stock data
        for entity_symbol, entity_name in tk.items():
            self.entity = {'symbol': entity_symbol, 'name': entity_name}
            self.create_df()
            self.insert_entity_data(entity_symbol, entity_name)
            self.insert_stock_data()
            time.sleep(five_api_calls_per_minute)

        # FX
        self.create_df_fx()
        self.insert_entity_data('USD_BRL', USD_BRL['nome'])
        self.insert_fx_data(USD_BRL['nome'])

        print('Data imported successfully!')

    def create_df(self):
        ts = TimeSeries(self.api_key)
        data, meta_data = ts.get_daily_adjusted(symbol=self.entity['symbol'], outputsize='full')
        data_df = pd.DataFrame(data)
        data_df = data_df.T
        data_df.columns = [
            'open', 'high', 'low', 'close',
            'adjusted_close', 'volume', 'dividend_amount', 'split_coefficient'
        ]
        self.df = data_df
    
    def get_entity_type_id(self, name):
        query = f"""SELECT id FROM {TABLE_NAMES['tipo_investimento']} where {TABLE_NAMES['tipo_investimento']}.nome = '{name}'"""
        entity_type = self.mysql_obj.execute_read_query(query)
        if entity_type:
            entity_type_id = entity_type[0][0]
            return entity_type_id
        return entity_type
    
    def insert_entity_type(self):
        name = TIPO_INVESTIMENTO['nome']
        print(f'Inserting entity type: {name}')
        if self.get_entity_type_id(name):
            print(f'Entity type {name} already exists')
        else:
            insert = f"""INSERT INTO {TABLE_NAMES['tipo_investimento']} (nome) VALUES ('{name}')"""
            self.mysql_obj.execute_query(insert)

    def get_entity_id(self, name):
        query = f"""SELECT id FROM {TABLE_NAMES['investimento']} where {TABLE_NAMES['investimento']}.nome = '{name}'"""
        entity = self.mysql_obj.execute_read_query(query)
        if entity:
            entity = entity[0][0]
        return entity

    def insert_entity_data(self, symbol, name):
        print(f'Inserting entity: {name}')
        if self.get_entity_id(name):
            print(f'Entity {name} already exists')
        else:
            entity_type_id = self.get_entity_type_id(TIPO_INVESTIMENTO['nome'])
            if not entity_type_id:
                raise ValueError
            insert = f"""INSERT INTO {TABLE_NAMES['investimento']} (nome, id_tipo_investimento) VALUES ('{name}', {entity_type_id})"""
            self.mysql_obj.execute_query(insert)

    def get_stock_data_id(self, day, entity_id):
        query = f"""SELECT id FROM {TABLE_NAMES['acao']} WHERE {TABLE_NAMES['acao']}.data = '{day}' and {TABLE_NAMES['acao']}.id_investimento = '{entity_id}'"""
        stock_data = self.mysql_obj.execute_read_query(query)
        if stock_data:
            stock_data = stock_data[0][0]
        return stock_data

    def insert_stock_data(self):
        print(f'Inserting {self.entity["name"]} stock data')
        insert = f"""
            INSERT INTO
                {TABLE_NAMES['acao']} (
                abertura, alta, baixa, fechamento, fechamento_ajustado, volume, dividendo, coeficiente_divisao, data,
                id_investimento
                )
            VALUES
                (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        """
        df = self.df
        entity_id = self.get_entity_id(self.entity['name'])
        for day in df.itertuples():
            if not self.get_stock_data_id(day[0], entity_id):
                self.mysql_obj.execute_par_query(insert, (day.open, day.high, day.low, day.close, day.adjusted_close,
                                                          day.volume, day.dividend_amount, day.split_coefficient,
                                                          day[0], entity_id)
                                                 )

    def create_df_fx(self):
        cc = ForeignExchange(key=self.api_key)
        data, _ = cc.get_currency_exchange_daily(from_symbol='USD', to_symbol='BRL', outputsize='full')
        data_df = pd.DataFrame(data)
        data_df = data_df.T
        data_df.columns = ['open', 'high', 'low', 'close']
        self.df = data_df

    def insert_fx_data(self, name):
        print(f'Inserting FX data')
        insert = f"""
                    INSERT INTO
                        {TABLE_NAMES['dollar']} (abertura, alta, baixa, fechamento, data, id_investimento)
                    VALUES
                        (%s, %s, %s, %s, %s, %s)
                """
        df = self.df
        entity_id = self.get_entity_id(name)
        for day in df.itertuples():
            if not self.get_stock_data_id(day[0], entity_id):
                self.mysql_obj.execute_par_query(insert, (day.open, day.high, day.low, day.close, day[0], entity_id))


if __name__ == '__main__':
    main()
