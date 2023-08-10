package com.turkcell.solmaya.soap.business.dto.category;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Data;

@Data
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class GetCategoryResponse {
    private int id;
    private String name;
}
