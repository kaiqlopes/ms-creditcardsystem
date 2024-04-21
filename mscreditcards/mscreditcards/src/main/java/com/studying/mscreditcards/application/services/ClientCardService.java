package com.studying.mscreditcards.application.services;

import com.studying.mscreditcards.application.dtos.ClientCardDTO;
import com.studying.mscreditcards.domain.ClientCard;
import com.studying.mscreditcards.infra.repositories.ClientCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientCardService {

    private final ClientCardRepository repository;

    @Transactional(readOnly = true)
    public List<ClientCardDTO> getCardsByCpf(String cpf) {
        List<ClientCard> result = repository.findByCpf(cpf);
        return result.stream().map(ClientCardDTO::modelToDTO).toList();
    }
}
