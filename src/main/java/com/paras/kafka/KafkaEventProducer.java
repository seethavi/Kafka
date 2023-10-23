package com.paras.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import com.paras.kafka.events.LightningEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.lang.Math;

@SpringBootApplication
public class KafkaEventProducer {

    public static void main(String[] args) throws Exception {

        ConfigurableApplicationContext context = SpringApplication.run(KafkaEventProducer.class, args);

        MessageProducer producer = context.getBean(MessageProducer.class);
        producer.sendMessages(1000, 100, 0);

        Thread.sleep(5000);
        context.close();
    }

    @Bean
    public MessageProducer messageProducer() {
        return new MessageProducer();
    }

    public static class MessageProducer {

        @Autowired
        private KafkaTemplate<String, LightningEvent> lightningKafkaTemplate;

        @Value(value = "${lightning.topic.name}")
        private String lightningTopicName;

        @Value(value = "${asset.topic.name}")
        private String assetTopicName;

        public void sendMessages(int start, int num, int delay) {
            LongStream lightningStream = IntStream.range(start, start + num).asLongStream();

            lightningStream.forEach(
                v -> {
                    long timestamp = System.currentTimeMillis()/1000;
                    System.out.printf("Sending event:" + (v - start + 1));
                    lightningKafkaTemplate.send(
                        lightningTopicName, 
                        new LightningEvent(
                                "Lightning " + (v - start), 
                                timestamp, 
                                v, 
                                (long) Math.random() * 1000,
                                (long) Math.random() * 1000
                            )
                    );
                }
            );



        }

    }

}