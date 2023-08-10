package com.turkcell.solmaya.business.abstracts;

import com.turkcell.solmaya.business.dto.requests.create.CreateProductRequest;
import com.turkcell.solmaya.business.dto.requests.update.UpdateProductRequest;
import com.turkcell.solmaya.business.dto.responses.create.CreateProductResponse;
import com.turkcell.solmaya.business.dto.responses.get.GetAllProductsResponse;
import com.turkcell.solmaya.business.dto.responses.get.GetProductResponse;
import com.turkcell.solmaya.business.dto.responses.update.UpdateProductResponse;
import com.turkcell.solmaya.entities.enums.Status;

import java.util.List;

public interface ProductService {

    List<GetAllProductsResponse> getAll(boolean includeUnavailable);

    GetProductResponse getById(int id);

    CreateProductResponse add(CreateProductRequest request);

    UpdateProductResponse update(int id, UpdateProductRequest request);

    void delete(int id);

    void changeStatus(int productId, Status status);
}
