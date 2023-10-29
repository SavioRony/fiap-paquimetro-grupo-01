package br.com.fiap.dto;

import br.com.fiap.enums.TipoPagamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CondutorResponseDTO {

    private String documento;
    private String nome;
    private String telefone;
    private String email;
    private TipoPagamento tipoDePagamento;
    private EnderecoResponseDTO endereco;
}
