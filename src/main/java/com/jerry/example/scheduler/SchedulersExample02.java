package com.jerry.example.scheduler;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class SchedulersExample02 {
    public static void main(String[] args) throws InterruptedException {
        Flux
                .range(1, 10)
                .doOnSubscribe(subscription -> log.info("# doOnSubscribe"))
                .subscribeOn(Schedulers.boundedElastic())
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .subscribe(data -> log.info("# onNext: {}", data));

        Thread.sleep(1000L);
    }
}
