package com.turkcell.solmaya.business.dto.responses.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePropertyResponse {
    private int id;
    private int productId;
    private String code;
    private String value;

}
