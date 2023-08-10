package com.turkcell.solmaya.soap.business.dto.product;

import com.turkcell.solmaya.business.dto.requests.create.CreatePropertyRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Data;

@Data
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateProductRequest {
    private int categoryId;
    @NotBlank
    private String name;
    @Min(1)
    private double price;
    private String description;
    private CreatePropertyRequest propertyRequest;
}
