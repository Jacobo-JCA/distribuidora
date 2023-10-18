package com.example.distribuidora.service.impl;

import com.example.distribuidora.model.Client;
import com.example.distribuidora.repository.IClientRepo;
import com.example.distribuidora.repository.IGenericRepo;
import com.example.distribuidora.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl extends CRUDImpl<Client, Integer> implements IClientService {

    private final IClientRepo repo;
    @Override
    protected IGenericRepo<Client, Integer> getRepo() {
        return repo;
    }
}
