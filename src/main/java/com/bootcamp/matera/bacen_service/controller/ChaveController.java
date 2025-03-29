package com.bootcamp.matera.bacen_service.controller;

import com.bootcamp.matera.bacen_service.dto.ChaveRequestDTO;
import com.bootcamp.matera.bacen_service.dto.ChaveResponseDTO;
import com.bootcamp.matera.bacen_service.service.ChaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * Controller para gerenciar as chaves do sistema Bacen.
 * Permite criar e buscar chaves.
 * CRUD - Create, Read, Update, Delete
 */

@RequestMapping( "/api/bacen/chaves") // define o caminho da API para todas as requisições
@RestController
@RequiredArgsConstructor // injeta o construtor da classe
public class ChaveController {

    private final ChaveService chaveService; // injeta o serviço de chave

    @PostMapping
    // cria uma nova chave
    public ResponseEntity<ChaveResponseDTO> criarChave(@RequestBody ChaveRequestDTO chaveRequestDTO) {
        return ResponseEntity.status(CREATED).body(chaveService.criarChave(chaveRequestDTO));
    }

    @GetMapping("/{chave}")
    // busca uma chave pelo ID
    public ResponseEntity<ChaveResponseDTO> buscarChave(@PathVariable String chave) {
        return ResponseEntity.status(CREATED).body(chaveService.buscarChave(chave));
    }
}