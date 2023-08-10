package com.turkcell.solmaya.repository;

import com.turkcell.solmaya.entities.concretes.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Integer> {
}
