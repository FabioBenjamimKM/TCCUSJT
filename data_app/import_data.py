import time

from alpha_vantage.foreignexchange import ForeignExchange
from alpha_vantage.timeseries import TimeSeries
import pandas as pd

from conexao_mysql import MySQL
from constants import TICKERS as tk


def main():
    # https://alpha-vantage.readthedocs.io/en/latest/index.html
    mysql_user = input('Insert your MySQL username')
    mysql_password = input('Insert your MySQL password')
    api_key = input('Insert your api key, you can get one here: "https://www.alphavantage.co/support/#api-key"')
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

        # Stock data
        for entity_symbol, entity_name in tk.items():
            self.entity = {'symbol': entity_symbol, 'name': entity_name}
            self.create_df()
            self.insert_entity_data(entity_symbol, entity_name)
            self.insert_stock_data()
            time.sleep(five_api_calls_per_minute)

        # FX
        self.create_df_fx()
        self.insert_entity_data('USD_BRL', 'Paridade Dólar/Real')
        self.insert_fx_data('USD_BRL')

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

    def get_entity_id(self, symbol):
        query = """SELECT id FROM entidade where entidade.simbolo = '%s'""" % symbol
        entity = self.mysql_obj.execute_read_query(query)
        if entity:
            entity = entity[0][0]
        return entity

    def insert_entity_data(self, symbol, name):
        print(f'Inserting entity: {name}')
        if self.get_entity_id(symbol):
            print(f'entity {name} already exists')
        else:
            insert = """INSERT INTO entidade (nome, simbolo) VALUES ('%s', '%s')""" % (name, symbol)
            self.mysql_obj.execute_query(insert)

    def get_stock_data_id(self, day, entity_id):
        query = """SELECT id FROM valor WHERE valor.dia = '%s' and valor.ENTIDADE_id = '%s'""" % (day, entity_id)
        stock_data = self.mysql_obj.execute_read_query(query)
        if stock_data:
            stock_data = stock_data[0][0]
        return stock_data

    def insert_stock_data(self):
        print(f'Inserting {self.entity["name"]} stock data')
        insert = """
            INSERT INTO
                valor (
                abertura, alta, baixa, fechamento, fechamento_ajustado, volume, dividendo, coeficiente_divisao, dia,
                ENTIDADE_id
                )
            VALUES
                (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
        """
        df = self.df
        entity_id = self.get_entity_id(self.entity['symbol'])
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

    def insert_fx_data(self, symbol):
        print(f'Inserting FX data')
        insert = """
                    INSERT INTO
                        valor (abertura, alta, baixa, fechamento, dia, ENTIDADE_id)
                    VALUES
                        (%s, %s, %s, %s, %s, %s)
                """
        df = self.df
        entity_id = self.get_entity_id(symbol)
        for day in df.itertuples():
            if not self.get_stock_data_id(day[0], entity_id):
                self.mysql_obj.execute_par_query(insert, (day.open, day.high, day.low, day.close, day[0], entity_id))


if __name__ == '__main__':
    main()
