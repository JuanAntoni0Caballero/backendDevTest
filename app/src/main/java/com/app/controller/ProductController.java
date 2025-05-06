package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")

public class ProductController {

    @GetMapping("/{productId}")
    public String getProduct(@PathVariable String productId) {
        return "Product details for product ID: " + productId;
    }
}
