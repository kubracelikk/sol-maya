package com.turkcell.solmaya.business.concretes;

import com.turkcell.solmaya.business.abstracts.ProductService;
import com.turkcell.solmaya.business.abstracts.PropertyService;
import com.turkcell.solmaya.business.dto.requests.create.CreateProductRequest;
import com.turkcell.solmaya.business.dto.requests.update.UpdateProductRequest;
import com.turkcell.solmaya.business.dto.responses.create.CreateProductResponse;
import com.turkcell.solmaya.business.dto.responses.get.GetAllProductsResponse;
import com.turkcell.solmaya.business.dto.responses.get.GetProductResponse;
import com.turkcell.solmaya.business.dto.responses.update.UpdateProductResponse;
import com.turkcell.solmaya.business.rules.ProductBusinessRules;
import com.turkcell.solmaya.entities.concretes.Product;
import com.turkcell.solmaya.entities.enums.Status;
import com.turkcell.solmaya.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private final ProductRepository repository;
    private final ModelMapper mapper;
    private final ProductBusinessRules rules;
    private final PropertyService propertyService;

    @Override
    public List<GetAllProductsResponse> getAll(boolean includeUnavailable) {
        List<Product> products = filterProductsByUnavailableStatus(includeUnavailable);
        List<GetAllProductsResponse> response = products
                .stream()
                .map(product -> mapper.map(product, GetAllProductsResponse.class))
                .toList();
        return response;
    }

    @Override
    public GetProductResponse getById(int id) {
        rules.checkIfProductExists(id);
        Product product = repository.findById(id).orElseThrow();
        GetProductResponse response = mapper.map(product, GetProductResponse.class);
        return response;
    }

    @Override
    public CreateProductResponse add(CreateProductRequest request) {
        Product product = mapper.map(request, Product.class);
        rules.checkIfProperty(request);
        product.setId(0);
        product.setStatus(Status.AVAILABLE);
        repository.save(product);
        CreateProductResponse response = mapper.map(product, CreateProductResponse.class);

        return response;
    }


    @Override
    public UpdateProductResponse update(int id, UpdateProductRequest request) {
        rules.checkIfProductExists(id);
        Product product = mapper.map(request, Product.class);
        product.setId(id);
        repository.save(product);
        UpdateProductResponse response = mapper.map(product, UpdateProductResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        rules.checkIfProductExists(id);
        repository.deleteById(id);
    }

    @Override
    public void changeStatus(int productId, Status status) {
        Product product = repository.findById(productId).orElseThrow();
        product.setStatus(status);
        repository.save(product);

    }

    private List<Product> filterProductsByUnavailableStatus(boolean includeUnavailable) {
        if (includeUnavailable) {
            return repository.findAll();
        }
        return repository.findAllByStatusIsNot(Status.UNAVAILABLE);
    }
}
