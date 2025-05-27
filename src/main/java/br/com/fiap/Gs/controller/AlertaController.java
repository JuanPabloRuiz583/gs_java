package br.com.fiap.Gs.controller;

import br.com.fiap.Gs.dto.AlertaDTO;
import br.com.fiap.Gs.service.AlertaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alertas")
public class AlertaController {

    @Autowired
    private AlertaService alertaService;

    @GetMapping
    public ResponseEntity<List<AlertaDTO>> findAll() {
        List<AlertaDTO> alertas = alertaService.findAll();
        return ResponseEntity.ok(alertas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertaDTO> findById(@PathVariable Long id) {
        AlertaDTO alerta = alertaService.findById(id); // Retrieve the alerta object
        return ResponseEntity.ok(alerta);
    }

    @PostMapping
    public ResponseEntity<AlertaDTO> create(@Valid @RequestBody AlertaDTO alertaDTO) {
        AlertaDTO createdAlerta = alertaService.create(alertaDTO);
        return ResponseEntity.status(201).body(createdAlerta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlertaDTO> update(@PathVariable Long id, @Valid @RequestBody AlertaDTO alertaDTO) {
        AlertaDTO updatedAlerta = alertaService.update(id, alertaDTO);
        return ResponseEntity.ok(updatedAlerta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        alertaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
