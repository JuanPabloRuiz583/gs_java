package br.com.fiap.Gs.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AbrigoDTO {

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
