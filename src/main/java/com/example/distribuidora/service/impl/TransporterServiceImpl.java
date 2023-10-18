package com.example.distribuidora.service.impl;

import com.example.distribuidora.model.Transporter;
import com.example.distribuidora.repository.IGenericRepo;
import com.example.distribuidora.repository.ITransporterRepo;
import com.example.distribuidora.service.ITransporterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransporterServiceImpl extends CRUDImpl<Transporter, Integer> implements ITransporterService {

    private final ITransporterRepo repo;
    @Override
    protected IGenericRepo<Transporter, Integer> getRepo() {
        return repo;
    }
}
