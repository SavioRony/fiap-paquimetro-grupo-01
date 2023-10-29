package br.com.fiap.service;

import br.com.fiap.dto.CondutorRequestDTO;
import br.com.fiap.dto.CondutorResponseDTO;
import br.com.fiap.exception.NotFoundException;
import br.com.fiap.mapper.CondutorMapper;
import br.com.fiap.model.CondutorModel;
import br.com.fiap.repository.CondutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CondutorService {

    @Autowired
    private CondutorMapper mapper;

    @Autowired
    private CondutorRepository repository;

    public CondutorResponseDTO saveCondutor(CondutorRequestDTO requestDTO) {
        CondutorModel condutorModel = mapper.toModel(requestDTO);
        return mapper.toResponseDto(repository.save(condutorModel));
    }

    public CondutorResponseDTO findCondutor(String numeroDoc) {
        var model = repository.findById(numeroDoc);
        return model.map(condutorModel -> mapper.toResponseDto(condutorModel)).orElseThrow(() -> new NotFoundException("Condutor não cadastrado no sistema!"));
    }

    public CondutorResponseDTO updateCondutor(CondutorRequestDTO requestDTO) {
        CondutorResponseDTO condutor = this.findCondutor(requestDTO.getDocumento());
        CondutorModel model = mapper.toModel(requestDTO);
        model.getEndereco().setId(condutor.getEndereco().getId());
        return mapper.toResponseDto(repository.save(model));
    }
}
