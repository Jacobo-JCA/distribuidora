package com.example.distribuidora.repository;

import com.example.distribuidora.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepo extends IGenericRepo<Category, Integer>{
}
