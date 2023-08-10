package com.turkcell.solmaya.soap.business.abstracts;

import com.turkcell.solmaya.entities.enums.Status;
import com.turkcell.solmaya.soap.business.dto.product.*;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface ProductService {

    @WebMethod
    @WebResult(name = "GetAllProductsResponse")
    List<GetAllProductsResponse> getAll(boolean includeUnavailable);

    @WebMethod
    @WebResult(name = "GetProductResponse")
    GetProductResponse getById(@WebParam(name = "id") int id);

    @WebMethod
    @WebResult(name = "CreateProductResponse")
    CreateProductResponse add(@WebParam(name = "request") CreateProductRequest request);

    @WebMethod
    @WebResult(name = "UpdateProductResponse")
    UpdateProductResponse update(@WebParam(name = "id") int id, UpdateProductRequest request);

    @WebMethod
    void delete(@WebParam(name = "id") int id);

    //@WebMethod
    void changeStatus(int productId, Status status);
}
