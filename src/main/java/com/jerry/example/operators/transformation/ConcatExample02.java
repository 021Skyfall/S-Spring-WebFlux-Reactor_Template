package com.jerry.example.operators.transformation;

import com.jerry.example.operators.sample_data.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class ConcatExample02 {
    public static void main(String[] args) {
        Flux.concat(Flux.fromIterable(SampleData.salesOfCafeA),
                Flux.fromIterable(SampleData.salesOfCafeB),
                Flux.fromIterable(SampleData.salesOfCafeC))
                .reduce(Integer::sum)
                .subscribe(data -> log.info("# total sales: {}",data));
    }
}
