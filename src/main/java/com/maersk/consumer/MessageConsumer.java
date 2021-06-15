package com.maersk.consumer;

import com.maersk.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageConsumer {

    @KafkaListener(topics = "${test.topic}")
    public void listenWithHeaders(@Payload Message message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        log.info("Received Message [ {} ] from partition - {}.", message.toString(), partition);
    }
}
