package com.techdialogue.reactive.stock_trader;

public class XFinance {

    public static double getPrice(String ticker, boolean useMock){
        if(useMock){
            return Math.random()*1000;
        }else{
            return 100;
        }
    }
}
