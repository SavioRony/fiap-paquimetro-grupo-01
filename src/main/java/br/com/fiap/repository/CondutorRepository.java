package br.com.fiap.repository;

import br.com.fiap.model.CondutorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondutorRepository extends JpaRepository<CondutorModel, Long> {
}
