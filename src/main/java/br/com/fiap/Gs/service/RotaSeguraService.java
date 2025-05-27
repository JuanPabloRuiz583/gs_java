package br.com.fiap.Gs.service;

import br.com.fiap.Gs.dto.RotaSeguraDTO;
import br.com.fiap.Gs.model.RotaSegura;
import br.com.fiap.Gs.model.Abrigo;
import br.com.fiap.Gs.model.Alerta;
import br.com.fiap.Gs.repository.RotaSeguraRepository;
import br.com.fiap.Gs.repository.AbrigoRepository;
import br.com.fiap.Gs.repository.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RotaSeguraService {

    @Autowired
    private RotaSeguraRepository rotaSeguraRepository;

    @Autowired
    private AbrigoRepository abrigoRepository;

    @Autowired
    private AlertaRepository alertaRepository;

    public List<RotaSeguraDTO> findAll() {
        return rotaSeguraRepository.findAll().stream()
                .map(rota -> new RotaSeguraDTO(
                        rota.getId(),
                        rota.getDistanciaKm(),
                        rota.getObservacao(),
                        rota.getAbrigo().getId(),
                        rota.getAlerta().getId()
                ))
                .collect(Collectors.toList());
    }

    public RotaSeguraDTO findById(Long id) {
        RotaSegura rota = rotaSeguraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rota segura não encontrada"));
        return new RotaSeguraDTO(
                rota.getId(),
                rota.getDistanciaKm(),
                rota.getObservacao(),
                rota.getAbrigo().getId(),
                rota.getAlerta().getId()
        );
    }

    public RotaSeguraDTO create(RotaSeguraDTO dto) {
        Abrigo abrigo = abrigoRepository.findById(dto.getAbrigoId())
                .orElseThrow(() -> new RuntimeException("Abrigo não encontrado"));
        Alerta alerta = alertaRepository.findById(dto.getAlertaId())
                .orElseThrow(() -> new RuntimeException("Alerta não encontrado"));

        RotaSegura rota = RotaSegura.builder()
                .id(null)
                .distanciaKm(dto.getDistanciaKm())
                .observacao(dto.getObservacao())
                .abrigo(abrigo)
                .alerta(alerta)
                .build();
        rota = rotaSeguraRepository.save(rota);
        return new RotaSeguraDTO(
                rota.getId(),
                rota.getDistanciaKm(),
                rota.getObservacao(),
                rota.getAbrigo().getId(),
                rota.getAlerta().getId()
        );
    }

    public RotaSeguraDTO update(Long id, RotaSeguraDTO dto) {
        RotaSegura rota = rotaSeguraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rota segura não encontrada"));

        Abrigo abrigo = abrigoRepository.findById(dto.getAbrigoId())
                .orElseThrow(() -> new RuntimeException("Abrigo não encontrado"));
        Alerta alerta = alertaRepository.findById(dto.getAlertaId())
                .orElseThrow(() -> new RuntimeException("Alerta não encontrado"));

        rota.setDistanciaKm(dto.getDistanciaKm());
        rota.setObservacao(dto.getObservacao());
        rota.setAbrigo(abrigo);
        rota.setAlerta(alerta);
        rota = rotaSeguraRepository.save(rota);
        return new RotaSeguraDTO(
                rota.getId(),
                rota.getDistanciaKm(),
                rota.getObservacao(),
                rota.getAbrigo().getId(),
                rota.getAlerta().getId()
        );
    }

    public void delete(Long id) {
        if (!rotaSeguraRepository.existsById(id)) {
            throw new RuntimeException("Rota segura não encontrada");
        }
        rotaSeguraRepository.deleteById(id);
    }
}