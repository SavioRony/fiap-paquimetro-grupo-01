package br.com.fiap.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode
public class VeiculoModel {

    @Id
    @NotNull(message = "é necessario passar o numero da placa")
    private String placa;
    private String modelo;
    private String cor;
}
