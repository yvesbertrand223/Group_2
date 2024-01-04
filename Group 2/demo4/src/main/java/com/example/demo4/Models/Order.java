package com.example.demo4.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Order {

    @Id
    private String id;
    private String customer_name;
    private String product_id;

    private String quantities;

    public Order() {
    }

    public Order(String id, String customer_name, String product_id, String quantities) {
        /*this.id = id;*/
        this.customer_name = customer_name;
        this.product_id = product_id;
        this.quantities = quantities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getQuantities() {
        return quantities;
    }

    public void setQuantities(String quantities) {
        this.quantities = quantities;
    }
}
