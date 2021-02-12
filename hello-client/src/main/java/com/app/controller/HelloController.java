package com.app.controller;

import com.app.kafka.HelloProducer;
import com.app.service.CountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final CountService countService;
    private final HelloProducer producer;

    public HelloController(CountService service, HelloProducer producer) {
        this.countService = service;
        this.producer = producer;
    }


    @GetMapping("/hello")
    public String hello() {
        producer.send(0);
        return "Hello! Вы попрощались "+countService.getCounter().getCount();
    }
}
