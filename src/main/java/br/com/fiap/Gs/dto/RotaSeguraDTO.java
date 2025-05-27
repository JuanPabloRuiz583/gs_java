package br.com.fiap.Gs.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RotaSeguraDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "A distância é obrigatória")
    @DecimalMin(value = "0.0", inclusive = false, message = "A distância deve ser maior que 0")
    private double distanciaKm;

    @Size(max = 255, message = "A observação deve ter no máximo 255 caracteres")
    private String observacao;

    @NotNull(message = "O ID do abrigo é obrigatório")
    private Long abrigoId;

    @NotNull(message = "O ID do alerta é obrigatório")
    private Long alertaId;
}
