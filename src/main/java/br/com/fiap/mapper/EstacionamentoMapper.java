package br.com.fiap.mapper;

import br.com.fiap.dto.EstacionamentoRequestDTO;
import br.com.fiap.model.EstacionamentoModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EstacionamentoMapper {

    EstacionamentoModel toModel(EstacionamentoRequestDTO dto);

    EstacionamentoRequestDTO toResponseDto(EstacionamentoModel model);
}
