package br.com.fiap.service;

import br.com.fiap.dto.AlertaDTO;
import br.com.fiap.enums.TipoEstacionamento;
import br.com.fiap.exception.NotFoundException;
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

        var estacionamentoEmAberto = repository.findEstacionamentoAberto(placa);

        if(estacionamentoEmAberto.isPresent()){

            var estacionamento = estacionamentoEmAberto.get();
            var alerta = new AlertaDTO();

            var actualDate = LocalDateTime.now();

            long hora;
            long minuto;

            if(estacionamento.getTipo() == TipoEstacionamento.ABERTO){
                long horas = Duration.between(estacionamento.getDataHoraInicio(), actualDate).toSeconds();

                hora = horas/3600;
                horas %= 3600;
                minuto = horas/60;

                alerta.setPlaca(placa);
                alerta.setAlerta("Ja se passou " + hora + " hora(s) " + minuto + " minuto(s)");
                return alerta;
            }else {

                long horaFixa = Duration.between(estacionamento.getDataHoraInicio(), actualDate).toSeconds();

                hora = horaFixa/3600;
                horaFixa %= 3600;
                minuto = horaFixa/60;
                alerta.setPlaca(placa);

                if(hora > estacionamento.getQuantidadeHoras() || (hora == estacionamento.getQuantidadeHoras() && minuto > 0)){
                    alerta.setAlerta("Você ultrapassou as horas fixas !, sera cobrado + 1h");
                }else if(estacionamento.getQuantidadeHoras() == hora && minuto == 0){
                    alerta.setAlerta("Acabou sua(s) hora(s)");
                } else if (hora < estacionamento.getQuantidadeHoras()) {
                    alerta.setAlerta("Ja se passou " + hora + " hora(s) " + minuto + " minuto(s)");
                }

                return alerta;
            }
        }
        throw new NotFoundException("Não possui nenhum estacionamento aberto para esse veiculo!");
    }
}
