package com.maersk.controller;

import com.maersk.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.stream.IntStream;

@RestController
@RequestMapping("/message")
@Slf4j
public class ProducerController {

    @Value("${test.topic:saurav-topic}")
    private String topic;

    private final KafkaTemplate<String, Message> kafkaTemplate;

    public ProducerController(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("{count}")
    public String send(@RequestBody Message message, @PathVariable(value = "count") int count) {
        final String payload = message.getPayload();
        log.info("Sending payload " + payload);
        IntStream.range(1, count + 1).forEach(i -> this.kafkaTemplate.send(topic, getMessage(payload, i)));
        return "Message Sent";
    }

    Message getMessage(final String payload, final int id) {
        Message msg = new Message();
        msg.setId(id);
        msg.setPayload(payload);
        return msg;
    }
}
