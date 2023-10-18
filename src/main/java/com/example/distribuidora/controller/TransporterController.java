package com.example.distribuidora.controller;

import com.example.distribuidora.dto.TransporterDTO;
import com.example.distribuidora.model.Transporter;
import com.example.distribuidora.service.ITransporterService;
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
@RequestMapping("/transporters")
public class TransporterController {

    private final ITransporterService service;
    @Qualifier("mapperDefault")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<TransporterDTO>> readAll()throws Exception {
        List<TransporterDTO> list = service.readAll().stream()
                .map(this::convertToDTO)
                .toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TransporterDTO> readById(@PathVariable("id") Integer id)throws Exception {
        return new ResponseEntity<>(this.convertToDTO(service.readById(id)), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<TransporterDTO> create(@Valid @RequestBody TransporterDTO dto)throws Exception {
        Transporter obj = service.save(this.convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDTO(obj), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TransporterDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody TransporterDTO dto)throws Exception {
        dto.setIdTransporter(id);
        Transporter obj = service.update(this.convertToEntity(dto), id);
        return new ResponseEntity<>(this.convertToDTO(obj), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id)throws Exception {
         service.delete(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    public TransporterDTO convertToDTO(Transporter obj) {
        return mapper.map(obj, TransporterDTO.class);
    }
    public Transporter convertToEntity(TransporterDTO dto) {
        return mapper.map(dto, Transporter.class);
    }
}
