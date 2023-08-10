package com.turkcell.solmaya.repository;

import com.turkcell.solmaya.entities.concretes.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
