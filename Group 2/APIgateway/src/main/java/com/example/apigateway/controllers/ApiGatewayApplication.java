package com.example.apigateway.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

@RestController
@RequestMapping("/api")
class ApiController {

    private final RestTemplate restTemplate;

    @Value("http://localhost:8081/Ordeers")
    private String orderMicroserviceUrl;

    @Value("http://localhost:8080/Products")
    private String productMicroserviceUrl;

    public ApiController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<String> getOrder(@PathVariable String orderId) {
        String url = orderMicroserviceUrl + "/orders/" + orderId;
        return restTemplate.getForEntity(url, String.class);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<String> getProduct(@PathVariable String productId) {
        String url = productMicroserviceUrl + "/products/" + productId;
        return restTemplate.getForEntity(url, String.class);
    }


}
