package br.com.fiap.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_condutor")
public class CondutorModel {

	@Id
    private String documento;
	private String nome;
	private String telefone;
	private String email;
	// private  veiculos;
	private String tipoDePagamento;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_endereco")
	private EnderecoModel endereco;
}
