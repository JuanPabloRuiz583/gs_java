package br.com.fiap.Gs.service;

import br.com.fiap.Gs.dto.AbrigoDTO;
import br.com.fiap.Gs.model.Abrigo;
import br.com.fiap.Gs.repository.AbrigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AbrigoService {

    @Autowired
    private AbrigoRepository abrigoRepository;

    public Page<AbrigoDTO> consultarComPaginacaoENome(String nome, Pageable pageable) {
        Page<Abrigo> page;
        if (nome != null && !nome.isBlank()) {
            page = abrigoRepository.findByNomeContainingIgnoreCase(nome, pageable);
        } else {
            page = abrigoRepository.findAll(pageable);
        }
        return page.map(this::convertToDTO);
    }

    public AbrigoDTO findById(Long id) {
        Abrigo abrigo = abrigoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Abrigo não encontrado"));
        return convertToDTO(abrigo);
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
        return convertToDTO(abrigo);
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
        return convertToDTO(abrigo);
    }

    public void delete(Long id) {
        abrigoRepository.deleteById(id);
    }

    private AbrigoDTO convertToDTO(Abrigo abrigo) {
        AbrigoDTO dto = new AbrigoDTO();
        dto.setId(abrigo.getId());
        dto.setNome(abrigo.getNome());
        dto.setEndereco(abrigo.getEndereco());
        dto.setLatitude(abrigo.getLatitude());
        dto.setLongitude(abrigo.getLongitude());
        dto.setCapacidadeMaxima(abrigo.getCapacidadeMaxima());
        dto.setCapacidadeAtual(abrigo.getCapacidadeAtual());
        dto.setAtivo(abrigo.isAtivo());
        return dto;
    }
}