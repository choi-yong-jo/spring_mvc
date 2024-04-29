package com.sptek.webflux.exec;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Iterator;

// 구독(subscribe) 정보
// 주문 정보(주문한 사람, 주문 음식)
public class MyOrder implements Subscription {

    private Subscriber s;
    private Iterator<Integer> it;

    public MyOrder(Subscriber s, Iterable<Integer> its){
        this.s = s;
        this.it = its.iterator();
    }


    @Override
    public void request(long n) {
        while (n > 0){
            if(it.hasNext()){
                s.onNext(it.next());
                n--;
            }else{
                s.onComplete();
                break;
            }
        }
    }

    @Override
    public void cancel() {

    }
}
