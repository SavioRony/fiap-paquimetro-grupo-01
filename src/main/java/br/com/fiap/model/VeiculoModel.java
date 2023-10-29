package br.com.fiap.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
@Entity
@Table(name = "tb_veiculo")
public class VeiculoModel {

    @Id
    @NotNull(message = "é necessario passar o numero da placa")
    private String placa;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_condutor", nullable = false)
    private CondutorModel condutor;
    private String modelo;
    private String cor;
}
