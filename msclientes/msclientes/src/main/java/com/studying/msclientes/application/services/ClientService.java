package com.studying.msclientes.application.services;

import com.studying.msclientes.application.dtos.ClientDTO;
import com.studying.msclientes.application.dtos.ClientSaveDTO;
import com.studying.msclientes.domain.Client;
import com.studying.msclientes.exceptions.ResourceNotFoundException;
import com.studying.msclientes.infra.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    @Transactional
    public Client save(ClientSaveDTO dto) {
        Client entity = dto.toModel();
        entity = repository.save(entity);
        return entity;
    }

    public ClientDTO getByCpf(String cpf) {
        Optional<Client> entity =  repository.findByCpf(cpf);
        if (entity.isEmpty()) {
            throw new ResourceNotFoundException("Inexistent resource");
        }

        return new ClientDTO(entity.get());
    }
}
