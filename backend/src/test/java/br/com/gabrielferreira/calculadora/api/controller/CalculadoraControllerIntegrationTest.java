package br.com.gabrielferreira.calculadora.api.controller;

import br.com.gabrielferreira.calculadora.api.dto.create.CalculadoraCreateDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalculadoraControllerIntegrationTest {

    private static final String URL = "/calculadoras";
    private static final MediaType MEDIA_TYPE_JSON = MediaType.APPLICATION_JSON;
    private static final String TIPO_SOMA = "SOMA";
    private static final String TIPO_SUBTRACAO = "SUBTRACAO";
    private static final String TIPO_DIVISAO = "DIVISAO";
    private static final String TIPO_MULTIPLICACAO = "MULTIPLICACAO";

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    private CalculadoraCreateDTO calculadoraCreateDTO;

    @Test
    @DisplayName("Deve cadastrar cálculo quando informar o tipo de cálculo soma")
    @Order(1)
    void deveCadastrarCalculoQuandoInformarTipoSoma() throws Exception{
        calculadoraCreateDTO = CalculadoraCreateDTO.builder()
                .primeiroValor(BigDecimal.valueOf(20.00))
                .segundoValor(BigDecimal.valueOf(20.00))
                .tipo(TIPO_SOMA)
                .build();

        String jsonBody = objectMapper.writeValueAsString(calculadoraCreateDTO);

        String primeiroValorEsperado = calculadoraCreateDTO.getPrimeiroValor().toString();
        String segundoValorEsperado = calculadoraCreateDTO.getSegundoValor().toString();
        String tipoEsperado = calculadoraCreateDTO.getTipo();

        ResultActions resultActions = mockMvc
                .perform(post(URL)
                        .content(jsonBody)
                        .contentType(MEDIA_TYPE_JSON)
                        .accept(MEDIA_TYPE_JSON));

        resultActions.andExpect(status().isCreated());
        resultActions.andExpect(jsonPath("$.id").exists());
        resultActions.andExpect(jsonPath("$.primeiroValor").value(primeiroValorEsperado));
        resultActions.andExpect(jsonPath("$.segundoValor").value(segundoValorEsperado));
        resultActions.andExpect(jsonPath("$.tipo").value(tipoEsperado));
        resultActions.andExpect(jsonPath("$.valorTotal").value("40.0"));
        resultActions.andExpect(jsonPath("$.dataCadastro").exists());
    }

    @Test
    @DisplayName("Deve cadastrar cálculo quando informar o tipo de cálculo subtração")
    @Order(2)
    void deveCadastrarCalculoQuandoInformarTipoSubtracao() throws Exception{
        calculadoraCreateDTO = CalculadoraCreateDTO.builder()
                .primeiroValor(BigDecimal.valueOf(20.00))
                .segundoValor(BigDecimal.valueOf(20.00))
                .tipo(TIPO_SUBTRACAO)
                .build();

        String jsonBody = objectMapper.writeValueAsString(calculadoraCreateDTO);

        String primeiroValorEsperado = calculadoraCreateDTO.getPrimeiroValor().toString();
        String segundoValorEsperado = calculadoraCreateDTO.getSegundoValor().toString();
        String tipoEsperado = calculadoraCreateDTO.getTipo();

        ResultActions resultActions = mockMvc
                .perform(post(URL)
                        .content(jsonBody)
                        .contentType(MEDIA_TYPE_JSON)
                        .accept(MEDIA_TYPE_JSON));

        resultActions.andExpect(status().isCreated());
        resultActions.andExpect(jsonPath("$.id").exists());
        resultActions.andExpect(jsonPath("$.primeiroValor").value(primeiroValorEsperado));
        resultActions.andExpect(jsonPath("$.segundoValor").value(segundoValorEsperado));
        resultActions.andExpect(jsonPath("$.tipo").value(tipoEsperado));
        resultActions.andExpect(jsonPath("$.valorTotal").value("0.0"));
        resultActions.andExpect(jsonPath("$.dataCadastro").exists());
    }

    @Test
    @DisplayName("Deve cadastrar cálculo quando informar o tipo de cálculo divisão")
    @Order(3)
    void deveCadastrarCalculoQuandoInformarTipoDivisao() throws Exception{
        calculadoraCreateDTO = CalculadoraCreateDTO.builder()
                .primeiroValor(BigDecimal.valueOf(20.00))
                .segundoValor(BigDecimal.valueOf(20.00))
                .tipo(TIPO_DIVISAO)
                .build();

        String jsonBody = objectMapper.writeValueAsString(calculadoraCreateDTO);

        String primeiroValorEsperado = calculadoraCreateDTO.getPrimeiroValor().toString();
        String segundoValorEsperado = calculadoraCreateDTO.getSegundoValor().toString();
        String tipoEsperado = calculadoraCreateDTO.getTipo();

        ResultActions resultActions = mockMvc
                .perform(post(URL)
                        .content(jsonBody)
                        .contentType(MEDIA_TYPE_JSON)
                        .accept(MEDIA_TYPE_JSON));

        resultActions.andExpect(status().isCreated());
        resultActions.andExpect(jsonPath("$.id").exists());
        resultActions.andExpect(jsonPath("$.primeiroValor").value(primeiroValorEsperado));
        resultActions.andExpect(jsonPath("$.segundoValor").value(segundoValorEsperado));
        resultActions.andExpect(jsonPath("$.tipo").value(tipoEsperado));
        resultActions.andExpect(jsonPath("$.valorTotal").value("1.0"));
        resultActions.andExpect(jsonPath("$.dataCadastro").exists());
    }

    @Test
    @DisplayName("Deve cadastrar cálculo quando informar o tipo de cálculo multiplicação")
    @Order(4)
    void deveCadastrarCalculoQuandoInformarTipoMultiplicacao() throws Exception{
        calculadoraCreateDTO = CalculadoraCreateDTO.builder()
                .primeiroValor(BigDecimal.valueOf(20.00))
                .segundoValor(BigDecimal.valueOf(20.00))
                .tipo(TIPO_MULTIPLICACAO)
                .build();

        String jsonBody = objectMapper.writeValueAsString(calculadoraCreateDTO);

        String primeiroValorEsperado = calculadoraCreateDTO.getPrimeiroValor().toString();
        String segundoValorEsperado = calculadoraCreateDTO.getSegundoValor().toString();
        String tipoEsperado = calculadoraCreateDTO.getTipo();

        ResultActions resultActions = mockMvc
                .perform(post(URL)
                        .content(jsonBody)
                        .contentType(MEDIA_TYPE_JSON)
                        .accept(MEDIA_TYPE_JSON));

        resultActions.andExpect(status().isCreated());
        resultActions.andExpect(jsonPath("$.id").exists());
        resultActions.andExpect(jsonPath("$.primeiroValor").value(primeiroValorEsperado));
        resultActions.andExpect(jsonPath("$.segundoValor").value(segundoValorEsperado));
        resultActions.andExpect(jsonPath("$.tipo").value(tipoEsperado));
        resultActions.andExpect(jsonPath("$.valorTotal").value("400.0"));
        resultActions.andExpect(jsonPath("$.dataCadastro").exists());
    }

    @Test
    @DisplayName("Não deve cadastrar cálculo quando não informar dados")
    @Order(5)
    void naoDeveCadastrarCalculoQuandoNaoInformarDados() throws Exception{
        calculadoraCreateDTO = CalculadoraCreateDTO.builder()
                .primeiroValor(null)
                .segundoValor(null)
                .tipo(null)
                .build();

        String jsonBody = objectMapper.writeValueAsString(calculadoraCreateDTO);

        ResultActions resultActions = mockMvc
                .perform(post(URL)
                        .content(jsonBody)
                        .contentType(MEDIA_TYPE_JSON)
                        .accept(MEDIA_TYPE_JSON));

        resultActions.andExpect(status().isBadRequest());
        resultActions.andExpect(jsonPath("$.titulo").value("Erro validação de campos"));
        resultActions.andExpect(jsonPath("$.mensagem").value("Ocorreu um erro de validação nos campos"));
        resultActions.andExpect(jsonPath("$.campos").exists());
    }

    @Test
    @DisplayName("Não deve cadastrar cálculo quando informar o tipo de cálculo incorreto")
    @Order(6)
    void naoDeveCadastrarCalculoQuandoInformarTipoIncorreto() throws Exception{
        calculadoraCreateDTO = CalculadoraCreateDTO.builder()
                .primeiroValor(BigDecimal.valueOf(20.00))
                .segundoValor(BigDecimal.valueOf(20.00))
                .tipo("TESTE")
                .build();

        String jsonBody = objectMapper.writeValueAsString(calculadoraCreateDTO);

        ResultActions resultActions = mockMvc
                .perform(post(URL)
                        .content(jsonBody)
                        .contentType(MEDIA_TYPE_JSON)
                        .accept(MEDIA_TYPE_JSON));

        resultActions.andExpect(status().isBadRequest());
        resultActions.andExpect(jsonPath("$.titulo").value("Regra de negócio"));
        resultActions.andExpect(jsonPath("$.mensagem").value("Tipo de cálculo informado incorreto"));
    }

    @Test
    @DisplayName("Não deve cadastrar cálculo quando informar o tipo de cálculo divisão incorreto")
    @Order(7)
    void naoDeveCadastrarCalculoQuandoInformarDivisaoIncorreta() throws Exception{
        calculadoraCreateDTO = CalculadoraCreateDTO.builder()
                .primeiroValor(BigDecimal.valueOf(20.00))
                .segundoValor(BigDecimal.valueOf(0.00))
                .tipo("DIVISAO")
                .build();

        String jsonBody = objectMapper.writeValueAsString(calculadoraCreateDTO);

        ResultActions resultActions = mockMvc
                .perform(post(URL)
                        .content(jsonBody)
                        .contentType(MEDIA_TYPE_JSON)
                        .accept(MEDIA_TYPE_JSON));

        resultActions.andExpect(status().isBadRequest());
        resultActions.andExpect(jsonPath("$.titulo").value("Regra de negócio"));
        resultActions.andExpect(jsonPath("$.mensagem").value("Não é possível dividir com o valor 0"));
    }

    @Test
    @DisplayName("Deve buscar cálculos")
    @Order(8)
    void deveBuscarCalculos() throws Exception {
        String filtro = "?page=0&size=5";

        ResultActions resultActions = mockMvc
                .perform(get(URL.concat(filtro))
                        .accept(MEDIA_TYPE_JSON));
        resultActions.andExpect(status().isOk());

        resultActions.andExpect(status().isOk());
        resultActions.andExpect(jsonPath("$.content").exists());
    }
}
