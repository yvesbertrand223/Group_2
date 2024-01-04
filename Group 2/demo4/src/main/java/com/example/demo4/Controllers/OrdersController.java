package com.example.demo4.Controllers;

import com.example.demo4.Models.Order;
import com.example.demo4.Models.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class OrdersController {

    @Autowired
    private OrderRepository orderRepository;
    List<Order> orders =new ArrayList<>(
            Arrays.asList(
                    new Order("1","Steve","1","4"),
                    new Order("2","Kirenga","2","5")
            )
    );
    @GetMapping("/get-orders")
    public List<Order> getOrders(){return orderRepository.findAll();}

    @PostMapping("/add-order")
    public List<Order> addOrder(@RequestBody Order order){
        orders.add(order);
        return orders;
    }
    @PutMapping("/update-order")
    public List<Order> updateProduct(@RequestBody Order order){
        orders.stream()
                .filter(c-> c.getId().equals(order.getId()))
                .forEach(c->{
                    c.setCustomer_name(order.getCustomer_name());
                    c.setProduct_id(order.getProduct_id());
                    c.setQuantities(order.getQuantities());
                });
        return orders;
    }
    @DeleteMapping("delete-order/{id}")
    public List<Order> deleteProduct(@PathVariable String id){
        orders.removeIf(c-> c.getId().equals(id));
        return orders;
    }
    }

