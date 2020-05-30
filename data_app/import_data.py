from mysql_conn import MySQL
from scripts.cdi import CDIImport
from scripts.fact_stock import FactStockImport
from scripts.ipca import IPCAImport
from scripts.selic import SELICImport
from scripts.stock import StockImport
from scripts.forex import ForexImport
from scripts.tesouro_direto import TesouroDiretoImport

try:
    from local_settings import API_KEY, DB_USER, DB_PASSWORD
except ImportError:
    API_KEY, DB_USER, DB_PASSWORD = ['', '', '']


def main():
    mysql_obj, api_key = setup()

    IPCAImport(mysql_obj).run()
    SELICImport(mysql_obj).run()
    CDIImport(mysql_obj).run()
    TesouroDiretoImport(mysql_obj).run()
    ForexImport(mysql_obj, api_key).run()
    StockImport(mysql_obj, api_key).run()

    FactStockImport(mysql_obj).run()

    mysql_obj.connection.close()
    print('Data imported successfully!')


def setup():
    if not DB_USER:
        mysql_user = input('Insert your MySQL username\n')
    else:
        mysql_user = DB_USER
    if not DB_PASSWORD:
        mysql_password = input('Insert your MySQL password\n')
    else:
        mysql_password = DB_PASSWORD
    mysql_obj = MySQL('localhost', mysql_user, mysql_password, 'sistema_investimento')
    if not API_KEY:
        api_key = input('Insert your API key\n')
    else:
        api_key = API_KEY
    return mysql_obj, api_key


if __name__ == '__main__':
    main()
