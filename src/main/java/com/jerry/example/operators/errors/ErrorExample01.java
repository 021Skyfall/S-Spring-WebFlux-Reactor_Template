package com.jerry.example.operators.errors;

import com.jerry.example.operators.sample_data.Coffee;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class ErrorExample01 {
    public static void main(String[] args) {
        Mono.justOrEmpty(findVerifiedCoffee())
                .switchIfEmpty(Mono.error(new RuntimeException("Not Found Coffee")))
                .subscribe(
                        data -> log.info("{} : {}",data.getKorName(), data.getPrice()),
                        error -> log.error("# onError: {}",error.getMessage())
                );

    }

    private static Coffee findVerifiedCoffee() {
        return null;
    }
}
