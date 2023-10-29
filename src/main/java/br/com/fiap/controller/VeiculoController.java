package br.com.fiap.controller;

import br.com.fiap.dto.VeiculoDTO;
import br.com.fiap.dto.VeiuculoRequestDTO;
import br.com.fiap.model.VeiculoModel;
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
@RequestMapping("/veiculo")
@Tag(name = "Veiculo", description = "Serviço para cadastro do veiculos")
public class VeiculoController {

    @Autowired
    protected VeiculoService service;

    @PostMapping()
    @Operation(summary = "Veiculo condutor", description = "Cadastro de veiculo",
            tags = {"Veiculo"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = VeiculoModel.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content)
            })
    public ResponseEntity<VeiculoDTO> create(@RequestBody @Valid VeiuculoRequestDTO dto){
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping(value = "/{placa}")
    @Operation(summary = "Alterar veiculo", description = "Alterar de veiculo",
            tags = {"Veiculo"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = VeiculoModel.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content)
            })
    public ResponseEntity<VeiculoDTO> update(@PathVariable(name = "placa") String placa, @RequestBody @Valid VeiuculoRequestDTO dto){

        var response = service.update(dto, placa);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{placa}")
    @Operation(summary = "Listar veiculo", description = "Listar veiculo",
            tags = {"Veiculo"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {@Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = VeiculoModel.class))
                            )}),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content)
            })
    public ResponseEntity<VeiculoDTO> getVeiculo(@PathVariable(name = "placa") String placa) {
        var response = service.getById(placa);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.noContent().build();
    }

    @GetMapping()
    @Operation(summary = "Listar veiculo", description = "Listar veiculo",
            tags = {"Veiculo"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {@Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = VeiculoModel.class))
                            )}),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content)
            })
    public ResponseEntity<List<VeiculoDTO>> getAllVeiculos() {
        var response = service.getAllVeiculos();
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{placa}")
    public ResponseEntity<?> delete(@PathVariable(name = "placa") String placa){
        var response = service.delete(placa);
        return response != null ? ResponseEntity.accepted().build() : ResponseEntity.notFound().build();
    }
}
