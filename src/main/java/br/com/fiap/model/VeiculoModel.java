package br.com.fiap.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode
public class VeiculoModel {

    @Id
    @NotNull(message = "é necessario passar o numero da placa")
    private String placa;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_condutor")
    private CondutorModel condutor;
    private String modelo;
    private String cor;
}
