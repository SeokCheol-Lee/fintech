package com.example.kafka.producer;

import com.example.kafka.KafkaTopic;
import com.example.kafka.dto.LoanRequestDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoanRequestSender {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void sendMessage(KafkaTopic topic, LoanRequestDto loanRequestDto)
        throws JsonProcessingException {
        kafkaTemplate.send(topic.getTopicName(), objectMapper.writeValueAsString(loanRequestDto));
    }
}
