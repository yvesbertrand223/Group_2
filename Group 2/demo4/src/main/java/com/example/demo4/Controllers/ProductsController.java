package com.example.demo4.Controllers;

import com.example.demo4.Models.Product;
import com.example.demo4.Models.repositories.ProductRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@RestController
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;
    List<Product> products =new ArrayList<>(
            Arrays.asList(
                    new Product("1","Mango Juice","400","Inyange"),
                    new Product("2","Akarusho","1000","Nyirangarama")
            )
    );
    @GetMapping("/Products")
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

   @PostMapping("/Product")
    public ResponseEntity addProduct(@RequestBody Product product){
        Product savedProduct=productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
   }
    @PutMapping("/Product")
    public ResponseEntity updateProduct(@PathVariable String id, @RequestBody Product product) {
        Product productToUpdate=productRepository.findById(id).orElseThrow();
        productToUpdate.setName(product.getName());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setPrice(product.getPrice());
        return ResponseEntity.status(HttpStatus.OK).body(product);
    };

    @DeleteMapping("Product/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id){
        Product productToDelete=productRepository.findById(id).orElseThrow();
        productRepository.delete(productToDelete);
        return ResponseEntity.status(HttpStatus.OK).body(productToDelete);
    }

}
