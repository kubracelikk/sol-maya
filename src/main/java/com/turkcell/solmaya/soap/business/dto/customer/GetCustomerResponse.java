package com.turkcell.solmaya.soap.business.dto.customer;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Data;

@Data
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class GetCustomerResponse {
    private int id;
    private String nationalIdentity;
    private String firstName;
    private String lastName;
    private String eMail;
    private String password;
    private String address;
}
