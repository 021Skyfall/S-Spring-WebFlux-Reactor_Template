package com.jerry.example.operators.peeking;

import com.jerry.example.operators.sample_data.Coffee;
import com.jerry.example.operators.sample_data.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class DoOnNextExample01 {
    public static void main(String[] args) {
        Flux
                .fromIterable(SampleData.coffeeList)
                .doOnNext(DoOnNextExample01::validateCoffee)
                .subscribe(data -> log.info("{} : {}", data.getKorName(), data.getPrice()));
    }

    private static void validateCoffee(Coffee coffee) {
        if (coffee == null)
            throw new RuntimeException("Not found coffee");
        if (coffee.getKorName().equals("아메리카노"))
            throw new RuntimeException("엥 엥 엥");
    }
}
