package com.turkcell.solmaya.business.abstracts;

import com.turkcell.solmaya.business.dto.requests.create.CreatePropertyRequest;
import com.turkcell.solmaya.business.dto.requests.update.UpdatePropertyRequest;
import com.turkcell.solmaya.business.dto.responses.create.CreatePropertyResponse;
import com.turkcell.solmaya.business.dto.responses.get.GetAllPropertiesResponse;
import com.turkcell.solmaya.business.dto.responses.get.GetPropertyResponse;
import com.turkcell.solmaya.business.dto.responses.update.UpdatePropertyResponse;

import java.util.List;

public interface PropertyService {

    List<GetAllPropertiesResponse> getAll();

    GetPropertyResponse getById(int id);

    CreatePropertyResponse add(CreatePropertyRequest request);

    UpdatePropertyResponse update(int id, UpdatePropertyRequest request);

    void delete(int id);
}
