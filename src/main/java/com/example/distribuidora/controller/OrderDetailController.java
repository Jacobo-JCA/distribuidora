package com.example.distribuidora.controller;

import com.example.distribuidora.dto.OrderDetailDTO;
import com.example.distribuidora.model.OrderDetail;
import com.example.distribuidora.service.IOrderDetailService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/details")
public class OrderDetailController {

    private final IOrderDetailService service;
    @Qualifier("mapperDefault")
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<OrderDetailDTO> create(@RequestBody OrderDetailDTO dto)throws Exception {
        OrderDetail obj = service.save(this.convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDTO(obj), HttpStatus.CREATED);
    }

    public OrderDetailDTO convertToDTO(OrderDetail obj) {
        return mapper.map(obj, OrderDetailDTO.class);
    }
    public OrderDetail convertToEntity(OrderDetailDTO dto) {
        return mapper.map(dto, OrderDetail.class);
    }
}
