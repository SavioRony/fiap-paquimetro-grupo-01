package br.com.fiap.dto;

import br.com.fiap.model.EnderecoModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CondutorRequestDTO {

    private Long documento;
    private String nome;
    private String telefone;
    private String email;
    private String tipoDePagamento;
    private EnderecoRequestDTO endereco;

}
