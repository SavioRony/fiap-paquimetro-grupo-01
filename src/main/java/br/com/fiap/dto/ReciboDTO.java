package br.com.fiap.dto;

import br.com.fiap.enums.TipoPagamento;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
public class ReciboDTO {

    private String placa;
    private BigDecimal valorTotal;
    private TipoPagamento tipoPagamento;
    private Integer quantidadeHoras;
    private String dataHoraInicio;
    private String dataHoraFim;
}
