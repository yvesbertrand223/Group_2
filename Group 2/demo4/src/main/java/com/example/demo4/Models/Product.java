package com.example.demo4.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    private String id;
    private String name;
    private String price;

    private String description;



    public Product() {
    }

    public Product(String id, String name, String price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description=description;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String department) {
        this.description = department;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
