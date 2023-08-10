package com.turkcell.solmaya.business.rules;

import com.turkcell.solmaya.common.constants.Messages;
import com.turkcell.solmaya.core.exceptions.BusinessException;
import com.turkcell.solmaya.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryBusinessRules {
    private final CategoryRepository repository;

    public void checkIfCategoryExists(int id) {
        if (!repository.existsById(id)) throw new BusinessException(Messages.Category.NotExists);
    }

    public void checkIfCategoryExistsByName(String name) {
        if (repository.existsByNameIgnoreCase(name)) {
            throw new BusinessException(Messages.Category.Exists);
        }
    }
}
