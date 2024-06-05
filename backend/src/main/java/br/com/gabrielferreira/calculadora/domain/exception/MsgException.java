package br.com.gabrielferreira.calculadora.domain.exception;

import java.io.Serial;

public class MsgException extends RuntimeException{

	@Serial
	private static final long serialVersionUID = 6018441542561876646L;

	public MsgException(String mensagem) {
		super(mensagem);
	}

}
