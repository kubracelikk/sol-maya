package com.turkcell.solmaya.business.dto.requests.create;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {
    private int categoryId;
    @NotBlank
    private String name;
    @Min(1)
    private double price;
    private String description;
    private CreatePropertyRequest propertyRequest;
}
