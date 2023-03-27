package com.jerry.example.operators.create;

import reactor.core.publisher.Flux;

import java.util.stream.Stream;

public class FromStreamExample01 {
    public static void main(String[] args) {
        Flux
                .fromStream(Stream.of(200, 300, 400, 500, 600))
                .reduce(Integer::sum)
                .subscribe(System.out::println);
    }
}
