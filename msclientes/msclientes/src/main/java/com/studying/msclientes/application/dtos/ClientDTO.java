package com.studying.msclientes.application.dtos;

import com.studying.msclientes.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private Long id;
    private String cpf;
    private String name;
    private Integer age;

    public ClientDTO(Client entity) {
        id = entity.getId();
        cpf = entity.getCpf();
        name = entity.getName();
        age = entity.getAge();
    }
}
