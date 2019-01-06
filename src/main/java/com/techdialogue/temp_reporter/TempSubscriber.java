package com.techdialogue.temp_reporter;

import java.util.concurrent.Flow;

public class TempSubscriber implements Flow.Subscriber<TempInfo> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription){
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(TempInfo tempInfo){
        System.out.println(tempInfo);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable t){
        //System.out.println(t.getMessage());
        t.printStackTrace();
    }

    @Override
    public void onComplete(){
        System.out.println("Done!");
    }
}
