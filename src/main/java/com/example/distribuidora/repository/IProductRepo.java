package com.example.distribuidora.repository;

import com.example.distribuidora.model.Client;
import com.example.distribuidora.model.Product;
import org.springframework.stereotype.Repository;
@Repository
public interface IProductRepo extends IGenericRepo<Product, Integer>{
}
