package br.com.fiap.repository;

import br.com.fiap.model.VeiculoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository<VeiculoModel, String> {
    @Query(value = "SELECT * FROM tb_veiculo v WHERE v.ID_CONDUTOR = :documento"
            , nativeQuery = true)
    List<VeiculoModel> findVeiculosPorCondutor(String documento);

    @Query(value = "SELECT * FROM tb_veiculo v WHERE v.ID_CONDUTOR = :documento and v.placa = :placa"
            , nativeQuery = true)
    Optional<VeiculoModel> findVeiculosPorCondutorEPlaca(String documento, String placa);
}
