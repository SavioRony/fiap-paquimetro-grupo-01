package br.com.fiap.mapper;

import br.com.fiap.dto.CondutorRequestDTO;
import br.com.fiap.dto.CondutorResponseDTO;
import br.com.fiap.model.CondutorModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CondutorMapper {

    CondutorModel toModel(CondutorRequestDTO dto);

    CondutorResponseDTO toResponseDto(CondutorModel model);
}
