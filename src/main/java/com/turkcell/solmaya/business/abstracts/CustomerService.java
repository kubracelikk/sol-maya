package com.turkcell.solmaya.business.abstracts;

import com.turkcell.solmaya.business.dto.requests.create.CreateCustomerRequest;
import com.turkcell.solmaya.business.dto.requests.update.UpdateCustomerRequest;
import com.turkcell.solmaya.business.dto.responses.create.CreateCustomerResponse;
import com.turkcell.solmaya.business.dto.responses.get.GetAllCustomersResponse;
import com.turkcell.solmaya.business.dto.responses.get.GetCustomerResponse;
import com.turkcell.solmaya.business.dto.responses.update.UpdateCustomerResponse;

import java.util.List;

public interface CustomerService {

    List<GetAllCustomersResponse> getAll();
    GetCustomerResponse getById(int id);

    CreateCustomerResponse add(CreateCustomerRequest request);

    UpdateCustomerResponse update(int id, UpdateCustomerRequest request);

    void delete(int id);
}
