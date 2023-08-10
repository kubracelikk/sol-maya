package com.turkcell.solmaya.soap.business.abstracts;

import com.turkcell.solmaya.soap.business.dto.category.*;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import java.util.List;

@WebService

public interface CategoryService {

    @WebMethod
    @WebResult(name = "GetAllCategoriesResponse")
    List<GetAllCategoriesResponse> getAll();

    @WebMethod
    @WebResult(name = "GetCategoryResponse")
    GetCategoryResponse getById(@WebParam(name = "id") int id);

    @WebMethod
    @WebResult(name = "CreateCategoryResponse")
    CreateCategoryResponse add(@WebParam(name = "request") CreateCategoryRequest request);

    @WebMethod
    @WebResult(name = "UpdateCategoryResponse")
    UpdateCategoryResponse update(@WebParam(name = "id") int id, UpdateCategoryRequest request);

    @WebMethod
    void delete(@WebParam(name = "id") int id);
}
