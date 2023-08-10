package com.turkcell.solmaya.business.dto.responses.create;

import com.turkcell.solmaya.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductResponse {
    private int id;
    private int categoryId;
    private String name;
    private int quantity;
    private double price;
    private Status status;
    private String description;
}
