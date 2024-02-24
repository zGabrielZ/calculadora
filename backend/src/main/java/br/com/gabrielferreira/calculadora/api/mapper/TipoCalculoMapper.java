package br.com.gabrielferreira.calculadora.api.mapper;

import br.com.gabrielferreira.calculadora.api.dto.TipoCalculoDTO;
import br.com.gabrielferreira.calculadora.domain.model.enums.TipoCalculoEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoCalculoMapper {

    @Mapping(target = "tipo", expression = "java(tipoCalculoEnum.name())")
    TipoCalculoDTO toTipoCalculoDto(TipoCalculoEnum tipoCalculoEnum);

    default List<TipoCalculoDTO> toTipoCalculosDtos(List<TipoCalculoEnum> tipos){
        return tipos.stream().map(this::toTipoCalculoDto).toList();
    }

}
