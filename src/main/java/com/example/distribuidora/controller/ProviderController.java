package com.example.distribuidora.controller;

import com.example.distribuidora.dto.ProviderDTO;
import com.example.distribuidora.model.Provider;
import com.example.distribuidora.service.IProviderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/providers")
public class ProviderController {

    private final IProviderService service;
    @Qualifier("mapperDefault")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<ProviderDTO>> readAll()throws Exception {
        List<ProviderDTO> list = service.readAll().stream()
                .map(this::convertToDTO)
                .toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProviderDTO> readById(@PathVariable("id") Integer id)throws Exception {
        return new ResponseEntity<>(this.convertToDTO(service.readById(id)), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ProviderDTO> create(@Valid @RequestBody ProviderDTO dto)throws Exception {
        Provider obj = service.save(this.convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDTO(obj), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProviderDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody ProviderDTO dto)throws Exception {
        dto.setIdProvider(id);
        Provider obj = service.update(this.convertToEntity(dto), id);
        return new ResponseEntity<>(this.convertToDTO(obj), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id)throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ProviderDTO convertToDTO(Provider obj) {
        return mapper.map(obj, ProviderDTO.class);
    }
    public Provider convertToEntity(ProviderDTO dto) {
        return mapper.map(dto, Provider.class);
    }
}
