package com.app.kafka;

import com.app.service.CountService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class HelloConsumer {

    private final CountService countService;

    public HelloConsumer(CountService countService) {
        this.countService = countService;
    }

    @KafkaListener(topics ="hello")
    public void kafkaListener(){
        countService.increment();
    }
}
