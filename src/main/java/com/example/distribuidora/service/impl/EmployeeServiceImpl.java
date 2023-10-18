package com.example.distribuidora.service.impl;

import com.example.distribuidora.model.Employee;
import com.example.distribuidora.repository.IEmployeeRepo;
import com.example.distribuidora.repository.IGenericRepo;
import com.example.distribuidora.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl extends CRUDImpl<Employee, Integer> implements IEmployeeService {

    private final IEmployeeRepo repo;
    @Override
    protected IGenericRepo<Employee, Integer> getRepo() {
        return repo;
    }
}
