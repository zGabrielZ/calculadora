package br.com.gabrielferreira.calculadora.api.mapper;

import br.com.gabrielferreira.calculadora.api.dto.CalculadoraDTO;
import br.com.gabrielferreira.calculadora.api.dto.create.CalculadoraCreateDTO;
import br.com.gabrielferreira.calculadora.domain.model.Calculadora;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring", uses = ObjectMapper.class)
public interface CalculadoraMapper {

    Calculadora toCalculadora(CalculadoraCreateDTO calculadoraCreateDTO);

    @Mapping(target = "dataCadastro", qualifiedByName = "formatData")
    @Mapping(target = "dataAtualizacao", qualifiedByName = "formatData")
    @Mapping(target = "tipo", expression = "java(calculadora.getTipoCalculo().name())")
    CalculadoraDTO toCalculadoraDto(Calculadora calculadora);

    default Page<CalculadoraDTO> toCalculadorasDtos(Page<Calculadora> calculadoras){
        return calculadoras.map(this::toCalculadoraDto);
    }
}
