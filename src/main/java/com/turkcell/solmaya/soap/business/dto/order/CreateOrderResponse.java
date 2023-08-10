package com.turkcell.solmaya.soap.business.dto.order;

import com.turkcell.solmaya.entities.enums.Currency;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Data;

@Data
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateOrderResponse {
    private int id;
    private int productId;
    private int customerId;
    private double price;
    private double totalPrice;
    private int quantity;
    private Currency currency;
}
