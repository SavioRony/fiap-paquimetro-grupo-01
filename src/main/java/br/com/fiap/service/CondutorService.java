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

    public Boolean saveCondutor(CondutorRequestDTO requestDTO) {
        CondutorModel condutorModel = mapper.toModel(requestDTO);
        if (condutorModel != null) {
            repository.save(condutorModel);
            return true;
        }
        return false;
    }

    public CondutorResponseDTO findCondutor(String numeroDoc) {
        var model = repository.findById(numeroDoc);
        return model.map(condutorModel -> mapper.toResponseDto(condutorModel)).orElseThrow(() -> new NotFoundException("Conduto não cadastrado no sistema!"));
    }

    public Boolean updateCondutor(CondutorRequestDTO requestDTO) {
        if (repository.existsById(requestDTO.getDocumento())) {
            CondutorModel condutorModel = mapper.toModel(requestDTO);
            if (condutorModel != null) {
                repository.save(condutorModel);
                return true;
            }
        }
        return false;
    }
}
