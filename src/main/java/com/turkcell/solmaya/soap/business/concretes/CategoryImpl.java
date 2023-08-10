package com.turkcell.solmaya.soap.business.concretes;

import com.turkcell.solmaya.entities.concretes.Category;
import com.turkcell.solmaya.repository.CategoryRepository;
import com.turkcell.solmaya.soap.business.abstracts.CategoryService;
import com.turkcell.solmaya.soap.business.dto.category.*;
import jakarta.jws.WebService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//("CategoryService")
@WebService(endpointInterface = "com.turkcell.CategoryService")
@AllArgsConstructor
public class CategoryImpl implements CategoryService {
    private final CategoryRepository repository;
    private final ModelMapper mapper;

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
        //rules.checkIfCategoryExists(id);
        Category category = repository.findById(id).orElseThrow();
        GetCategoryResponse response = mapper.map(category, GetCategoryResponse.class);
        return response;
    }


    @Override
    public CreateCategoryResponse add(CreateCategoryRequest request) {
        Category category = mapper.map(request, Category.class);
        category.setId(0);
        repository.save(category);
        CreateCategoryResponse response = mapper.map(category, CreateCategoryResponse.class);

        return response;
    }

    @Override
    public UpdateCategoryResponse update(int id, UpdateCategoryRequest request) {
        //rules.checkIfCategoryExists(id);
        Category category = mapper.map(request, Category.class);
        category.setId(id);
        repository.save(category);
        UpdateCategoryResponse response = mapper.map(category, UpdateCategoryResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
