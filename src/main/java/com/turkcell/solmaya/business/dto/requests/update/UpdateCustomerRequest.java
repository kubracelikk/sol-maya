package com.turkcell.solmaya.business.dto.requests.update;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerRequest {
    @NotBlank(message = "Kimlik numarası boş bırakılamaz.") //stringdeğerler,boş bırakılamaz
    @Length(min = 11, max = 11, message = "Kimlik numarası 11 haneden oluşmak zorunda.")
    private String nationalIdentity;
    private String firstName;
    private String lastName;
    private String eMail;
    private String password;
    private String address;
}
