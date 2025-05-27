package br.com.fiap.Gs.model;

import br.com.fiap.Gs.dto.UsuarioDTO;
import br.com.fiap.Gs.repository.UsuarioRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Abrigo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    private String nome;

    @NotBlank(message = "O endereço é obrigatório")
    @Size(max = 255, message = "O endereço deve ter no máximo 255 caracteres")
    private String endereco;

    @NotNull(message = "A latitude é obrigatória")
    private double latitude;

    @NotNull(message = "A longitude é obrigatória")
    private double longitude;

    @NotNull(message = "A capacidade máxima é obrigatória")
    @Min(value = 1, message = "A capacidade máxima deve ser no mínimo 1")
    private int capacidadeMaxima;

    @NotNull(message = "A capacidade atual é obrigatória")
    @Min(value = 0, message = "A capacidade atual deve ser no mínimo 0")
    private int capacidadeAtual;

    private boolean ativo;
}
