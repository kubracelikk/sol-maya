package com.turkcell.solmaya.business.dto.responses.get;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCategoriesResponse {
    private int id;
    private String name;
}
