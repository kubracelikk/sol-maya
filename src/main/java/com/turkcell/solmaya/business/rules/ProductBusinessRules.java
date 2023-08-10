package com.turkcell.solmaya.business.rules;

import com.turkcell.solmaya.business.dto.requests.create.CreateProductRequest;
import com.turkcell.solmaya.common.constants.Messages;
import com.turkcell.solmaya.core.exceptions.BusinessException;
import com.turkcell.solmaya.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductBusinessRules {
    private final ProductRepository repository;

    public void checkIfProductExists(int id) {
        if (!repository.existsById(id))
            throw new BusinessException(Messages.Product.NotExists);
    }

    public void checkIfProperty(CreateProductRequest request) {
        if (request.getPropertyRequest().getCode().isEmpty()) {
            throw new BusinessException(Messages.Property.CodeNotFound);
        } else if (request.getPropertyRequest().getValue().isEmpty()) {
            throw new BusinessException(Messages.Property.ValueNotFound);
        }
    }

}
