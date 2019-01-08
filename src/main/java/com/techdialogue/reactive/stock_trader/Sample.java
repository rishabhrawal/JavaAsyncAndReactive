package com.techdialogue.reactive.stock_trader;
import java.util.Arrays;
import java.util.List;

public class Sample {
    public static void main(String[] args) {
        List symbols  = List.of("GOOG", "AMZN", "ITC");
        Observable<StockInfo> feed = StockServer.getFeed(symbols);

    }
}
