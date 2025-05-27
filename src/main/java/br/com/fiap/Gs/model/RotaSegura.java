package br.com.fiap.Gs.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RotaSegura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull(message = "A distância é obrigatória")
    @DecimalMin(value = "0.0", inclusive = false, message = "A distância deve ser maior que 0")
    private double distanciaKm;

    @Size(max = 255, message = "A observação deve ter no máximo 255 caracteres")
    private String observacao;

    @NotNull(message = "O abrigo é obrigatório")
    @ManyToOne
    @JoinColumn(name = "abrigo_id")
    private Abrigo abrigo; // destino

    @NotNull(message = "O alerta é obrigatório")
    @ManyToOne
    @JoinColumn(name = "alerta_id")
    private Alerta alerta; // origem (baseado na localização do alerta)
}
