package com.turkcell.solmaya.business.dto.responses.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePropertyResponse {
    private int id;
    private int productId;
    private String code;
    private String value;

}
