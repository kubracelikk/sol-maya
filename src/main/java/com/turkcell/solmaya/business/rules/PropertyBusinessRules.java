package com.turkcell.solmaya.business.rules;

import com.turkcell.solmaya.common.constants.Messages;
import com.turkcell.solmaya.core.exceptions.BusinessException;
import com.turkcell.solmaya.repository.PropertyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PropertyBusinessRules {
    private final PropertyRepository repository;

    public void checkIfPropertyExists(int id) {
        if (!repository.existsById(id))
            throw new BusinessException(Messages.Property.NotExists);
    }
}
