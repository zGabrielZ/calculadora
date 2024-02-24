package br.com.gabrielferreira.calculadora.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CalculadoraDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -5633871045508970451L;

    @Schema(description = "Id do cálculo", example = "1")
    private Long id;

    @Schema(description = "Primeiro valor do cálculo", example = "10.00")
    private BigDecimal primeiroValor;

    @Schema(description = "Segundo valor do cálculo", example = "15.00")
    private BigDecimal segundoValor;

    @Schema(description = "Tipo do cálculo", example = "SOMA")
    private String tipo;

    @Schema(description = "Valor total do cálculo", example = "25.00")
    private BigDecimal valorTotal;

    @Schema(description = "Data cadastro do cálculo", example = "2024-02-18T12:30:23.177681-03:00")
    private ZonedDateTime dataCadastro;

    @Schema(description = "Data atualização do cálculo", example = "2024-02-18T12:30:23.177681-03:00")
    private ZonedDateTime dataAtualizacao;
}
