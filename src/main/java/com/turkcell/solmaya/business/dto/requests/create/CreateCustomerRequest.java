package com.turkcell.solmaya.business.dto.requests.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerRequest {
    //@NotBlank(message = "Kimlik numarası boş bırakılamaz.") //stringdeğerler,boş bırakılamaz
    //@Length(min = 11, max = 11, message = "Kimlik numarası 11 haneden oluşmak zorunda.")
    private String nationalIdentity;
    private String firstName;
    private String lastName;
    private String eMail;
    private String password;
    private String address;


   /* @NotEmpty(message = "Email alanı boş geçilemez")
    @Email(message = "Email adresinizi dogrulayınız")*/
}


