package br.com.fiap.Gs.service;

import br.com.fiap.Gs.dto.AbrigoDTO;
import br.com.fiap.Gs.model.Abrigo;
import br.com.fiap.Gs.repository.AbrigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AbrigoService {

    @Autowired
    private AbrigoRepository abrigoRepository;

    public List<AbrigoDTO> findAll() {
        return abrigoRepository.findAll().stream()
                .map(abrigo -> new AbrigoDTO(
                        abrigo.getId(),
                        abrigo.getNome(),
                        abrigo.getEndereco(),
                        abrigo.getLatitude(),
                        abrigo.getLongitude(),
                        abrigo.getCapacidadeMaxima(),
                        abrigo.getCapacidadeAtual(),
                        abrigo.isAtivo()
                ))
                .collect(Collectors.toList());
    }

    public AbrigoDTO findById(Long id) {
        Abrigo abrigo = abrigoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Abrigo não encontrado"));
        return new AbrigoDTO(
                abrigo.getId(),
                abrigo.getNome(),
                abrigo.getEndereco(),
                abrigo.getLatitude(),
                abrigo.getLongitude(),
                abrigo.getCapacidadeMaxima(),
                abrigo.getCapacidadeAtual(),
                abrigo.isAtivo()
        );
    }

    public AbrigoDTO create(AbrigoDTO dto) {
        Abrigo abrigo = Abrigo.builder()
                .id(null)
                .nome(dto.getNome())
                .endereco(dto.getEndereco())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .capacidadeMaxima(dto.getCapacidadeMaxima())
                .capacidadeAtual(dto.getCapacidadeAtual())
                .ativo(dto.isAtivo())
                .build();
        abrigo = abrigoRepository.save(abrigo);
        return new AbrigoDTO(
                abrigo.getId(),
                abrigo.getNome(),
                abrigo.getEndereco(),
                abrigo.getLatitude(),
                abrigo.getLongitude(),
                abrigo.getCapacidadeMaxima(),
                abrigo.getCapacidadeAtual(),
                abrigo.isAtivo()
        );
    }

    public AbrigoDTO update(Long id, AbrigoDTO dto) {
        Abrigo abrigo = abrigoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Abrigo não encontrado"));
        abrigo.setNome(dto.getNome());
        abrigo.setEndereco(dto.getEndereco());
        abrigo.setLatitude(dto.getLatitude());
        abrigo.setLongitude(dto.getLongitude());
        abrigo.setCapacidadeMaxima(dto.getCapacidadeMaxima());
        abrigo.setCapacidadeAtual(dto.getCapacidadeAtual());
        abrigo.setAtivo(dto.isAtivo());
        abrigo = abrigoRepository.save(abrigo);
        return new AbrigoDTO(
                abrigo.getId(),
                abrigo.getNome(),
                abrigo.getEndereco(),
                abrigo.getLatitude(),
                abrigo.getLongitude(),
                abrigo.getCapacidadeMaxima(),
                abrigo.getCapacidadeAtual(),
                abrigo.isAtivo()
        );
    }

    public void delete(Long id) {
        if (!abrigoRepository.existsById(id)) {
            throw new RuntimeException("Abrigo não encontrado");
        }
        abrigoRepository.deleteById(id);
    }
}