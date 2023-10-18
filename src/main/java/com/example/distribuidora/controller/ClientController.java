package com.example.distribuidora.controller;

import com.example.distribuidora.dto.ClientDTO;
import com.example.distribuidora.model.Client;
import com.example.distribuidora.service.IClientService;
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
@RequestMapping("/clients")
public class ClientController {

    private final IClientService service;

    @Qualifier("mapperDefault")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> readAll()throws Exception {
        List<ClientDTO> list = service.readAll().stream()
                .map(this::convertToDTO)
                .toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> readById(@PathVariable("id") Integer id)throws Exception {
        return new ResponseEntity<>(this.convertToDTO(service.readById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> create(@Valid @RequestBody ClientDTO dto)throws Exception {
        Client obj = service.save(this.convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDTO(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody ClientDTO dto) throws Exception {
        dto.setIdClient(id);
        Client obj = service.update(this.convertToEntity(dto), id);
        return new ResponseEntity<>(this.convertToDTO(obj), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id)throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    public ClientDTO convertToDTO(Client obj) {
        return mapper.map(obj, ClientDTO.class);
    }
    public Client convertToEntity(ClientDTO dto) {
        return mapper.map(dto, Client.class);
    }
}
