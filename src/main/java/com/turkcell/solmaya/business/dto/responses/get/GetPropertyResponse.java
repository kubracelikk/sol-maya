package com.turkcell.solmaya.business.dto.responses.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetPropertyResponse {
    private int id;
    private int productId;
    private String code;
    private String value;
}
