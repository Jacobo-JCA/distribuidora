package com.example.distribuidora.controller;

import com.example.distribuidora.dto.CategoryDTO;
import com.example.distribuidora.model.Category;
import com.example.distribuidora.service.ICategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final ICategoryService service;

    @Qualifier("mapperCategory")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> readAll() throws Exception {
        List<CategoryDTO> list = service.readAll().stream()
                .map(this::convertToDTO)
                .toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> readById(@PathVariable("id") Integer id)throws Exception {
        return new ResponseEntity<>(this.convertToDTO(service.readById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> save(@Valid @RequestBody CategoryDTO dto) throws Exception {
        Category obj = service.save(this.convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDTO(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody CategoryDTO dto)throws Exception {
        dto.setIdCategory(id);
        Category obj = service.update(this.convertToEntity(dto), id);
        return new ResponseEntity<>(this.convertToDTO(obj), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id)throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public CategoryDTO convertToDTO(Category obj) {
        return mapper.map(obj, CategoryDTO.class);
    }
    public Category convertToEntity(CategoryDTO dto) {
        return mapper.map(dto, Category.class);
    }
}
