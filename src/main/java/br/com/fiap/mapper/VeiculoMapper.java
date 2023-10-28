package br.com.fiap.mapper;

import br.com.fiap.dto.VeiculoDTO;
import br.com.fiap.dto.VeiuculoRequestDTO;
import br.com.fiap.model.VeiculoModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {

    VeiculoModel toModel(VeiuculoRequestDTO dto);

    VeiculoDTO toDTO(VeiculoModel model);
}
