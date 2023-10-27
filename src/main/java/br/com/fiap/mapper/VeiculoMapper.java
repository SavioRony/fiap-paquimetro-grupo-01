package br.com.fiap.mapper;

import br.com.fiap.dto.VeiculoDTO;
import br.com.fiap.model.VeiculoModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {

    VeiculoModel toModel(VeiculoDTO dto);

    VeiculoDTO toDTO(VeiculoModel model);
}
