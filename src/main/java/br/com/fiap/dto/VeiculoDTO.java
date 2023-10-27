package br.com.fiap.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class VeiculoDTO {

    @NotNull(message = "é necessario passar o numero da placa")
    private String placa;
    private String modelo;
    private String cor;
}
