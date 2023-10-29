package br.com.fiap.repository;

import br.com.fiap.model.EstacionamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EstacionamentoRepository extends JpaRepository<EstacionamentoModel, Long> {
    @Query(value = "SELECT * FROM tb_estacionamento e " +
            "WHERE (e.data_hora_fim IS NULL OR e.data_hora_fim > :dataHoraAtual) " +
            "AND e.placa = :placa", nativeQuery = true)
    List<EstacionamentoModel> findEstacionamentosAtivosOrSemDataFimPorVeiculo(
            LocalDateTime dataHoraAtual, String placa);
}
