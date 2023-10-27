package br.com.fiap.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_condutor")
public class CondutorModel {

	@Id
    private Long documento;
	private String nome;
	private String telefone;
	private String email;
	// private  veiculos;
	private String tipoDePagamento;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_endereco")
	private EnderecoModel endereco;
}
