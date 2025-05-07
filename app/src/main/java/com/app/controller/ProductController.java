package com.app.controller;

import com.app.client.ProductClient;
import com.app.exceptions.ErrorDetails;
import com.app.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getSimilarProducts(@PathVariable String productId) {
        List<String> similarIds = productClient.getSimilarProductIds(productId);

        if (similarIds.isEmpty()) {
            ErrorDetails errorDetails = new ErrorDetails("Product not found");
            return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
        }

        List<Product> similarProducts = similarIds.stream()
                .map(productClient::getProductById)
                .filter(p -> p != null)
                .collect(Collectors.toList());

        return ResponseEntity.ok(similarProducts);
    }
}
