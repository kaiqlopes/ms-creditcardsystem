package com.studying.msclientes.application.services;

import com.studying.msclientes.application.dtos.ClientDTO;
import com.studying.msclientes.application.dtos.ClientSaveDTO;
import com.studying.msclientes.domain.Client;
import com.studying.msclientes.exceptions.ResourceNotFoundException;
import com.studying.msclientes.infra.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    @Transactional
    public ClientDTO save(ClientSaveDTO dto) {
        Client entity = dto.toModel();
        entity = repository.save(entity);
        return new ClientDTO(entity);
    }

    @Transactional(readOnly = true)
    public ClientDTO getByCpf(String cpf) {
        Optional<Client> entity =  repository.findByCpf(cpf);
        if (entity.isEmpty()) {
            throw new ResourceNotFoundException("Nonexistent resource");
        }

        return new ClientDTO(entity.get());
    }
}
