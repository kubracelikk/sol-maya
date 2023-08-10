package com.turkcell.solmaya.api.controllers;

import com.turkcell.solmaya.business.abstracts.ProductService;
import com.turkcell.solmaya.business.dto.requests.create.CreateProductRequest;
import com.turkcell.solmaya.business.dto.requests.update.UpdateProductRequest;
import com.turkcell.solmaya.business.dto.responses.create.CreateProductResponse;
import com.turkcell.solmaya.business.dto.responses.get.GetAllProductsResponse;
import com.turkcell.solmaya.business.dto.responses.get.GetProductResponse;
import com.turkcell.solmaya.business.dto.responses.update.UpdateProductResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductsController {
    private final ProductService service;

    @GetMapping
    public List<GetAllProductsResponse> getAll(@RequestParam(defaultValue = "true") boolean includeUnavailable) {
        return service.getAll(includeUnavailable);
    }

    @GetMapping("/{id}")
    public GetProductResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CreateProductResponse> add(@Valid @RequestBody CreateProductRequest request) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("my-custom-header", "Product created");
        return new ResponseEntity<>(service.add(request), responseHeaders, 201);
    }

    @PutMapping("/{id}")
    public UpdateProductResponse update(@PathVariable int id, @RequestBody UpdateProductRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

}
