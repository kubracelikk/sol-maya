package com.turkcell.solmaya.soap.business.abstracts;

import com.turkcell.solmaya.soap.business.dto.customer.*;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface CustomerService {

    @WebMethod
    @WebResult(name = "GetAllCustomersResponse")
    List<GetAllCustomersResponse> getAll();

    @WebMethod
    @WebResult(name = "GetCustomerResponse")
    GetCustomerResponse getById(@WebParam(name = "id") int id);

    @WebMethod
    @WebResult(name = "CreateCustomerResponse")
    CreateCustomerResponse add(@WebParam(name = "request") CreateCustomerRequest request);

    @WebMethod
    @WebResult(name = "UpdateCustomerResponse")
    UpdateCustomerResponse update(@WebParam(name = "id") int id, UpdateCustomerRequest request);

    @WebMethod
    void delete(@WebParam(name = "id") int id);
}
