package com.techdialogue.reactive.stock_trader;

import java.math.BigDecimal;

public class StockInfo {

    String ticker;
    double value; //use BigDecimal

    public StockInfo(String ticker, double value) {
        this.ticker = ticker;
        this.value = value;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s:%f",ticker,value);
    }



    public static StockInfo fetch(String ticker){
        //if(Math.random()>0.9) throw new RuntimeException("Oops, ran into trouble");
        return new StockInfo(ticker, XFinance.getPrice(ticker, true));
    }
}
