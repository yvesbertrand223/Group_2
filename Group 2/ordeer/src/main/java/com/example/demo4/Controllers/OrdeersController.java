package com.example.demo4.Controllers;

import com.example.demo4.Models.Ordeer;
import com.example.demo4.Models.repositories.OrdeerRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@RestController
public class OrdeersController {

    @Autowired
    private OrdeerRepository OrdeerRepository;
    List<Ordeer> Ordeers =new ArrayList<>(
            Arrays.asList(
                    new Ordeer("1","Mango Juice","400","Inyange"),
                    new Ordeer("2","Akarusho","1000","Nyirangarama")
            )
    );
    @GetMapping("/Ordeers")
    public List<Ordeer> getOrdeers(){
        return OrdeerRepository.findAll();
    }

   @PostMapping("/Ordeer")
    public ResponseEntity addOrdeer(@RequestBody Ordeer Ordeer){
        Ordeer savedOrdeer=OrdeerRepository.save(Ordeer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrdeer);
   }
    @PutMapping("/Ordeer")
    public ResponseEntity updateOrdeer(@PathVariable String id, @RequestBody Ordeer Ordeer) {
        Ordeer OrdeerToUpdate=OrdeerRepository.findById(id).orElseThrow();
        OrdeerToUpdate.setCustomer_name(Ordeer.getCustomer_name());
        OrdeerToUpdate.setProduct_id(Ordeer.getProduct_id());
        OrdeerToUpdate.setQuantities(Ordeer.getQuantities());
        return ResponseEntity.status(HttpStatus.OK).body(Ordeer);
    };

    @DeleteMapping("Ordeer/{id}")
    public ResponseEntity deleteOrdeer(@PathVariable String id){
        Ordeer OrdeerToDelete=OrdeerRepository.findById(id).orElseThrow();
        OrdeerRepository.delete(OrdeerToDelete);
        return ResponseEntity.status(HttpStatus.OK).body(OrdeerToDelete);
    }

}
