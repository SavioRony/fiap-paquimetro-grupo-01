package br.com.fiap.controller;

import br.com.fiap.dto.CondutorRequestDTO;
import br.com.fiap.dto.CondutorResponseDTO;
import br.com.fiap.service.CondutorService;
import io.swagger.v3.oas.annotations.Operation;
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
                            content = @Content(schema = @Schema(implementation = CondutorResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content)
            })
    public ResponseEntity<CondutorResponseDTO> saveCondutor(@RequestBody @Valid CondutorRequestDTO requestDTO) {
        CondutorResponseDTO response = service.saveCondutor(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{documento}")
    @Operation(summary = "Buscar condutor", description = "Buscar condutor por documento",
            tags = {"Condutor"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = CondutorResponseDTO.class))),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content)
            })
    public ResponseEntity<CondutorResponseDTO> getCondutor(@PathVariable String documento) {
        return ResponseEntity.ok(service.findCondutor(documento));
    }

    @PutMapping()
    @Operation(summary = "Alterar condutor", description = "Alterar de condutor",
            tags = {"Condutor"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = CondutorResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content)
            })
    public ResponseEntity<CondutorResponseDTO> updateCondutor(@RequestBody @Valid CondutorRequestDTO requestDTO) {
        CondutorResponseDTO response = service.updateCondutor(requestDTO);
        return ResponseEntity.ok(response);
    }
}
