package com.studying.mscreditevaluator.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class ClientSituation {

    private ClientDataDTO client;
    private List<ClientCardDTO> cards;
}
