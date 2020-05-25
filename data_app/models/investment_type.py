from constants import TABLE_NAMES

INVESTMENT_TYPE = {
    'fixed_income': 'Renda Fixa',
    'variable_income': 'Renda Variável'
}


class InvestmentType:

    def __init__(self, mysql_obj):
        self.mysql_obj = mysql_obj
        self.name = INVESTMENT_TYPE['fixed_income']
        self.table_name = TABLE_NAMES['investment_type']

    def insert(self):
        print(f'Inserting investment type: {self.name}')
        if self.get_id():
            print(f'Investment type {self.name} already exists')
        else:
            insert = f"""INSERT INTO {self.table_name} (nome) VALUES ('{self.name}')"""
            self.mysql_obj.execute_query(insert)

    def get_id(self):
        query = f"""SELECT id FROM {self.table_name} where {self.table_name}.nome = '{self.name}'"""
        investment_type = self.mysql_obj.execute_read_query(query)
        if investment_type:
            investment_type_id = investment_type[0][0]
            return investment_type_id
        return None
