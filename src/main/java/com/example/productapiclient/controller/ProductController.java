package com.example.productapiclient.controller;

import com.example.productapiclient.model.ProductRequest;
import com.example.productapiclient.model.ProductResponse;
import com.example.productapiclient.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @Operation(summary = "Create a product")
    public Mono<ProductResponse> createProduct(@RequestBody ProductRequest request) {
        return productService.createProduct(request);
    }

    @GetMapping
    @Operation(summary = "Get all products from external API")
    public Mono<String> getAllProducts() {
        return productService.getAllProducts();
    }
}
