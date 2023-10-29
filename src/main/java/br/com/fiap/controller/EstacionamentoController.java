package br.com.fiap.controller;

import br.com.fiap.dto.EstacionamentoRequestDTO;
import br.com.fiap.dto.ReciboDTO;
import br.com.fiap.dto.VeiculoDTO;
import br.com.fiap.dto.VeiuculoRequestDTO;
import br.com.fiap.model.VeiculoModel;
import br.com.fiap.service.EstacionamentoService;
import br.com.fiap.service.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estacionamento")
@Tag(name = "Estacionamento", description = "Serviço manutenção de estacionamento")
public class EstacionamentoController {

    @Autowired
    protected EstacionamentoService service;

    @PostMapping()
    @Operation(summary = "Registro", description = "Registro de estacionamento",
            tags = {"Estacionamento"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = EstacionamentoRequestDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content)
            })
    public ResponseEntity<ReciboDTO> create(@RequestBody @Valid EstacionamentoRequestDTO dto){
        ReciboDTO recibo = service.registrar(dto);
        return recibo != null ? ResponseEntity.ok(recibo) : ResponseEntity.ok().build();
    }

}