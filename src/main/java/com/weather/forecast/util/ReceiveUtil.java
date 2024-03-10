package com.weather.forecast.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ReceiveUtil {
    private final WebClient webClient;

    @Autowired
    public ReceiveUtil(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }
    // Method to create a Mono from a value
    public <T> Mono<T> createMono(T value) {
        return Mono.just(value);
    }

    // Method to fetch data using WebClient
    public <T> Mono<T> fetchData(String url, ParameterizedTypeReference<T> responseType) {
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(responseType);
    }
}
