package com.example.distribuidora.controller;

import com.example.distribuidora.dto.EmployeeDTO;
import com.example.distribuidora.model.Employee;
import com.example.distribuidora.service.IEmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final IEmployeeService service;
    @Qualifier("mapperDefault")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> readAll()throws Exception {
        List<EmployeeDTO> list = service.readAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> readById(@PathVariable("id") Integer id)throws Exception {
        return new ResponseEntity<>(this.convertToDTO(service.readById(id)), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<EmployeeDTO> create(@Valid @RequestBody EmployeeDTO dto)throws Exception {
        Employee obj = service.save(this.convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDTO(obj), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody EmployeeDTO dto)throws Exception {
        dto.setIdEmployee(id);
        Employee obj = service.update(this.convertToEntity(dto), id);
        return new ResponseEntity<>(this.convertToDTO(obj), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id)throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    public EmployeeDTO convertToDTO(Employee obj) {
        return mapper.map(obj, EmployeeDTO.class);
    }

    public Employee convertToEntity(EmployeeDTO dto) {
        return mapper.map(dto, Employee.class);
    }
}
