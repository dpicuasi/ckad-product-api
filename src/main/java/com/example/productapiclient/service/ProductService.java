package com.example.productapiclient.service;

import com.example.productapiclient.model.ProductRequest;
import com.example.productapiclient.model.ProductResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    private final WebClient webClient;

    public ProductService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://api.restful-api.dev")
                .defaultHeader("Content-Type", "application/json")
                .defaultHeader("User-Agent", "Mozilla/5.0")
                .build();
    }

    public Mono<ProductResponse> createProduct(ProductRequest request) {
        return webClient.post()
                .uri("/objects")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(ProductResponse.class);
    }

    public Mono<String> getAllProducts() {
        return webClient.get()
                .uri("/objects")
                .retrieve()
                .bodyToMono(String.class);
    }
}
