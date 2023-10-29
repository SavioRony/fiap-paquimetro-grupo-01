package br.com.fiap.service;

import br.com.fiap.dto.CondutorResponseDTO;
import br.com.fiap.dto.EstacionamentoRequestDTO;
import br.com.fiap.dto.EstacionamentoResponseDTO;
import br.com.fiap.dto.ReciboDTO;
import br.com.fiap.enums.TipoEstacionamento;
import br.com.fiap.exception.BadRequestException;
import br.com.fiap.exception.NotFoundException;
import br.com.fiap.mapper.EstacionamentoMapper;
import br.com.fiap.model.EstacionamentoModel;
import br.com.fiap.repository.EstacionamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class EstacionamentoService {

    @Autowired
    private EstacionamentoMapper mapper;

    @Autowired
    private EstacionamentoRepository repository;

    @Autowired
    private CondutorService condutorService;

    @Autowired
    private VeiculoService veiculoService;


    public ReciboDTO registrar(EstacionamentoRequestDTO dto) {
        List<EstacionamentoModel> estacionamentos = repository.findEstacionamentosAtivosOrSemDataFimPorVeiculo(LocalDateTime.now(), dto.getVeiculo().getPlaca());
        if (!estacionamentos.isEmpty()) {
            throw new BadRequestException("Ja possui um registro ativo para esse veiculo!");
        }
        EstacionamentoModel request = mapper.toModel(dto);
        request.setDataHoraInicio(LocalDateTime.now());
        if (TipoEstacionamento.FIXO.equals(dto.getTipo())) {
            if (request.getQuantidadeHoras() == null || request.getQuantidadeHoras() == 0) {
                throw new BadRequestException("Para estacionamento fixo a quantidade de horas não pode ser nula ou menor que 1");
            }
            request.setDataHoraFim(request.getDataHoraInicio().plusHours(request.getQuantidadeHoras()));
        }
        EstacionamentoModel estacionamento = repository.save(request);
        return TipoEstacionamento.FIXO.equals(estacionamento.getTipo()) ? getReciboDTO(estacionamento) : null;
    }

    public ReciboDTO fechamentoEstacionamentoAberto(String placa) {
        Optional<EstacionamentoModel> optionalEstacionamento = repository.findEstacionamentoAbertoPorVeiculo(placa);
        EstacionamentoModel estacionamento = optionalEstacionamento.orElseThrow(() -> new NotFoundException("Não possui nenhum estacionamento aberto para esse veiculo!"));
        estacionamento.setDataHoraFim(LocalDateTime.now());
        Long quantidadeHoras = ChronoUnit.HOURS.between(estacionamento.getDataHoraInicio(), estacionamento.getDataHoraFim());
        estacionamento.setQuantidadeHoras(quantidadeHoras == 0 ? 1 : quantidadeHoras.intValue());
        repository.save(estacionamento);
        return getReciboDTO(estacionamento);
    }

    private ReciboDTO getReciboDTO(EstacionamentoModel estacionamento) {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        CondutorResponseDTO condutor = condutorService.findCondutor(estacionamento.getCondutor().getDocumento());
        ReciboDTO reciboDTO = new ReciboDTO();
        reciboDTO.setPlaca(estacionamento.getVeiculo().getPlaca());
        reciboDTO.setDataHoraInicio(estacionamento.getDataHoraInicio().format(formatoData));
        reciboDTO.setDataHoraFim(estacionamento.getDataHoraFim().format(formatoData));
        reciboDTO.setQuantidadeHoras(estacionamento.getQuantidadeHoras());
        reciboDTO.setTipoPagamento(condutor.getTipoDePagamento());
        BigDecimal valorTotal = estacionamento.getValorHora().multiply(new BigDecimal(estacionamento.getQuantidadeHoras()));
        reciboDTO.setValorTotal(valorTotal);
        return reciboDTO;
    }


    public EstacionamentoResponseDTO buscarEstacionamentoAberto(String placa) {
        veiculoService.getById(placa);
        return mapper.toResponseDto(repository.findEstacionamentoAbertoPorVeiculo(placa).orElseThrow(() ->
                new NotFoundException("Não possui nenhum estacionamento aberto para esse veiculo!")));
    }

    public List<EstacionamentoResponseDTO> buscarEstacionamentosPorDocumento(String documento) {
        condutorService.findCondutor(documento);
        List<EstacionamentoModel> estacionamentosPorCondutor = repository.findEstacionamentosPorCondutor(documento);
        return mapper.toResponseDtoList(estacionamentosPorCondutor);
    }


}
