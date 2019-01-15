package com.epam.mvc.smoke.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class Product implements Serializable {
    private int id;
    private String name;
    private int price;
    private String description;

    public Product() {
    }

    public Product(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
