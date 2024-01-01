package com.example.consumer.kafka;

import com.example.kafka.dto.LoanRequestDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoanRequestConsumer {

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = {"loan_request"}, groupId = "fintech")
    public void loanRequestTopicConsumer(String message) throws JsonProcessingException {
        LoanRequestDto loanRequestKafkaDto = objectMapper.readValue(message, LoanRequestDto.class);
    }

}
