package com.studying.msclientes.application.controllers;

import com.studying.msclientes.application.dtos.ClientDTO;
import com.studying.msclientes.application.dtos.ClientSaveDTO;
import com.studying.msclientes.application.services.ClientService;
import com.studying.msclientes.domain.Client;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/clients")
@Slf4j
public class ClientController {

    private final ClientService service;

    @GetMapping
    public String status() {
        log.info("Obtaining clients microservices status");
        return "ok";
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ClientSaveDTO dto) {
        Client client = service.save(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(client.getCpf())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/get")
    public ResponseEntity<ClientDTO> findByCpf(@RequestParam("cpf") String cpf) {
        ClientDTO dto = service.getByCpf(cpf);
        return ResponseEntity.ok(dto);
    }
}
