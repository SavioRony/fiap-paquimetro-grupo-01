package br.com.fiap.dto;

import br.com.fiap.enums.TipoEstacionamento;
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
    private TipoEstacionamento tipo;
    private BigDecimal valorHora;
    private CondutorIdDTO condutor;
    private VeiculoIdDTO veiculo;

}
