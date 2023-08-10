package com.turkcell.solmaya.business.dto.responses.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCustomersResponse {
    private int id;
    private String nationalIdentity;
    private String firstName;
    private String lastName;
    private String eMail;
    private String password;
    private String address;
}
