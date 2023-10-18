package com.example.distribuidora.service.impl;

import com.example.distribuidora.model.Category;
import com.example.distribuidora.repository.ICategoryRepo;
import com.example.distribuidora.repository.IGenericRepo;
import com.example.distribuidora.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends CRUDImpl<Category, Integer> implements ICategoryService {

    private final ICategoryRepo repo;
    @Override
    protected IGenericRepo<Category, Integer> getRepo() {
        return repo;
    }
}
