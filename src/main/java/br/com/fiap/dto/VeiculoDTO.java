package br.com.fiap.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class VeiculoDTO {

    @NotNull(message = "é necessario passar o numero da placa")
    private String placa;
    private String modelo;
    private String cor;
}
