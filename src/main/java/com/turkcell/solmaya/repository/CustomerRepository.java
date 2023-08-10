package com.turkcell.solmaya.repository;

import com.turkcell.solmaya.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
