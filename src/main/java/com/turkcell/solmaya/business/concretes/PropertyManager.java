package com.turkcell.solmaya.business.concretes;

import com.turkcell.solmaya.business.abstracts.PropertyService;
import com.turkcell.solmaya.business.dto.requests.create.CreatePropertyRequest;
import com.turkcell.solmaya.business.dto.requests.update.UpdatePropertyRequest;
import com.turkcell.solmaya.business.dto.responses.create.CreatePropertyResponse;
import com.turkcell.solmaya.business.dto.responses.get.GetAllPropertiesResponse;
import com.turkcell.solmaya.business.dto.responses.get.GetPropertyResponse;
import com.turkcell.solmaya.business.dto.responses.update.UpdatePropertyResponse;
import com.turkcell.solmaya.business.rules.PropertyBusinessRules;
import com.turkcell.solmaya.entities.concretes.Property;
import com.turkcell.solmaya.repository.PropertyRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PropertyManager implements PropertyService {
    private final PropertyRepository repository;
    private final ModelMapper mapper;
    private final PropertyBusinessRules rules;

    @Override
    public List<GetAllPropertiesResponse> getAll() {
        List<Property> properties = repository.findAll();
        List<GetAllPropertiesResponse> response = properties
                .stream()
                .map(property -> mapper.map(property, GetAllPropertiesResponse.class))
                .toList();
        return response;
    }

    @Override
    public GetPropertyResponse getById(int id) {
        rules.checkIfPropertyExists(id);
        Property property = repository.findById(id).orElseThrow();
        GetPropertyResponse response = mapper.map(property, GetPropertyResponse.class);
        return response;
    }

    @Override
    public CreatePropertyResponse add(CreatePropertyRequest request) {
        Property property = mapper.map(request, Property.class);
        property.setId(0);
        repository.save(property);
        CreatePropertyResponse response = mapper.map(property, CreatePropertyResponse.class);

        return response;
    }

    @Override
    public UpdatePropertyResponse update(int id, UpdatePropertyRequest request) {
        rules.checkIfPropertyExists(id);
        Property property = mapper.map(request, Property.class);
        property.setId(id);
        repository.save(property);
        UpdatePropertyResponse response = mapper.map(property, UpdatePropertyResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        rules.checkIfPropertyExists(id);
        repository.deleteById(id);
    }
}
