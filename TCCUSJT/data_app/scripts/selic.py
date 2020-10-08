from bs4 import BeautifulSoup

from models.variable_income import VariableIncome
from models.variable_income_type import VariableIncomeType
from selenium_connector import SeleniumConnector
from utils import format_float

URL = 'https://www.melhorcambio.com/taxa-selic'


class SELICImport:
    soup = None
    html = ''
    value = ''

    def __init__(self, mysql_obj):
        self.mysql_obj = mysql_obj

    def run(self):
        self.search_data()
        self.find_data_in_html()
        self.parse_data()
        self.insert_data()

    def search_data(self):
        print('Searching data')
        selenium = SeleniumConnector(URL, options=['--headless', '--no-sandbox'])
        html = selenium.get_html()
        self.soup = BeautifulSoup(html, 'html.parser')

    def find_data_in_html(self):
        print('Parsing data')
        selic = self.soup.find('input', id='selic-hoje')
        if not selic:
            raise ValueError('Não foi possível buscar os dados da SELIC, tente novamente')
        self.html = selic

    def parse_data(self):
        self.value = format_float(self.html.attrs['value'])

    def insert_data(self):
        name = 'SELIC'
        variable_income_type = VariableIncomeType(self.mysql_obj)
        variable_income = VariableIncome(self.mysql_obj)

        variable_income_type.insert(name)
        variable_income_type_id = variable_income_type.get_id(name)

        variable_income.insert(self.value, variable_income_type_id)
