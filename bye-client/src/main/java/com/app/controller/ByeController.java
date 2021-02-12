package com.app.controller;

import com.app.kafka.ByeProducer;
import com.app.service.CountService;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ByeController {

    private final ByeProducer producer;
    private final CountService countService;

    public ByeController(ByeProducer producer, CountService countService) {
        this.producer = producer;
        this.countService = countService;
    }


    @GetMapping("/bye")
    public String bye() {
        producer.send(0);
        return "Bye! Вы поздоровались " + countService.getCounter().getCount();
    }
}