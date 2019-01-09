package com.techdialogue.reactive.stock_trader;
import io.reactivex.Observable;

import java.util.List;

public class Sample {
    public static void main(String[] args) {
        List symbols  = List.of("GOOG", "AMZN", "ITC");
        Observable<StockInfo> feed = StockServer.getFeed(symbols);
        System.out.println("Got observable...");

        Observable<StockInfo> feed2 = StockServer.getFeed(symbols);

        feed
                //.onErrorReturnItem(new StockInfo("Error",9999.99))
                //.onErrorReturnItem(new StockInfo("AGAIN",55555.55))
                .onErrorResumeNext(feed2)
                .onErrorReturnItem(new StockInfo("AGAIN",55555.55))
                //.filter(stockInfo -> stockInfo.value>500)
                .map(stockInfo -> new StockInfo(stockInfo.ticker, stockInfo.value * 0.9))
                .subscribe(stockInfo -> System.out.println(stockInfo),
                        err -> System.out.println("ERROR: " +  err),
                        ()->System.out.println("DONE!"));


        //Only one error is enough to close the data channel
        //separate handlers for ever error but how many ???
        //is there a way to resume on the same data channel

    }
}
