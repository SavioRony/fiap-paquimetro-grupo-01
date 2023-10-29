package br.com.fiap.controller;

import br.com.fiap.dto.CondutorRequestDTO;
import br.com.fiap.dto.CondutorResponseDTO;
import br.com.fiap.model.CondutorModel;
import br.com.fiap.service.CondutorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/condutor")
@Tag(name = "Condutor", description = "Serviço para cadastro do condutor do paquimetro")
public class CondutorController {

    @Autowired
    private CondutorService service;

    @PostMapping()
    @Operation(summary = "Cadastro condutor", description = "Cadastro de condutor",
            tags = {"Condutor"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = CondutorModel.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content)
            })
    public ResponseEntity<Boolean> saveCondutor(@RequestBody @Valid CondutorRequestDTO requestDTO) {

        Boolean response = service.saveCondutor(requestDTO);
        return response ? ResponseEntity.status(HttpStatus.CREATED).build() : ResponseEntity.badRequest().build();
    }

    @GetMapping("/{numeroDoc}")
    @Operation(summary = "Listar condutor", description = "Listar condutor",
            tags = {"Condutor"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {@Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = CondutorModel.class))
                            )}),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content)
            })
    public ResponseEntity<CondutorResponseDTO> getCondutor(@PathVariable String numeroDoc) {

        CondutorResponseDTO response = service.findCondutor(numeroDoc);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.noContent().build();
    }

    @PutMapping()
    @Operation(summary = "Alterar condutor", description = "Alterar de condutor",
            tags = {"Condutor"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = CondutorModel.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content)
            })
    public ResponseEntity<Boolean> updateCondutor(@RequestBody @Valid CondutorRequestDTO requestDTO) {

        Boolean response = service.updateCondutor(requestDTO);
        return response ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }
}
