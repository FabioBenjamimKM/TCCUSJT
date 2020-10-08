from argparse import ArgumentParser

from mysql_conn import MySQL
from scripts.cdi import CDIImport
from scripts.fact_stock import FactStockImport
from scripts.ipca import IPCAImport
from scripts.prediction import PredictionImport
from scripts.selic import SELICImport
from scripts.stock import StockImport
from scripts.forex import ForexImport
from scripts.tesouro_direto import TesouroDiretoImport
from scripts.suggestion import SuggestionImport

try:
    from local_settings import API_KEY, DB_USER, DB_PASSWORD, API_KEY_HGBRASIL, DB_NAME, HOST
except ImportError:
    pass


def main():
    full_import = args()
    mysql_obj, api_key, api_key_hgbrasil = setup()

    IPCAImport(mysql_obj).run()
    SELICImport(mysql_obj, api_key_hgbrasil).run()
    CDIImport(mysql_obj, api_key_hgbrasil).run()
    TesouroDiretoImport(mysql_obj).run()
    ForexImport(mysql_obj, api_key).run()
    StockImport(mysql_obj, api_key, full_import).run()

    FactStockImport(mysql_obj).run()

    PredictionImport(mysql_obj).run()

    SuggestionImport(mysql_obj).run()

    mysql_obj.connection.close()
    print('Data imported successfully!')


def setup():
    try:
        mysql_user = DB_USER
    except NameError:
        mysql_user = input('Insert your MySQL username\n')

    try:
        mysql_password = DB_PASSWORD
    except NameError:
        mysql_password = input('Insert your MySQL password\n')

    try:
        db_name = DB_NAME
    except NameError:
        db_name = 'sistema_investimento'

    try:
        host = HOST
    except NameError:
        host = 'localhost'

    mysql_obj = MySQL(host, mysql_user, mysql_password, db_name)

    try:
        api_key = API_KEY
    except NameError:
        api_key = input('Insert your API key\n')

    try:
        api_key_hgbrasil = API_KEY_HGBRASIL
    except NameError:
        api_key_hgbrasil = input('Insert your API HGBrasil key (https://console.hgbrasil.com/keys/new_key_plan)\n')

    return mysql_obj, api_key, api_key_hgbrasil


def args():
    parser = ArgumentParser()
    parser.add_argument('-f', '--full', action='store_true', default=False, help='Full import')
    args = parser.parse_args()
    return args.full


if __name__ == '__main__':
    main()
