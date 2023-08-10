package com.turkcell.solmaya.business.rules;

import com.turkcell.solmaya.common.constants.Messages;
import com.turkcell.solmaya.core.exceptions.BusinessException;
import com.turkcell.solmaya.entities.enums.Status;
import com.turkcell.solmaya.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderBusinessRules {
    private final OrderRepository repository;

    public void checkIfOrderExists(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.Order.NotExists);
        }
    }

    public void checkIfProductAvailable(Status status) {
        if (!status.equals(Status.AVAILABLE)) {
            throw new BusinessException(Messages.Product.NotAvailable);
        }
    }
}
