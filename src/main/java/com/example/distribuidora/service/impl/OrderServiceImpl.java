package com.example.distribuidora.service.impl;

import com.example.distribuidora.model.Order;
import com.example.distribuidora.repository.IGenericRepo;
import com.example.distribuidora.repository.IOrderRepo;
import com.example.distribuidora.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl extends CRUDImpl<Order, Integer> implements IOrderService {

    private final IOrderRepo repo;
    @Override
    protected IGenericRepo<Order, Integer> getRepo() {
        return repo;
    }
}
