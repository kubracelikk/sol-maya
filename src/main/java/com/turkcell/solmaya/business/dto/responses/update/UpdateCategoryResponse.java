package com.turkcell.solmaya.business.dto.responses.update;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCategoryResponse {
    private int id;
    private String name;
}
