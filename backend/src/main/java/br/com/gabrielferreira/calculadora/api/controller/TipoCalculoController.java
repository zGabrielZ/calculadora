package br.com.gabrielferreira.calculadora.api.controller;

import br.com.gabrielferreira.calculadora.api.dto.TipoCalculoDTO;
import br.com.gabrielferreira.calculadora.api.mapper.TipoCalculoMapper;
import br.com.gabrielferreira.calculadora.domain.model.enums.TipoCalculoEnum;
import br.com.gabrielferreira.calculadora.domain.service.TipoCalculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Tipo Calculo Controller", description = "Endpoints para realizar requisições de tipo de cálculo")
@RestController
@RequestMapping("/tipos-calculos")
@RequiredArgsConstructor
public class TipoCalculoController {

    private final TipoCalculoService tipoCalculoService;

    private final TipoCalculoMapper tipoCalculoMapper;

    @Operation(summary = "Buscar tipos de cálculos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipo de cálculos encontrados",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TipoCalculoDTO.class)) })
    })
    @GetMapping
    public ResponseEntity<List<TipoCalculoDTO>> buscarTiposCalculos(){
        List<TipoCalculoEnum> tipoDocumentoEnums = tipoCalculoService.buscarTiposCalculos();
        List<TipoCalculoDTO> tipoDocumentoDTOS = tipoCalculoMapper.toTipoCalculosDtos(tipoDocumentoEnums);

        return ResponseEntity.ok().body(tipoDocumentoDTOS);
    }
}
