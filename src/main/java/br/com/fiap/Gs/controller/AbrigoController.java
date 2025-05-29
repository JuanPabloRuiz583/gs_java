package br.com.fiap.Gs.controller;

import br.com.fiap.Gs.dto.AbrigoDTO;
import br.com.fiap.Gs.service.AbrigoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/abrigos")
public class AbrigoController {

    @Autowired
    private AbrigoService abrigoService;

    @GetMapping
    @Operation(
            summary = "Lista abrigos com paginação,ordenação e filtro por nome",
            description = "Retorna uma página de abrigos, podendo filtrar por nome, limitar quantidade, definir offset e ordenar por campo."
    )
    public ResponseEntity<Page<AbrigoDTO>> listarComPaginacao(
            @RequestParam(required = false) String nome,
            @RequestParam(defaultValue = "20") int limit,
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "id,asc") String sort
    ) {
        String[] sortParams = sort.split(",");
        String sortField = sortParams[0];
        Sort.Direction direction = (sortParams.length > 1 && sortParams[1].equalsIgnoreCase("desc"))
                ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(offset, limit, Sort.by(direction, sortField));
        Page<AbrigoDTO> resultado = abrigoService.consultarComPaginacaoENome(nome, pageable);
        return ResponseEntity.ok(resultado);
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