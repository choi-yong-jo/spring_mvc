package com.sptek.webflux.exec;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MySub implements Subscriber<Integer> {

    private Subscription s;

    private int bufferSize = 3;

    @Override
    public void onSubscribe(Subscription s) {
        int cnt = 12;
        System.out.println("주문자 : 주문 잘 받음.");
        this.s = s;
        System.out.println("음식점 : 오늘은 "+bufferSize+"개만 주문할 수 있습니다.");
        s.request(bufferSize);   // 소비자가 한번에 처리할 수 있는 개수 요청
    }

    @Override
    public void onNext(Integer i) {
        System.out.println("onNext():"+i);
        //System.out.println("하루 지남");
        //s.request(i);   // 소비자가 한번에 처리할 수 있는 개수 요청
        bufferSize--;
        if(bufferSize == 0){
            System.out.println("하루 지남");
            bufferSize = 3;
            s.request(bufferSize);   // 소비자가 한번에 처리할 수 있는 개수 요청
        }
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("주문 불가");
    }

    @Override
    public void onComplete() {
        System.out.println("주문 완료");
    }
}
