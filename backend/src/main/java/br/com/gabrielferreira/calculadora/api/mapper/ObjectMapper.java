package br.com.gabrielferreira.calculadora.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.time.ZonedDateTime;

import static br.com.gabrielferreira.calculadora.common.utils.DataUtils.*;

@Mapper(componentModel = "spring")
public interface ObjectMapper {

    @Named("formatData")
    default ZonedDateTime formatDate(ZonedDateTime data){
        return toFusoPadraoSistema(data);
    }
}
