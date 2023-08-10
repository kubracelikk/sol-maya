package com.turkcell.solmaya.repository;

import com.turkcell.solmaya.entities.concretes.Product;
import com.turkcell.solmaya.entities.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByStatusIsNot(Status status);

}
