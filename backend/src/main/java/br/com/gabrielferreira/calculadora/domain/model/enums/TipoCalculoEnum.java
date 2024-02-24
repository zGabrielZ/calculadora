package br.com.gabrielferreira.calculadora.domain.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoCalculoEnum {

    SOMA("Soma"),
    SUBTRACAO("Subtração"),
    MULTIPLICACAO("Multiplicação"),
    DIVISAO("Divisão");

    private final String descricao;
}
