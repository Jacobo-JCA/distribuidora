package com.example.distribuidora.repository;

import com.example.distribuidora.model.OrderDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDetailRepo extends IGenericRepo<OrderDetail, Integer>{
}
