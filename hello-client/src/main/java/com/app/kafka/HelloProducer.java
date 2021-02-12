package com.app.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class HelloProducer {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void send(int msg){
        kafkaTemplate.send("bye", String.valueOf(msg));
    }
}
