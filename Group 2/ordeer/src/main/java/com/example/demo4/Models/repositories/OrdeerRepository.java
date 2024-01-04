package com.example.demo4.Models.repositories;

import com.example.demo4.Models.Ordeer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdeerRepository extends JpaRepository<Ordeer,String> {
}
