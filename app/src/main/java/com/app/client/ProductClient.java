package com.app.client;

import com.app.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductClient {

    private final RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:3001/product/";

    public ProductClient() {
        this.restTemplate = new RestTemplate();
    }

    public List<String> getSimilarProductIds(String productId) {
        try {
            String[] ids = restTemplate.getForObject(baseUrl + productId + "/similarids", String[].class);

            return Arrays.asList(ids);
        } catch (HttpClientErrorException.NotFound e) {
            return Collections.emptyList();
        }
    }

    public Product getProductById(String productId) {
        try {
            return restTemplate.getForObject(baseUrl + productId, Product.class);
        } catch (HttpClientErrorException.NotFound e) {
            return null;
        }
    }
}
