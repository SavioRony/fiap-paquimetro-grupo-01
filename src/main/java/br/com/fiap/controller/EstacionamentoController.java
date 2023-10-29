package br.com.fiap.controller;

import br.com.fiap.dto.EstacionamentoRequestDTO;
import br.com.fiap.dto.EstacionamentoResponseDTO;
import br.com.fiap.dto.ReciboDTO;
import br.com.fiap.dto.VeiculoIdDTO;
import br.com.fiap.service.EstacionamentoService;
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

    @PostMapping("/registro")
    @Operation(summary = "Registro", description = "Registro de estacionamento",
            tags = {"Estacionamento"},
            responses = {
                    @ApiResponse(description = "Successo estacionamento fixo", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = ReciboDTO.class))
                    ),
                    @ApiResponse(description = "Successo estacionamento aberto", responseCode = "200", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content)
            })
    public ResponseEntity<ReciboDTO> registrar(@RequestBody @Valid EstacionamentoRequestDTO dto) {
        ReciboDTO recibo = service.registrar(dto);
        return recibo != null ? ResponseEntity.ok(recibo) : ResponseEntity.ok().build();
    }

    @PostMapping("/fechamento")
    @Operation(summary = "Fechamento", description = "Fechamento de estacionamento aberto",
            tags = {"Estacionamento"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = ReciboDTO.class))
                    ),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content)
            })
    public ResponseEntity<ReciboDTO> fechamentoEstacionamentoAberto(@RequestBody @Valid VeiculoIdDTO dto) {
        return ResponseEntity.ok(service.fechamentoEstacionamentoAberto(dto.getPlaca()));
    }

    @GetMapping("/{placa}")
    @Operation(summary = "Buscar estacionamento aberto", description = "Buscar estacionamento aberto por veiculo",
            tags = {"Estacionamento"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = EstacionamentoResponseDTO.class))
                    ),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content)
            })
    public ResponseEntity<EstacionamentoResponseDTO> buscarEstacionamentoAbertoPorVeiculo(@PathVariable String placa) {
        return ResponseEntity.ok(service.buscarEstacionamentoAberto(placa));
    }

    @GetMapping("/condutor/{documento}")
    @Operation(summary = "Buscar estacionamentos", description = "Buscar estacionamentos por condutor",
            tags = {"Estacionamento"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {@Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = EstacionamentoResponseDTO.class)))}
                    ),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content)
            })
    public ResponseEntity<List<EstacionamentoResponseDTO>> buscarEstacionamentoAbertoPorDocumento(@PathVariable String documento) {
        return ResponseEntity.ok(service.buscarEstacionamentosPorDocumento(documento));
    }

}
