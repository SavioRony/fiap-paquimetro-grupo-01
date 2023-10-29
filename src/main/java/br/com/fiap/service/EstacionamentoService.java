package br.com.fiap.service;

import br.com.fiap.dto.EstacionamentoRequestDTO;
import br.com.fiap.dto.ReciboDTO;
import br.com.fiap.enums.TipoEstacionamento;
import br.com.fiap.exception.BadRequestException;
import br.com.fiap.mapper.EstacionamentoMapper;
import br.com.fiap.model.CondutorModel;
import br.com.fiap.model.EstacionamentoModel;
import br.com.fiap.repository.CondutorRepository;
import br.com.fiap.repository.EstacionamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class EstacionamentoService {

    @Autowired
    private EstacionamentoMapper mapper;

    @Autowired
    private EstacionamentoRepository repository;

    @Autowired
    private CondutorRepository condutorRepository;


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

    private ReciboDTO getReciboDTO(EstacionamentoModel estacionamento) {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        CondutorModel condutorModel = condutorRepository.getReferenceById(estacionamento.getCondutor().getDocumento());
        ReciboDTO reciboDTO = new ReciboDTO();
        reciboDTO.setPlaca(estacionamento.getVeiculo().getPlaca());
        reciboDTO.setDataHoraInicio(estacionamento.getDataHoraInicio().format(formatoData));
        reciboDTO.setDataHoraFim(estacionamento.getDataHoraFim().format(formatoData));
        reciboDTO.setQuantidadeHoras(estacionamento.getQuantidadeHoras());
        reciboDTO.setTipoPagamento(condutorModel.getTipoDePagamento());
        BigDecimal valorTotal = estacionamento.getValorHora().multiply(new BigDecimal(estacionamento.getQuantidadeHoras()));
        reciboDTO.setValorTotal(valorTotal);
        return reciboDTO;
    }

//    public ReciboDTO fechamentoVariavel(String placa) {
//        // Buscar estacionamento em aberto pela placa
//        // Update para salvar data fim e quantidade horas
//        // retorna recibo
//        return null;
//    }
//
//
//    public VeiculoDTO buscarEstacionamentoAberto(String placa) {
//        // Buscar estacionamento aberto ou fechado
//    }
//
//    public List<> buscarEstacionamentosPorDocumento(String documento) {
//        // Buscar estacionamento aberto ou fechado
//    }


}
