package br.com.fiap.service;

import br.com.fiap.dto.CondutorRequestDTO;
import br.com.fiap.dto.CondutorResponseDTO;
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
        CondutorModel condutorModel = repository.getReferenceById(numeroDoc);
        return mapper.toResponseDto(condutorModel);
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
