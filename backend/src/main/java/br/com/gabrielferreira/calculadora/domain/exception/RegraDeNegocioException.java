package br.com.gabrielferreira.calculadora.domain.exception;

import java.io.Serial;

public class RegraDeNegocioException extends RuntimeException{

	@Serial
	private static final long serialVersionUID = 6018441542561876646L;

	public RegraDeNegocioException(String mensagem) {
		super(mensagem);
	}

}
