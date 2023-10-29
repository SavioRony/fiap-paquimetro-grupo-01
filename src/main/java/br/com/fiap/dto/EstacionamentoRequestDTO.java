package br.com.fiap.dto;

import br.com.fiap.enums.TipoEstacionamento;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstacionamentoRequestDTO {

    private Integer quantidadeHoras;
    @NotNull(message = "Não pode ser nulo ou vazio.")
    private TipoEstacionamento tipo;
    @NotNull(message = "Não pode ser nulo")
    private BigDecimal valorHora;
    @NotNull(message = "Não pode ser nulo")
    private CondutorIdDTO condutor;
    @NotNull(message = "Não pode ser nulo")
    private VeiculoIdDTO veiculo;

}
