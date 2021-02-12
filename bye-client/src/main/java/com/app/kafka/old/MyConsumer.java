package com.app.kafka.old;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.stereotype.Component;

import java.io.Closeable;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;


public class MyConsumer implements Closeable {
    private Properties properties;
    private String topic;
    KafkaConsumer<String,String> consumer;


    public MyConsumer() {
        this.properties = new Properties();;
        propertiesConfig();
        this.consumer = new KafkaConsumer(properties);
    }

    public MyConsumer(String topic) {
        this.properties = new Properties();;
        this.topic = topic;
        propertiesConfig();
        this.consumer = new KafkaConsumer(properties);
        consumer.subscribe(Collections.singletonList(topic));
    }

    private void propertiesConfig(){
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG,"helloGroup");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    }

    public int getIntVal (int val){
        ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofSeconds(3));
        if(!consumerRecords.isEmpty()) {
//                System.out.println(consumerRecords.iterator().next().key() + " " + consumerRecords.iterator().next().value());
            return Integer.valueOf(consumerRecords.iterator().next().value());
        }else {
            return val;
        }

    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
        consumer.subscribe(Collections.singletonList(topic));
    }

    public KafkaConsumer<String, String> getConsumer() {
        return consumer;
    }

    public void setConsumer(KafkaConsumer<String, String> consumer) {
        this.consumer = consumer;
    }

    @Override
    public void close(){
        consumer.close();
    }
}
