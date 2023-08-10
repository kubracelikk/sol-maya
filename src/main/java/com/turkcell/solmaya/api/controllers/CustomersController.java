package com.turkcell.solmaya.api.controllers;

import com.turkcell.solmaya.business.abstracts.CustomerService;
import com.turkcell.solmaya.business.dto.requests.create.CreateCustomerRequest;
import com.turkcell.solmaya.business.dto.requests.update.UpdateCustomerRequest;
import com.turkcell.solmaya.business.dto.responses.create.CreateCustomerResponse;
import com.turkcell.solmaya.business.dto.responses.get.GetAllCustomersResponse;
import com.turkcell.solmaya.business.dto.responses.get.GetCustomerResponse;
import com.turkcell.solmaya.business.dto.responses.update.UpdateCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/customers")
public class CustomersController {
    private final CustomerService service;

    @GetMapping
    public List<GetAllCustomersResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetCustomerResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CreateCustomerResponse> add(@Valid @RequestBody CreateCustomerRequest request) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("my-custom-header", "Customer created");
        return new ResponseEntity<>(service.add(request), responseHeaders, 201);

    }

    @PutMapping("/{id}")
    public UpdateCustomerResponse update(@PathVariable int id, @RequestBody UpdateCustomerRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

}
