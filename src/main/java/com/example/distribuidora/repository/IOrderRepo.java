package com.example.distribuidora.repository;

import com.example.distribuidora.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepo extends IGenericRepo<Order, Integer> {
}
