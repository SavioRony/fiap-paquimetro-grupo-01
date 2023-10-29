package br.com.fiap.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CondutorRequestDTO {

    private String documento;
    private String nome;
    private String telefone;
    private String email;
    private String tipoDePagamento;
    private EnderecoRequestDTO endereco;

}
