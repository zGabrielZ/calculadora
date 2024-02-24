package br.com.gabrielferreira.calculadora.api.controller;

import br.com.gabrielferreira.calculadora.api.dto.CalculadoraDTO;
import br.com.gabrielferreira.calculadora.api.dto.create.CalculadoraCreateDTO;
import br.com.gabrielferreira.calculadora.api.mapper.CalculadoraMapper;
import br.com.gabrielferreira.calculadora.domain.model.Calculadora;
import br.com.gabrielferreira.calculadora.domain.service.CalculadoraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Tag(name = "Calculadora Controller", description = "Endpoints para realizar requisições de cálculo")
@RestController
@RequestMapping("/calculadoras")
@RequiredArgsConstructor
public class CalculadoraController {

    private final CalculadoraService calculadoraService;

    private final CalculadoraMapper calculadoraMapper;

    @Operation(summary = "Cadastrar cálculo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cálculo cadastrado",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CalculadoraDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Regra de negócio",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<CalculadoraDTO> cadastrarCalculo(@Valid @RequestBody CalculadoraCreateDTO calculadoraCreateDTO){
        Calculadora calculadora = calculadoraMapper.toCalculadora(calculadoraCreateDTO);
        Calculadora calculadoraCadastrado = calculadoraService.selecionarTipoCalculo(calculadora, calculadoraCreateDTO.getTipo());
        CalculadoraDTO calculadoraDTO = calculadoraMapper.toCalculadoraDto(calculadoraCadastrado);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(calculadoraDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(calculadoraDTO);
    }

    @Operation(summary = "Buscar cálculos paginados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cálculos encontrados",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CalculadoraDTO.class)) })
    })
    @GetMapping
    public ResponseEntity<Page<CalculadoraDTO>> buscarCalculosPaginados(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                                                        @RequestParam(value = "size", required = false, defaultValue = "5") Integer size){
        Page<Calculadora> calculadoras = calculadoraService.buscarCalculos(page, size);
        Page<CalculadoraDTO> calculadoraDTOS = calculadoraMapper.toCalculadorasDtos(calculadoras);

        return ResponseEntity.ok().body(calculadoraDTOS);
    }
}
