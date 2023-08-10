package com.turkcell.solmaya.business.abstracts;

import com.turkcell.solmaya.business.dto.requests.create.CreateCategoryRequest;
import com.turkcell.solmaya.business.dto.requests.update.UpdateCategoryRequest;
import com.turkcell.solmaya.business.dto.responses.create.CreateCategoryResponse;
import com.turkcell.solmaya.business.dto.responses.get.GetAllCategoriesResponse;
import com.turkcell.solmaya.business.dto.responses.get.GetCategoryResponse;
import com.turkcell.solmaya.business.dto.responses.update.UpdateCategoryResponse;

import java.util.List;

public interface CategoryService {

    List<GetAllCategoriesResponse> getAll();

    GetCategoryResponse getById(int id);

    CreateCategoryResponse add(CreateCategoryRequest request);

    UpdateCategoryResponse update(int id, UpdateCategoryRequest request);

    void delete(int id);
}
