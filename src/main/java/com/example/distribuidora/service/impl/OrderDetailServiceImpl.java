package com.example.distribuidora.service.impl;

import com.example.distribuidora.model.OrderDetail;
import com.example.distribuidora.repository.IGenericRepo;
import com.example.distribuidora.repository.IOrderDetailRepo;
import com.example.distribuidora.service.IOrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl extends CRUDImpl<OrderDetail, Integer> implements IOrderDetailService {

    private final IOrderDetailRepo repo;
    @Override
    protected IGenericRepo<OrderDetail, Integer> getRepo() {
        return repo;
    }
}
