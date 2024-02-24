package br.com.gabrielferreira.calculadora.domain.service;

import br.com.gabrielferreira.calculadora.domain.model.enums.TipoCalculoEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class TipoCalculoService {

    public List<TipoCalculoEnum> buscarTiposCalculos(){
        List<TipoCalculoEnum> tiposCalculos = Arrays.asList(TipoCalculoEnum.values());
        tiposCalculos.sort(Comparator.comparing(TipoCalculoEnum::getDescricao));
        return tiposCalculos;
    }
}
