package com.imooc.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaReceiver {

    public KafkaReceiver() {
        System.out.println("=============================");
    }

    private static final Logger LOG = LoggerFactory.getLogger(KafkaReceiver.class);

    /*@KafkaListener(topics = "${app.topic.foo}")
    public void receive(@Payload String message,
                        @Headers MessageHeaders headers) {
        LOG.info("received message='{}'", message);
        headers.keySet().forEach(key -> LOG.info("{}: {}", key, headers.get(key)));
    }*/


    @KafkaListener(topics = { "${app.topic.foo}" })
    public void receive(String message) {
        LOG.info("received message = {}", new Object[] { message });
    }
}
