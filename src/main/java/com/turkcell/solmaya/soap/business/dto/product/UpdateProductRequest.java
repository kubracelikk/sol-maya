package com.turkcell.solmaya.soap.business.dto.product;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Data;

@Data
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class UpdateProductRequest {
    private int categoryId;
    private String name;
    private int quantity;
    private double price;
    private String description;
}
