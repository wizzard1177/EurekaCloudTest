package com.app.kafka.old;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Component;

import java.io.Closeable;
import java.util.Properties;

public class MyProducer implements Closeable {
    private Properties properties;
    private String topic;
    KafkaProducer<String,String> producer;

    public MyProducer(){
        this.properties = new Properties();
        propertiesConfig();
        producer = new KafkaProducer(properties);
    }

    public MyProducer(String topic){
        this.properties = new Properties();
        this.topic=topic;
        propertiesConfig();
        producer = new KafkaProducer(properties);

    }

    private void propertiesConfig(){
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        properties.setProperty(ProducerConfig.CLIENT_ID_CONFIG,"helloClient");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer .class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    }

    public void send(String msg){
        producer.send(new ProducerRecord(topic,msg));
    }

    public void send(String key,String msg){
            producer.send(new ProducerRecord(topic, key,msg));
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public KafkaProducer<String, String> getProducer() {
        return producer;
    }

    @Override
    public void close(){
        producer.close();
    }
}
