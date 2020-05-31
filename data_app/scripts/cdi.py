from bs4 import BeautifulSoup

from models.variable_income import VariableIncome
from models.variable_income_type import VariableIncomeType
from selenium_connector import SeleniumConnector
from utils import format_float

URL = 'http://www.b3.com.br/pt_br/'


class CDIImport:
    soup = None
    cdi_html = ''
    cdi_value = 0.0

    def __init__(self, mysql_obj):
        self.mysql_obj = mysql_obj

    def run(self):
        self.search_data()
        self.find_data_in_html()
        self.parse_data()
        self.insert_data()

    def search_data(self):
        print('Searching data')
        selenium = SeleniumConnector(URL, options=['--headless'])
        html = selenium.get_html()
        self.soup = BeautifulSoup(html, 'html.parser')

    def find_data_in_html(self):
        print('Parsing data')
        cdi_html = self.soup.find('div', id='taxaPct')
        if not cdi_html:
            raise ValueError('Não foi possível buscar os dados do CDI, tente novamente')
        self.cdi_html = cdi_html

    def parse_data(self):
        self.cdi_value = format_float(self.cdi_html.text)

    def insert_data(self):
        name = 'CDI'
        variable_income_type = VariableIncomeType(self.mysql_obj)
        variable_income = VariableIncome(self.mysql_obj)

        variable_income_type.insert(name)
        variable_income_type_id = variable_income_type.get_id(name)

        variable_income.insert(self.cdi_value, variable_income_type_id)
