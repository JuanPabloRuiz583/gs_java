package br.com.fiap.Gs.dto;

import br.com.fiap.Gs.model.TipoEvento;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlertaDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A descrição é obrigatória")
    @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres")
    private String descricao;

    @NotNull(message = "A data e hora são obrigatórias")
    private LocalDateTime dataHora;

    @NotNull(message = "A latitude é obrigatória")
    private double latitude;

    @NotNull(message = "A longitude é obrigatória")
    private double longitude;

    @NotNull(message = "O tipo de evento é obrigatório")
    private TipoEvento tipoEvento;

    @NotNull(message = "O ID do usuário é obrigatório")
    private Long usuarioId;

}
