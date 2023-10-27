package br.com.fiap.service;

import br.com.fiap.dto.VeiculoDTO;
import br.com.fiap.mapper.VeiculoMapper;
import br.com.fiap.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    protected VeiculoRepository repository;

    @Autowired
    protected VeiculoMapper mapper;

    public VeiculoDTO create(VeiculoDTO dto){
        return mapper.toDTO(repository.save(mapper.toModel(dto)));
    }

    public VeiculoDTO update(VeiculoDTO dto, String placa){
        var model = repository.findById(placa);
        return model.isPresent() ? mapper.toDTO(repository.save(mapper.toModel(dto))) : null;
    }

    public VeiculoDTO getById(String placa){
        var model = repository.findById(placa);
        return model.map(veiculoModel -> mapper.toDTO(veiculoModel)).orElse(null);
    }

    public List<VeiculoDTO> getAllVeiculos(){

        List<VeiculoDTO> allVeiculos = new ArrayList<>();
        var allVeiculosAtBd = repository.findAll();
        if(!allVeiculosAtBd.isEmpty()){
            allVeiculosAtBd.forEach(x-> allVeiculos.add(mapper.toDTO(x)));
            return allVeiculos;
        }
        return allVeiculos;
    }

    public String delete(String placa){
        var veiculoDelete = repository.findById(placa);
        if(veiculoDelete.isPresent()){
            repository.delete(veiculoDelete.get());
            return placa;
        }
        return null;
    }
}
