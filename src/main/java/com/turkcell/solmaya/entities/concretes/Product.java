package com.turkcell.solmaya.entities.concretes;

import com.turkcell.solmaya.entities.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //ürün kodu ekle
    private String name;
    private double price;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToMany(mappedBy = "products")
    private List<Order> orders = new ArrayList<>();
    @OneToOne(mappedBy = "product")
    private Property property;

}
