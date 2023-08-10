package com.turkcell.solmaya.api.controllers;

import com.turkcell.solmaya.business.abstracts.OrderService;
import com.turkcell.solmaya.business.dto.requests.create.CreateOrderRequest;
import com.turkcell.solmaya.business.dto.requests.update.UpdateOrderRequest;
import com.turkcell.solmaya.business.dto.responses.create.CreateOrderResponse;
import com.turkcell.solmaya.business.dto.responses.get.GetAllOrdersResponse;
import com.turkcell.solmaya.business.dto.responses.get.GetOrderResponse;
import com.turkcell.solmaya.business.dto.responses.update.UpdateOrderResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/orders")
public class OrdersController {
    private final OrderService service;

    @GetMapping
    public List<GetAllOrdersResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetOrderResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateOrderResponse add(@RequestBody CreateOrderRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateOrderResponse update(@PathVariable int id, @RequestBody UpdateOrderRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }


}
