package com.turkcell.solmaya.repository;

import com.turkcell.solmaya.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    boolean existsByNameIgnoreCase(String name); //aynı isimde olmasını engeller,büyük küçük harf


}
