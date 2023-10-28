package br.com.fiap.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class VeiuculoRequestDTO {


    @NotNull(message = "é necessario passar o numero da placa")
    private String placa;
    @NotNull(message = "condutor não pode ser nulo")
    private CondutorRequestDTO condutor;
    private String modelo;
    private String cor;
}
