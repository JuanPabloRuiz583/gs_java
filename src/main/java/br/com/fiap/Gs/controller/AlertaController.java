package br.com.fiap.Gs.controller;

import br.com.fiap.Gs.dto.AlertaDTO;
import br.com.fiap.Gs.service.AlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alertas")
public class AlertaController {

    @Autowired
    private AlertaService alertaService;

    @GetMapping
    public List<AlertaDTO> findAll() {
        return alertaService.findAll();
    }

    @GetMapping("/{id}")
    public AlertaDTO findById(@PathVariable Long id) {
        return alertaService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlertaDTO create(@RequestBody AlertaDTO dto) {
        return alertaService.create(dto);
    }

    @PutMapping("/{id}")
    public AlertaDTO update(@PathVariable Long id, @RequestBody AlertaDTO dto) {
        return alertaService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        alertaService.delete(id);
    }
}