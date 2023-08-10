package com.turkcell.solmaya.business.abstracts;

import com.turkcell.solmaya.business.dto.requests.create.CreateOrderRequest;
import com.turkcell.solmaya.business.dto.requests.update.UpdateOrderRequest;
import com.turkcell.solmaya.business.dto.responses.create.CreateOrderResponse;
import com.turkcell.solmaya.business.dto.responses.get.GetAllOrdersResponse;
import com.turkcell.solmaya.business.dto.responses.get.GetOrderResponse;
import com.turkcell.solmaya.business.dto.responses.update.UpdateOrderResponse;

import java.util.List;

public interface OrderService {

    List<GetAllOrdersResponse> getAll();

    GetOrderResponse getById(int id);

    CreateOrderResponse add(CreateOrderRequest request);

    UpdateOrderResponse update(int id, UpdateOrderRequest request);

    void delete(int id);
}
