package br.com.fiap.repository;

import br.com.fiap.model.CondutorModel;
import br.com.fiap.model.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long> {
}
