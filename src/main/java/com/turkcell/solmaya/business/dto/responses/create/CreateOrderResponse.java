package com.turkcell.solmaya.business.dto.responses.create;


import com.turkcell.solmaya.entities.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderResponse {
    private int id;
    private int productId;
    private int customerId;
    private double price;
    private double totalPrice;
    private int quantity;
    private Currency currency;

}
