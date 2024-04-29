package com.sptek.webflux.exec;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.Arrays;

public class MyPub implements Publisher<Integer> {

    Iterable<Integer> its = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

    @Override
    public void subscribe(Subscriber<? super Integer> s) {
        System.out.println("주문자 : 음식 주문");
        System.out.println("음식점 : 주문 요청이 되었습니다. 기다려주십시오.");
        MyOrder order = new MyOrder(s, its);
        System.out.println("음식점 : 주문 완료");
        s.onSubscribe(order);
    }
}
