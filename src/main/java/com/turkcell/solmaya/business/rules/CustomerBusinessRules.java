package com.turkcell.solmaya.business.rules;

import com.turkcell.solmaya.common.constants.Messages;
import com.turkcell.solmaya.core.exceptions.BusinessException;
import com.turkcell.solmaya.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerBusinessRules {
    private final CustomerRepository repository;

    public void checkIfCustomerExists(int id) {
        if (!repository.existsById(id)) throw new BusinessException(Messages.Customer.NotExists);
    }


}
