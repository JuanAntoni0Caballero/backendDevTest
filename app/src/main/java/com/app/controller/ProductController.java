package com.app.controller;

import com.app.client.ProductClient;
import com.app.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductClient productClient;

    public ProductController(ProductClient productClient) {
        this.productClient = productClient;
    }

    @GetMapping("/{productId}/similar")
    public List<Product> getSimilarProducts(@PathVariable String productId) {
        List<String> similarIds = productClient.getSimilarProductIds(productId);
        return similarIds.stream()
                .map(productClient::getProductById)
                .filter(p -> p != null)
                .collect(Collectors.toList());
    }
}
