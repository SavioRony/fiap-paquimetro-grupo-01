package br.com.fiap.service;

import br.com.fiap.dto.VeiculoDTO;
import br.com.fiap.dto.VeiuculoRequestDTO;
import br.com.fiap.exception.BadRequestException;
import br.com.fiap.exception.NotFoundException;
import br.com.fiap.mapper.VeiculoMapper;
import br.com.fiap.model.VeiculoModel;
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
    private CondutorService condutorService;

    @Autowired
    protected VeiculoMapper mapper;

    public VeiculoDTO create(VeiuculoRequestDTO dto) {
        condutorService.findCondutor(dto.getCondutor().getDocumento());
        if (repository.findById(dto.getPlaca()).isPresent()) {
            throw new BadRequestException("Veiculo ja cadastrado!");
        }
        return mapper.toDTO(repository.save(mapper.toModel(dto)));
    }

    public VeiculoDTO update(VeiuculoRequestDTO dto) {
        condutorService.findCondutor(dto.getCondutor().getDocumento());
        this.getById(dto.getPlaca());
        return mapper.toDTO(repository.save(mapper.toModel(dto)));
    }

    public VeiculoDTO getById(String placa) {
        var model = repository.findById(placa);
        return model.map(veiculoModel -> mapper.toDTO(veiculoModel)).orElseThrow(() -> new NotFoundException("Veiculo não esta cadastrado no sistema!"));
    }

    public List<VeiculoDTO> getAllVeiculos(String documento) {
        condutorService.findCondutor(documento);
        List<VeiculoDTO> allVeiculos = new ArrayList<>();
        var allVeiculosAtBd = repository.findVeiculosPorCondutor(documento);
        if (!allVeiculosAtBd.isEmpty()) {
            allVeiculosAtBd.forEach(x -> allVeiculos.add(mapper.toDTO(x)));
            return allVeiculos;
        }
        return allVeiculos;
    }

    public String delete(String placa) {
        var veiculoDelete = repository.findById(placa);
        if (veiculoDelete.isPresent()) {
            repository.delete(veiculoDelete.get());
            return placa;
        }
        return null;
    }

    public VeiculoModel findVeiculoPorCondutoEPlaca(String documento, String placa) {
        condutorService.findCondutor(documento);
        var veiculo = repository.findVeiculosPorCondutorEPlaca(documento, placa);
        return veiculo.orElseThrow(() -> new NotFoundException("Veiculo não cadastrado para esse condutor!"));
    }
}
