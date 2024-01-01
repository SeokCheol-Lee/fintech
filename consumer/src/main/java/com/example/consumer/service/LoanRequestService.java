package com.example.consumer.service;

import com.example.consumer.dto.ReviewResponseDto;
import com.example.domain.domain.LoanReview;
import com.example.domain.repository.LoanReviewRepository;
import com.example.kafka.dto.LoanRequestDto;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@RequiredArgsConstructor
@Service
public class LoanRequestService {

    private final LoanReviewRepository loanReviewRepository;
    private final String cssUrl = "http://localhost:8081/css/api/v1/request";

    public void loanRequest(LoanRequestDto loanRequestDto){
        ReviewResponseDto reviewResult = loanRequestToCb(loanRequestDto);
        saveLoanReviewData(reviewResult.toLoanReviewEntity());
    }

    private ReviewResponseDto loanRequestToCb(LoanRequestDto loanRequestDto){

        HttpClient httpClient = HttpClient.create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 1000)
            .responseTimeout(Duration.ofMillis(1000))
            .doOnConnected(conn ->
                conn.addHandlerLast(new ReadTimeoutHandler(1000, TimeUnit.MILLISECONDS))
                    .addHandlerLast(new WriteTimeoutHandler(1000,TimeUnit.MILLISECONDS)));

        WebClient client = WebClient.builder()
            .baseUrl(cssUrl)
            .clientConnector(new ReactorClientHttpConnector(httpClient))
            .build();

        return client.post()
            .body(Mono.just(loanRequestDto), LoanRequestDto.class)
            .retrieve()
            .bodyToMono(ReviewResponseDto.class)
            .block();
    }

    private void saveLoanReviewData(LoanReview loanReview){
        loanReviewRepository.save(loanReview);
    }
}
