package com.turkcell.solmaya.soap.business.dto.product;

import com.turkcell.solmaya.entities.enums.Status;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Data;

@Data
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class GetAllProductsResponse {
    private int id;
    private int categoryId;
    private String name;
    private int quantity;
    private double price;
    private Status status;
    private String description;
}
