package com.example.productapiclient.model;

import java.util.Map;
import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private Map<String, String> data;
}
