package com.paras.kafka;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.paras.kafka.events.AssetEvent;
import com.paras.kafka.events.LightningEvent;

@SpringBootApplication
public class KafkaEventConsumer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(KafkaEventConsumer.class, args);
    }

    @KafkaListener(id="asset-listener", topics="asset")
    public void listen(AssetEvent event) {
        System.out.println("AssetEvent received: " + event);
    }

    @KafkaListener(id="lightning-listner", topics="lightning")
    public void listen(LightningEvent event) {
        System.out.println("LightningEvent received: " + event);
    }

    @KafkaHandler(isDefault = true)
    public void listenDefault(Object object) {
        System.out.println("Unkown type received: " + object);
    }

}