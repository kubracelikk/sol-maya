package com.turkcell.solmaya.soap.business.abstracts;

import com.turkcell.solmaya.soap.business.dto.order.*;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface OrderService {

    @WebMethod
    @WebResult(name = "GetAllOrdersResponse")
    List<GetAllOrdersResponse> getAll();

    @WebMethod
    @WebResult(name = "GetOrderResponse")
    GetOrderResponse getById(@WebParam(name = "id") int id);

    @WebMethod
    @WebResult(name = "CreateOrderResponse")
    CreateOrderResponse add(@WebParam(name = "request") CreateOrderRequest request);

    @WebMethod
    @WebResult(name = "UpdateOrderResponse")
    UpdateOrderResponse update(@WebParam(name = "id") int id, UpdateOrderRequest request);

    @WebMethod
    void delete(@WebParam(name = "id") int id);
}
