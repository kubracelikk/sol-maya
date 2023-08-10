package com.turkcell.solmaya.business.dto.requests.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePropertyRequest {
    private int productId;
    private String code;
    private String value;

}
