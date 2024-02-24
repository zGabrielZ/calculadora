package br.com.gabrielferreira.calculadora.domain.repository;

import br.com.gabrielferreira.calculadora.domain.model.Calculadora;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculadoraRepository extends JpaRepository<Calculadora, Long> {

    @Query("SELECT c FROM Calculadora c " +
            "ORDER BY c.dataCadastro DESC")
    Page<Calculadora> buscarCalculos(Pageable pageable);
}
