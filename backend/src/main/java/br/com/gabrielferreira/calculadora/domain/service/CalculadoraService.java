package br.com.gabrielferreira.calculadora.domain.service;

import br.com.gabrielferreira.calculadora.domain.exception.RegraDeNegocioException;
import br.com.gabrielferreira.calculadora.domain.model.Calculadora;
import br.com.gabrielferreira.calculadora.domain.model.enums.TipoCalculoEnum;
import br.com.gabrielferreira.calculadora.domain.repository.CalculadoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class CalculadoraService {

    private final CalculadoraRepository calculadoraRepository;

    @Transactional
    public Calculadora selecionarTipoCalculo(Calculadora calculadora, String tipo){
        if(TipoCalculoEnum.SOMA.name().equals(tipo)){
            return somarCalculo(calculadora);
        } else if(TipoCalculoEnum.SUBTRACAO.name().equals(tipo)){
            return subtrairCalculo(calculadora);
        } else if(TipoCalculoEnum.DIVISAO.name().equals(tipo)){
            return dividirCalculo(calculadora);
        } else if(TipoCalculoEnum.MULTIPLICACAO.name().equals(tipo)){
            return multiplicarCalculo(calculadora);
        } else {
            throw new RegraDeNegocioException("Tipo de cálculo informado incorreto");
        }
    }

    private Calculadora somarCalculo(Calculadora calculadora){
        BigDecimal valorTotal = calculadora.getPrimeiroValor().add(calculadora.getSegundoValor());
        preencherCalculo(valorTotal, TipoCalculoEnum.SOMA, calculadora);

        calculadora = calculadoraRepository.save(calculadora);
        return calculadora;
    }

    private Calculadora subtrairCalculo(Calculadora calculadora){
        BigDecimal valorTotal = calculadora.getPrimeiroValor().subtract(calculadora.getSegundoValor());
        preencherCalculo(valorTotal, TipoCalculoEnum.SUBTRACAO, calculadora);

        calculadora = calculadoraRepository.save(calculadora);
        return calculadora;
    }

    private Calculadora dividirCalculo(Calculadora calculadora){
        if(calculadora.getSegundoValor().compareTo(BigDecimal.ZERO) == 0) {
			throw new RegraDeNegocioException("Não é possível dividir com o valor 0");
		}

        BigDecimal valorTotal = calculadora.getPrimeiroValor().divide(calculadora.getSegundoValor(), RoundingMode.HALF_EVEN);
        preencherCalculo(valorTotal, TipoCalculoEnum.DIVISAO, calculadora);

        calculadora = calculadoraRepository.save(calculadora);
        return calculadora;
    }

    private Calculadora multiplicarCalculo(Calculadora calculadora){
        BigDecimal valorTotal = calculadora.getPrimeiroValor().multiply(calculadora.getSegundoValor());
        preencherCalculo(valorTotal, TipoCalculoEnum.MULTIPLICACAO, calculadora);

        calculadora = calculadoraRepository.save(calculadora);
        return calculadora;
    }

    public Page<Calculadora> buscarCalculos(Integer page, Integer size){
        PageRequest pageRequest = PageRequest.of(page, size);
        return calculadoraRepository.buscarCalculos(pageRequest);
    }

    private void preencherCalculo(BigDecimal valorTotal, TipoCalculoEnum tipoCalculo, Calculadora calculadora){
        calculadora.setValorTotal(valorTotal);
        calculadora.setTipoCalculo(tipoCalculo);
    }
}
