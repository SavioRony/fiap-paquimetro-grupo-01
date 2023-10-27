package br.com.fiap.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_endereco")
public class EnderecoModel {

    @Id
    private Long id;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;

}
