package com.turkcell.solmaya.business.dto.requests.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {
    private int categoryId;
    private String name;
    private int quantity;
    private double price;
    private String description;
}
