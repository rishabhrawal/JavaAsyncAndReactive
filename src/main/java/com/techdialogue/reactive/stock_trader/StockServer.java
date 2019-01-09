package com.techdialogue.reactive.stock_trader;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

import java.util.List;

public class StockServer {

    public static Observable<StockInfo> getFeed(List<String> symbols) {
        System.out.println("created...");
        return Observable.create(emitter-> emitPrice(emitter, symbols));
    }

    private static void emitPrice(ObservableEmitter<StockInfo> emitter, List<String> symbols){
        System.out.println("Ready to emit ...");

        int count =0;
        while(count < 15){
            symbols.stream()
                    .map(StockInfo::fetch)
                    .forEach(emitter::onNext);

            sleep(1000);

            //error closes the data channel
            if(count >=2) emitter.onError(new RuntimeException("Oops"));
            count ++;
        }

        emitter.onComplete();
        emitter.onNext(new StockInfo("Blah...",0.0));
    }

    public static void sleep(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
