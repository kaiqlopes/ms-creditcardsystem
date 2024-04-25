package com.studying.mscreditevaluator.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class EvaluatedClientResultDTO {

    List<ClientCardDTO> cardsApproved;

}
