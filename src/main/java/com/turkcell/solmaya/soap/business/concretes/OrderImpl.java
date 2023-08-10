package com.turkcell.solmaya.soap.business.concretes;

import com.turkcell.solmaya.business.abstracts.CustomerService;
import com.turkcell.solmaya.business.abstracts.ProductService;
import com.turkcell.solmaya.entities.concretes.Customer;
import com.turkcell.solmaya.entities.concretes.Order;
import com.turkcell.solmaya.entities.enums.Status;
import com.turkcell.solmaya.repository.OrderRepository;
import com.turkcell.solmaya.soap.business.abstracts.OrderService;
import com.turkcell.solmaya.soap.business.dto.order.*;
import jakarta.jws.WebService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//("OrderService")
@WebService(endpointInterface = "com.turkcell.OrderService")
@AllArgsConstructor
public class OrderImpl implements OrderService {
    private final OrderRepository repository;
    private final ModelMapper mapper;
    private final CustomerService customerService;
    private final ProductService productService;

    @Override
    public List<GetAllOrdersResponse> getAll() {
        List<Order> orders = repository.findAll();
        orders.forEach(order -> order.setTotalPrice(getTotalPrice(order)));
        List<GetAllOrdersResponse> response = orders
                .stream()
                .map(order -> mapper.map(order, GetAllOrdersResponse.class))
                .toList();
        return response;
    }

    @Override
    public GetOrderResponse getById(int id) {
        // rules.checkIfOrderExists(id);
        Order order = repository.findById(id).orElseThrow();
        order.setTotalPrice(getTotalPrice(order));
        GetOrderResponse response = mapper.map(order, GetOrderResponse.class);
        return response;
    }

    @Override
    public CreateOrderResponse add(CreateOrderRequest request) {
        // rules.checkIfProductAvailable(productService.getById(request.getProductId()).getStatus());
        Order order = new Order();
        order.setProductId(request.getProductId());
        order.setPrice(request.getPrice());
        order.setQuantity(request.getQuantity());
        order.setTotalPrice(getTotalPrice(order));
        order.setCurrency(request.getCurrency());
        order.setId(0);
        order.setCustomer(mapper.map(customerService.getById(request.getCustomerId()), Customer.class));

        repository.save(order);
        productService.changeStatus(order.getProductId(), Status.UNAVAILABLE);

        CreateOrderResponse response = new CreateOrderResponse();
        response.setProductId(order.getProductId());
        response.setPrice(order.getPrice());
        response.setTotalPrice(getTotalPrice(order));
        response.setQuantity(order.getQuantity());
        response.setCurrency(order.getCurrency());
        response.setCustomerId(order.getCustomer().getId());
        response.setId(order.getId());
        return response;
    }

    @Override
    public UpdateOrderResponse update(int id, UpdateOrderRequest request) {
        //rules.checkIfOrderExists(id);
        Order order = new Order();
        order.setProductId(request.getProductId());
        order.setPrice(request.getPrice());
        order.setQuantity(request.getQuantity());
        order.setCurrency(request.getCurrency());
        order.setId(id);
        order.setCustomer(mapper.map(customerService.getById(request.getCustomerId()), Customer.class));

        repository.save(order);

        UpdateOrderResponse response = new UpdateOrderResponse();
        response.setProductId(order.getProductId());
        response.setPrice(order.getPrice());
        response.setTotalPrice(getTotalPrice(order));
        response.setQuantity(order.getQuantity());
        response.setCurrency(order.getCurrency());
        response.setCustomerId(order.getCustomer().getId());
        response.setId(order.getId());
        return response;
    }

    @Override
    public void delete(int id) {
        //rules.checkIfOrderExists(id);
        int productId = repository.findById(id).get().getProductId();
        productService.changeStatus(productId, Status.AVAILABLE);
        repository.deleteById(id);
    }


    private double getTotalPrice(Order order) {
        return order.getPrice() * order.getQuantity();
    }
}
