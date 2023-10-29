package br.com.fiap.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoIdDTO {

    @NotBlank(message = "Não pode ser nulo")
    private String placa;
}
