package com.turkcell.solmaya.business.concretes;


import com.turkcell.solmaya.business.abstracts.CategoryService;
import com.turkcell.solmaya.business.dto.requests.create.CreateCategoryRequest;
import com.turkcell.solmaya.business.dto.requests.update.UpdateCategoryRequest;
import com.turkcell.solmaya.business.dto.responses.create.CreateCategoryResponse;
import com.turkcell.solmaya.business.dto.responses.get.GetAllCategoriesResponse;
import com.turkcell.solmaya.business.dto.responses.get.GetCategoryResponse;
import com.turkcell.solmaya.business.dto.responses.update.UpdateCategoryResponse;
import com.turkcell.solmaya.business.rules.CategoryBusinessRules;
import com.turkcell.solmaya.entities.concretes.Category;
import com.turkcell.solmaya.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private final CategoryRepository repository;
    private final ModelMapper mapper;
    private final CategoryBusinessRules rules;

    @Override
    public List<GetAllCategoriesResponse> getAll() {
        List<Category> categories = repository.findAll();
        List<GetAllCategoriesResponse> response = categories
                .stream()
                .map(category -> mapper.map(category, GetAllCategoriesResponse.class))
                .toList();
        return response;
    }

    @Override
    public GetCategoryResponse getById(int id) {
        rules.checkIfCategoryExists(id);
        Category category = repository.findById(id).orElseThrow();
        GetCategoryResponse response = mapper.map(category, GetCategoryResponse.class);
        return response;
    }

    @Override
    public CreateCategoryResponse add(CreateCategoryRequest request) {
        rules.checkIfCategoryExistsByName(request.getName());
        Category category = mapper.map(request, Category.class);
        category.setId(0);
        repository.save(category);
        CreateCategoryResponse response = mapper.map(category, CreateCategoryResponse.class);

        return response;
    }

    @Override
    public UpdateCategoryResponse update(int id, UpdateCategoryRequest request) {
        rules.checkIfCategoryExists(id);
        Category category = mapper.map(request, Category.class);
        category.setId(id);
        repository.save(category);
        UpdateCategoryResponse response = mapper.map(category, UpdateCategoryResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        rules.checkIfCategoryExists(id);
        repository.deleteById(id);
    }


}
