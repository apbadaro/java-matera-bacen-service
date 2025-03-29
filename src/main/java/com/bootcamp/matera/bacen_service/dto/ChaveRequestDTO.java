package com.bootcamp.matera.bacen_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

// DTO, Data Transfer Object
// classe DTO para transferir os dados entre a API e o banco de dados
// visão do que está na API

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ChaveRequestDTO {
    private String chave;
    private Boolean ativa;
}
