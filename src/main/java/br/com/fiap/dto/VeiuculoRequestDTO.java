package br.com.fiap.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class VeiuculoRequestDTO {


    @NotNull(message = "é necessario passar o numero da placa")
    private String placa;
    @NotNull(message = "condutor não pode ser nulo")
    private CondutorIdDTO condutor;
    private String modelo;
    private String cor;
}
