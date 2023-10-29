package br.com.fiap.dto;

import br.com.fiap.enums.TipoEstacionamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstacionamentoResponseDTO {

    private Long id;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private Integer quantidadeHoras;
    private TipoEstacionamento tipo;
    private BigDecimal valorHora;
    private CondutorIdDTO condutor;
    private VeiculoIdDTO veiculo;

}
