package com.example.distribuidora.config;

import com.example.distribuidora.dto.CategoryDTO;
import com.example.distribuidora.model.Category;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("mapperCategory")
    public ModelMapper mapperCategory() {
        ModelMapper mapper = new ModelMapper();
        TypeMap<CategoryDTO, Category> typeCategoryDTO = mapper.createTypeMap(CategoryDTO.class, Category.class);
        TypeMap<Category, CategoryDTO> typeCategoryEntity = mapper.createTypeMap(Category.class, CategoryDTO.class);
        typeCategoryDTO.addMapping(CategoryDTO::getNameOfCategory, (dest, v) -> dest.setName((String) v));
        typeCategoryEntity.addMapping(Category::getName, (dest, v) -> dest.setNameOfCategory((String) v));
        return mapper;
    }
    @Bean("productMapper")
    public ModelMapper productMapper() {
        return new ModelMapper();
    }

    @Bean("mapperDefault")
    public ModelMapper defaultMapper() {
        return new ModelMapper();
    }
}
