package com.DAO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Setter
@Getter
public class Product {

    @Id
    private String product_id;
    private String brand;
    private String category;
    private String price;
    private List<Object> reviews;

    public Product() {
    }

    public Product(String product_id, String brand, String category, String price, List<Object> reviews) {
        this.product_id = product_id;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.reviews = reviews;
    }

}