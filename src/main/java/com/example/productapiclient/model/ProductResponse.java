package com.example.productapiclient.model;

import lombok.Data;

@Data
public class ProductResponse {
    private String id;
    private String name;
    private Object data;
}
