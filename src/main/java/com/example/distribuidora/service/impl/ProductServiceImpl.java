package com.example.distribuidora.service.impl;

import com.example.distribuidora.model.Product;
import com.example.distribuidora.repository.IGenericRepo;
import com.example.distribuidora.repository.IProductRepo;
import com.example.distribuidora.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends CRUDImpl<Product, Integer> implements IProductService {

    private final IProductRepo repo;
    @Override
    protected IGenericRepo<Product, Integer> getRepo() {
        return repo;
    }
}
