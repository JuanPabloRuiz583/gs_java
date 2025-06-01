package br.com.fiap.Gs.controller;

import br.com.fiap.Gs.dto.RotaSeguraDTO;
import br.com.fiap.Gs.service.RotaSeguraService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rotas-seguras")
public class RotaSeguraController {

    @Autowired
    private RotaSeguraService rotaSeguraService;

    @GetMapping
    public ResponseEntity<List<RotaSeguraDTO>> findAll() {
        List<RotaSeguraDTO> rotas = rotaSeguraService.findAll();
        return ResponseEntity.ok(rotas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RotaSeguraDTO> findById(@PathVariable Long id) {
        RotaSeguraDTO rota = rotaSeguraService.findById(id);
        return ResponseEntity.ok(rota); // Retorna a resposta ao cliente
    }

    @PostMapping
    public ResponseEntity<RotaSeguraDTO> create(@Valid @RequestBody RotaSeguraDTO rotaSeguraDTO) {
        RotaSeguraDTO createdRota = rotaSeguraService.create(rotaSeguraDTO);
        return ResponseEntity.status(201).body(createdRota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RotaSeguraDTO> update(@PathVariable Long id, @Valid @RequestBody RotaSeguraDTO rotaSeguraDTO) {
        RotaSeguraDTO updatedRota = rotaSeguraService.update(id, rotaSeguraDTO);
        return ResponseEntity.ok(updatedRota);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        rotaSeguraService.delete(id);
        return ResponseEntity.noContent().build();
    }
}