package com.example.distribuidora.controller;

import com.example.distribuidora.dto.OrderDTO;
import com.example.distribuidora.model.Order;
import com.example.distribuidora.service.IOrderService;
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
@RequestMapping("/orders")
public class OrderController {

    private final IOrderService service;

    @Qualifier("mapperDefault")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> readAll() throws Exception {
        List<OrderDTO> list = service.readAll().stream()
                .map(this::convertToDTO)
                .toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> readById(@PathVariable("id") Integer id)throws Exception {
        return new ResponseEntity<>(this.convertToDTO(service.readById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> save(@Valid @RequestBody OrderDTO dto) throws Exception {
        Order obj = service.save(this.convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDTO(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody OrderDTO dto)throws Exception {
        dto.setIdOrder(id);
        Order obj = service.update(this.convertToEntity(dto), id);
        return new ResponseEntity<>(this.convertToDTO(obj), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id)throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public OrderDTO convertToDTO(Order obj) {
        return mapper.map(obj, OrderDTO.class);
    }
    public Order convertToEntity(OrderDTO dto) {
        return mapper.map(dto, Order.class);
    }
}
