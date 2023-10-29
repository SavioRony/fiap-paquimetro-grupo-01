package br.com.fiap.model;

import br.com.fiap.enums.TipoEstacionamento;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_estacionamento")
public class EstacionamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;

    @Enumerated(EnumType.STRING)
    private TipoEstacionamento tipo;

    private Integer quantidadeHoras;

    @ManyToOne
    @JoinColumn(name = "documento")
    private CondutorModel condutor;

    @ManyToOne
    @JoinColumn(name = "placa")
    private VeiculoModel veiculo;

    private BigDecimal valorHora;
}
