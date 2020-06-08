import numpy as np
import pandas as pd
from sklearn.linear_model import LinearRegression

from constants import INVESTMENT_TYPE
from models.investment import Investment
from models.stock import Stock
from sklearn.preprocessing import MinMaxScaler
from sklearn.model_selection import TimeSeriesSplit


class Prediction:
    stocks = pd.DataFrame()
    X = np.array([])
    Y = np.array([])
    x_train = np.array([])
    y_train = np.array([])
    x_valid = np.array([])
    y_valid = np.array([])

    def __init__(self, mysql_obj):
        self.mysql_obj = mysql_obj
        self.investments_ids = self.get_investment_ids()

    def run(self):
        for investment_id in self.investments_ids:
            if investment_id:
                self.load_df(investment_id[0])
                if not self.stocks.empty:
                    self.train()
                    self.save_prediction()

    def get_investment_ids(self):
        investment = Investment(self.mysql_obj)
        investments_ids = investment.get_all_by_investment_type_id(INVESTMENT_TYPE['variable_income_id'])
        return list(investments_ids)

    def load_df(self, investment_id):
        stock = Stock(self.mysql_obj)
        stock_data = stock.get_all_by_investment_id(investment_id)
        if stock_data:
            df = pd.DataFrame(stock_data)
            df.columns = ['high', 'low', 'adjusted_close', 'date']
            df.set_index('date', inplace=True)
            df.dropna()
            self.stocks = df.sort_index(ascending=True)

    def train(self):
        # self.split_target()
        self.add_moving_average()
        self.split_training()
        self.linear_regression()

    # def split_target(self):
    #     # A variable for predicting 'n' days out into the future
    #     forecast_out = 30  # 'n = 30' days
    #     # Create another column (the target ) shifted 'n' units up
    #     self.stocks['prediction'] = self.stocks[['adjusted_close']].shift(-forecast_out)
    #
    #     X = np.array(self.stocks.drop(['prediction'], 1))
    #
    #     # Remove the last '30' rows
    #     self.X = X[:-forecast_out]
    #
    #     # Create the dependent data set (y)
    #     # Convert the dataframe to a numpy array
    #     Y = np.array(self.stocks['prediction'])
    #     # Get all of the y values except the last '30' rows
    #     self.Y = Y[:-forecast_out]

    def add_moving_average(self):
        self.stocks = self.stocks.drop(['low', 'high'], axis=1)
        self.stocks['moving_average_21'] = self.stocks.adjusted_close.rolling(window=21).mean()
        self.stocks['moving_average_7'] = self.stocks.adjusted_close.rolling(window=7).mean()
        # Removing stocks without moving average
        self.stocks = self.stocks[20:]

    def split_training(self):
        # tscv = TimeSeriesSplit(n_splits=2)
        # for train_index, test_index in tscv.split(self.X):
        #     print("TRAIN:", train_index, "TEST:", test_index)
        #     X_train, X_test = self.X[train_index], self.X[test_index]
        #     y_train, y_test = self.Y[train_index], self.Y[test_index]
        # split into train and validation

        stocks_split = int(len(self.stocks) * 0.7)

        train = self.stocks[:stocks_split]
        valid = self.stocks[stocks_split:]

        self.x_train = train.drop('adjusted_close', axis=1)
        self.y_train = train['adjusted_close']
        self.x_valid = valid.drop('adjusted_close', axis=1)
        self.y_valid = valid['adjusted_close']

    def linear_regression(self):
        model = LinearRegression()
        model.fit(self.x_train, self.y_train)
        # make predictions and find the rmse
        preds = model.predict(self.x_valid)
        rms = np.sqrt(np.mean(np.power((np.array(self.y_valid) - np.array(preds)), 2)))
        print(rms)

    def save_prediction(self):
        pass
