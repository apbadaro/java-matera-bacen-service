package com.bootcamp.matera.bacen_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

// classe modelo para salvar os dados no banco de dados
// é uma réplica do que está no banco de dados
// Model == Entity
// visão do banco de dados

@Builder // permite criar objetos de forma mais legível
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Chave {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // gera um ID único
    private UUID id;
    @Column
    private String chave; // chave gerada
    @Column
    private Boolean ativa; // chave ativa ou não
}
