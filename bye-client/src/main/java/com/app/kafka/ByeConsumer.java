package com.app.kafka;

import com.app.service.CountService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ByeConsumer {

    private final CountService countService;

    public ByeConsumer(CountService countService) {
        this.countService = countService;
    }

    @KafkaListener(topics ="bye")
    public void kafkaListener(){
        countService.increment();
    }
}
