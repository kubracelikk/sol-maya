package com.turkcell.solmaya.business.concretes;

import com.turkcell.solmaya.business.abstracts.CustomerService;
import com.turkcell.solmaya.business.dto.requests.create.CreateCustomerRequest;
import com.turkcell.solmaya.business.dto.requests.update.UpdateCustomerRequest;
import com.turkcell.solmaya.business.dto.responses.create.CreateCustomerResponse;
import com.turkcell.solmaya.business.dto.responses.get.GetAllCustomersResponse;
import com.turkcell.solmaya.business.dto.responses.get.GetCustomerResponse;
import com.turkcell.solmaya.business.dto.responses.update.UpdateCustomerResponse;
import com.turkcell.solmaya.business.rules.CustomerBusinessRules;
import com.turkcell.solmaya.entities.concretes.Customer;
import com.turkcell.solmaya.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository repository;
    private final ModelMapper mapper;
    private final CustomerBusinessRules rules;


    @Override
    public List<GetAllCustomersResponse> getAll() {
        List<Customer> customers = repository.findAll();
        List<GetAllCustomersResponse> response = customers
                .stream()
                .map(customer -> mapper.map(customer, GetAllCustomersResponse.class))
                .toList();
        return response;
    }

    @Override
    public GetCustomerResponse getById(int id) {
        rules.checkIfCustomerExists(id);
        Customer customer = repository.findById(id).orElseThrow();
        GetCustomerResponse response = mapper.map(customer, GetCustomerResponse.class);
        return response;
    }

    @Override
    public CreateCustomerResponse add(CreateCustomerRequest request) {
        Customer customer = mapper.map(request, Customer.class);
        CheckNationalIDLength(request);
        customer.setId(0);
        repository.save(customer);
        CreateCustomerResponse response = mapper.map(customer, CreateCustomerResponse.class);

        return response;
    }

    @Override
    public UpdateCustomerResponse update(int id, UpdateCustomerRequest request) {
        rules.checkIfCustomerExists(id);
        Customer customer = mapper.map(request, Customer.class);
        customer.setId(id);
        repository.save(customer);
        UpdateCustomerResponse response = mapper.map(customer, UpdateCustomerResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        rules.checkIfCustomerExists(id);
        repository.deleteById(id);
    }

    private void CheckNationalIDLength(CreateCustomerRequest request) {
        if (request.getNationalIdentity().length() != 11) {
            throw new RuntimeException("Geçersiz TC Kimlik Numarası! Lütfen 11 haneli bir TC Kimlik Numarası giriniz.");
        }
    }
    
}
