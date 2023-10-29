package br.com.fiap.mapper;

import br.com.fiap.dto.EstacionamentoRequestDTO;
import br.com.fiap.dto.EstacionamentoResponseDTO;
import br.com.fiap.model.EstacionamentoModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstacionamentoMapper {

    EstacionamentoModel toModel(EstacionamentoRequestDTO dto);

    EstacionamentoResponseDTO toResponseDto(EstacionamentoModel model);
    List<EstacionamentoResponseDTO> toResponseDtoList(List<EstacionamentoModel> modelList);
}
