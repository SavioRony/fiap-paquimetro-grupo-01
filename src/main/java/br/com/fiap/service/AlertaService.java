package br.com.fiap.service;

import br.com.fiap.dto.AlertaDTO;
import br.com.fiap.repository.EstacionamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class AlertaService {

    @Autowired
    protected EstacionamentoRepository repository;

    public AlertaDTO findAlerta(String placa){

        var estacionamentoEmAberto = repository.findEstacionamentosAtivosOrSemDataFimPorVeiculo(LocalDateTime.now(), placa);

        if(estacionamentoEmAberto.isPresent()){

            var estacionamento = estacionamentoEmAberto.get();
            var alerta = new AlertaDTO();

            var actualDate = LocalDateTime.now();

            long horas = Duration.between(estacionamento.getDataHoraInicio(), actualDate).toSeconds();

            var hora = horas/3600;
            horas %= 3600;
            var minuto = horas/60;

            alerta.setPlaca(placa);
            alerta.setAlerta("Ja se passou " + hora + " hora(s) " + minuto + " minuto(s)");

            return alerta;
        }
        var alertaEstacionamentoFechado = new AlertaDTO();
        alertaEstacionamentoFechado.setPlaca(placa);
        alertaEstacionamentoFechado.setAlerta("Não existe nenhum estacionamento aberto para este veiculo !");
        return alertaEstacionamentoFechado;
    }
}
