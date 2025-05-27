package br.com.fiap.Gs.controller;


import br.com.fiap.Gs.dto.AbrigoDTO;
import br.com.fiap.Gs.service.AbrigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/abrigos")
public class AbrigoController {

    @Autowired
    private AbrigoService abrigoService;

    @GetMapping
    public ResponseEntity<List<AbrigoDTO>> findAll() {
        List<AbrigoDTO> abrigos = abrigoService.findAll();
        return ResponseEntity.ok(abrigos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AbrigoDTO> findById(@PathVariable Long id) {
        AbrigoDTO abrigo = abrigoService.findById(id);
        return ResponseEntity.ok(abrigo);
    }

    @PostMapping
    public ResponseEntity<AbrigoDTO> create(@Valid @RequestBody AbrigoDTO dto) {
        AbrigoDTO createdAbrigo = abrigoService.create(dto);
        return ResponseEntity.status(201).body(createdAbrigo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AbrigoDTO> update(@PathVariable Long id, @Valid @RequestBody AbrigoDTO dto) {
        AbrigoDTO updatedAbrigo = abrigoService.update(id, dto);
        return ResponseEntity.ok(updatedAbrigo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        abrigoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
