package br.com.fiap.model;

import br.com.fiap.enums.TipoPagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



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
	@Enumerated(EnumType.STRING)
	private TipoPagamento tipoDePagamento;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_endereco")
	private EnderecoModel endereco;
}
