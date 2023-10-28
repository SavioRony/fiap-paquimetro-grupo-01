package br.com.fiap.mapper.mapperImpl;

import br.com.fiap.dto.VeiculoDTO;
import br.com.fiap.dto.VeiuculoRequestDTO;
import br.com.fiap.mapper.VeiculoMapper;
import br.com.fiap.model.CondutorModel;
import br.com.fiap.model.VeiculoModel;

public class VeiculoMapperImpl implements VeiculoMapper {
    @Override
    public VeiculoModel toModel(VeiuculoRequestDTO dto) {
        var model = new VeiculoModel();
        model.setCor(dto.getCor());
        model.setModelo(dto.getModelo());
        model.setPlaca(dto.getPlaca());
        var condutor = new CondutorModel();
        condutor.setDocumento(dto.getDocumentoCondutor());
        model.setCondutor(condutor);
        return model;
    }

    @Override
    public VeiculoDTO toDTO(VeiculoModel model) {

        var dto = new VeiculoDTO();
        dto.setCor(model.getCor());
        dto.setModelo(model.getModelo());
        dto.setPlaca(model.getPlaca());
        return dto;
    }
}
