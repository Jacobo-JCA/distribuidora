package com.example.distribuidora.service.impl;

import com.example.distribuidora.model.Provider;
import com.example.distribuidora.repository.IGenericRepo;
import com.example.distribuidora.repository.IProviderRepo;
import com.example.distribuidora.service.IProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl extends CRUDImpl<Provider, Integer> implements IProviderService {

    private final IProviderRepo repo;
    @Override
    protected IGenericRepo<Provider, Integer> getRepo() {
        return repo;
    }
}
