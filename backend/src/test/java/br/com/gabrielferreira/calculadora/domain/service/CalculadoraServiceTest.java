package br.com.gabrielferreira.calculadora.domain.service;

import br.com.gabrielferreira.calculadora.domain.model.Calculadora;
import br.com.gabrielferreira.calculadora.domain.model.enums.TipoCalculoEnum;
import br.com.gabrielferreira.calculadora.domain.repository.CalculadoraRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalculadoraServiceTest {

    @InjectMocks
    private CalculadoraService calculadoraService;

    @Mock
    private CalculadoraRepository calculadoraRepository;

    private Calculadora calculadora;

    private String tipo;

    @Test
    @DisplayName("Deve calcular o resultado quando informar o tipo cálculo soma")
    @Order(1)
    void deveCalcularSoma(){
        calculadora = Calculadora.builder()
                .primeiroValor(BigDecimal.valueOf(20.00))
                .segundoValor(BigDecimal.valueOf(30.00))
                .build();

        tipo = "SOMA";

        when(calculadoraRepository.save(calculadora)).thenReturn(calculadora);
        Calculadora resultado = calculadoraService.selecionarTipoCalculo(calculadora, tipo);

        assertEquals(resultado.getValorTotal(), BigDecimal.valueOf(50.00));
        assertEquals(resultado.getTipoCalculo().name(), TipoCalculoEnum.SOMA.name());
        assertEquals(resultado.getPrimeiroValor(), calculadora.getPrimeiroValor());
        assertEquals(resultado.getSegundoValor(), calculadora.getSegundoValor());
    }

    @Test
    @DisplayName("Deve calcular o resultado quando informar o tipo cálculo subtração")
    @Order(2)
    void deveCalcularSubtracao(){
        calculadora = Calculadora.builder()
                .primeiroValor(BigDecimal.valueOf(20.00))
                .segundoValor(BigDecimal.valueOf(30.00))
                .build();

        tipo = "SUBTRACAO";

        when(calculadoraRepository.save(calculadora)).thenReturn(calculadora);
        Calculadora resultado = calculadoraService.selecionarTipoCalculo(calculadora, tipo);

        assertEquals(resultado.getValorTotal(), BigDecimal.valueOf(-10.00));
        assertEquals(resultado.getTipoCalculo().name(), TipoCalculoEnum.SUBTRACAO.name());
        assertEquals(resultado.getPrimeiroValor(), calculadora.getPrimeiroValor());
        assertEquals(resultado.getSegundoValor(), calculadora.getSegundoValor());
    }

    @Test
    @DisplayName("Deve calcular o resultado quando informar o tipo cálculo divisão")
    @Order(3)
    void deveCalcularDivisao(){
        calculadora = Calculadora.builder()
                .primeiroValor(BigDecimal.valueOf(30.00))
                .segundoValor(BigDecimal.valueOf(30.00))
                .build();

        tipo = "DIVISAO";

        when(calculadoraRepository.save(calculadora)).thenReturn(calculadora);
        Calculadora resultado = calculadoraService.selecionarTipoCalculo(calculadora, tipo);

        assertEquals(resultado.getValorTotal(), BigDecimal.valueOf(1.00));
        assertEquals(resultado.getTipoCalculo().name(), TipoCalculoEnum.DIVISAO.name());
        assertEquals(resultado.getPrimeiroValor(), calculadora.getPrimeiroValor());
        assertEquals(resultado.getSegundoValor(), calculadora.getSegundoValor());
    }

    @Test
    @DisplayName("Deve calcular o resultado quando informar o tipo cálculo multiplicação")
    @Order(4)
    void deveCalcularMultiplicacao(){
        calculadora = Calculadora.builder()
                .primeiroValor(BigDecimal.valueOf(10.00))
                .segundoValor(BigDecimal.valueOf(10.00))
                .build();

        tipo = "MULTIPLICACAO";

        when(calculadoraRepository.save(calculadora)).thenReturn(calculadora);
        Calculadora resultado = calculadoraService.selecionarTipoCalculo(calculadora, tipo);

        assertEquals(resultado.getValorTotal(), BigDecimal.valueOf(100.00).setScale(2, RoundingMode.HALF_EVEN));
        assertEquals(resultado.getTipoCalculo().name(), TipoCalculoEnum.MULTIPLICACAO.name());
        assertEquals(resultado.getPrimeiroValor(), calculadora.getPrimeiroValor());
        assertEquals(resultado.getSegundoValor(), calculadora.getSegundoValor());
    }
}
