from mysql_conn import MySQL
from scripts.ipca import IPCAImport
from scripts.selic import SELICImport
from scripts.stock import StockImport
from scripts.forex import ForexImport
from scripts.tesouro_direto import TesouroDiretoImport


def main():
    mysql_obj, api_key = setup()
    IPCAImport(mysql_obj).run()
    SELICImport(mysql_obj).run()
    TesouroDiretoImport(mysql_obj).run()
    ForexImport(mysql_obj, api_key).run()
    StockImport(mysql_obj, api_key).run()
    mysql_obj.connection.close()
    print('Data imported successfully!')


def setup():
    mysql_user = input('Insert your MySQL username\n')
    mysql_password = input('Insert your MySQL password\n')
    mysql_obj = MySQL('localhost', mysql_user, mysql_password, 'sistema_investimento')
    with open('.api_key') as f:
        api_key = f.readline().strip()
    return mysql_obj, api_key


if __name__ == '__main__':
    main()
