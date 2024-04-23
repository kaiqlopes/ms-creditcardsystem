package com.studying.mscreditevaluator.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientSituationDTO {

    private ClientDTO client;
    private List<ClientCardDTO> cards;
}
