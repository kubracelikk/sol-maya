package com.turkcell.solmaya.business.dto.requests.create;

import com.turkcell.solmaya.entities.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {
    private int productId;
    private int customerId;
    private double price;
    private int quantity;
    private Currency currency;

}
