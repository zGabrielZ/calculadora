package br.com.gabrielferreira.calculadora.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoCalculoDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 7421819910639935253L;

    @Schema(description = "Tipo do cálculo", example = "SOMA")
    private String tipo;

    @Schema(description = "Descrição do tipo cálculo", example = "Soma")
    private String descricao;
}
