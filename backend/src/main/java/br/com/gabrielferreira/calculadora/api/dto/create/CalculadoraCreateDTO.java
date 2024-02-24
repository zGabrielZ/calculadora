package br.com.gabrielferreira.calculadora.api.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CalculadoraCreateDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -5633871045508970451L;

    @Schema(description = "Primeiro valor do cálculo", example = "10.00")
    @NotNull
    @Digits(integer = 10, fraction = 2)
    private BigDecimal primeiroValor;

    @Schema(description = "Segundo valor do cálculo", example = "15.00")
    @NotNull
    @Digits(integer = 10, fraction = 2)
    private BigDecimal segundoValor;

    @Schema(description = "Tipo do cálculo", example = "SOMA")
    @NotBlank
    @Size(min = 1, max = 255)
    private String tipo;
}
