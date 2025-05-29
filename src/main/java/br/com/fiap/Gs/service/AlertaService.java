package br.com.fiap.Gs.service;

import br.com.fiap.Gs.dto.AlertaDTO;
import br.com.fiap.Gs.model.Alerta;
import br.com.fiap.Gs.model.User;
import br.com.fiap.Gs.repository.AlertaRepository;
import br.com.fiap.Gs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlertaService {

    @Autowired
    private AlertaRepository alertaRepository;

    @Autowired
    private UserRepository userRepository;

    public List<AlertaDTO> findAll() {
        return alertaRepository.findAll().stream()
                .map(alerta -> new AlertaDTO(
                        alerta.getId(),
                        alerta.getDescricao(),
                        alerta.getDataHora(),
                        alerta.getLatitude(),
                        alerta.getLongitude(),
                        alerta.getTipoEvento(),
                        alerta.getUsuario().getId()
                ))
                .collect(Collectors.toList());
    }

    public AlertaDTO findById(Long id) {
        Alerta alerta = alertaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alerta não encontrado"));
        return new AlertaDTO(
                alerta.getId(),
                alerta.getDescricao(),
                alerta.getDataHora(),
                alerta.getLatitude(),
                alerta.getLongitude(),
                alerta.getTipoEvento(),
                alerta.getUsuario().getId()
        );
    }

    public AlertaDTO create(AlertaDTO dto) {
        User usuario = userRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Alerta alerta = Alerta.builder()
                .id(null)
                .descricao(dto.getDescricao())
                .dataHora(dto.getDataHora())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .tipoEvento(dto.getTipoEvento())
                .usuario(usuario)
                .build();
        alerta = alertaRepository.save(alerta);
        return new AlertaDTO(
                alerta.getId(),
                alerta.getDescricao(),
                alerta.getDataHora(),
                alerta.getLatitude(),
                alerta.getLongitude(),
                alerta.getTipoEvento(),
                alerta.getUsuario().getId()
        );
    }

    public AlertaDTO update(Long id, AlertaDTO dto) {
        Alerta alerta = alertaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alerta não encontrado"));

        User usuario = userRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        alerta.setDescricao(dto.getDescricao());
        alerta.setDataHora(dto.getDataHora());
        alerta.setLatitude(dto.getLatitude());
        alerta.setLongitude(dto.getLongitude());
        alerta.setTipoEvento(dto.getTipoEvento());
        alerta.setUsuario(usuario);
        alerta = alertaRepository.save(alerta);
        return new AlertaDTO(
                alerta.getId(),
                alerta.getDescricao(),
                alerta.getDataHora(),
                alerta.getLatitude(),
                alerta.getLongitude(),
                alerta.getTipoEvento(),
                alerta.getUsuario().getId()
        );
    }

    public void delete(Long id) {
        if (!alertaRepository.existsById(id)) {
            throw new RuntimeException("Alerta não encontrado");
        }
        alertaRepository.deleteById(id);
    }
}