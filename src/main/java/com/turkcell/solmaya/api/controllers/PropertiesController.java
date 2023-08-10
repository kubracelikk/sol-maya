package com.turkcell.solmaya.api.controllers;

import com.turkcell.solmaya.business.abstracts.PropertyService;
import com.turkcell.solmaya.business.dto.requests.create.CreatePropertyRequest;
import com.turkcell.solmaya.business.dto.requests.update.UpdatePropertyRequest;
import com.turkcell.solmaya.business.dto.responses.create.CreatePropertyResponse;
import com.turkcell.solmaya.business.dto.responses.get.GetAllPropertiesResponse;
import com.turkcell.solmaya.business.dto.responses.get.GetPropertyResponse;
import com.turkcell.solmaya.business.dto.responses.update.UpdatePropertyResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/properties")
public class PropertiesController {
    private final PropertyService service;

    @GetMapping
    public List<GetAllPropertiesResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetPropertyResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatePropertyResponse add(@RequestBody CreatePropertyRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdatePropertyResponse update(@PathVariable int id, @RequestBody UpdatePropertyRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

}
