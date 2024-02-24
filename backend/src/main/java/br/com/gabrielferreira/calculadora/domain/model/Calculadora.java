package br.com.gabrielferreira.calculadora.domain.model;

import br.com.gabrielferreira.calculadora.domain.model.enums.TipoCalculoEnum;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

import static br.com.gabrielferreira.calculadora.common.utils.DataUtils.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_CALCULADORA")
public class Calculadora implements Serializable {

    @Serial
    private static final long serialVersionUID = 6939871727848010396L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "PRIMEIRO_VALOR", nullable = false, precision = 10, scale = 2)
    private BigDecimal primeiroValor;

    @Column(name = "SEGUNDO_VALOR", nullable = false, precision = 10, scale = 2)
    private BigDecimal segundoValor;

    @Column(name = "valorTotal", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorTotal;

    @Column(name = "TIPO_CALCULO", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoCalculoEnum tipoCalculo;

    @Column(name = "DATA_CADASTRO", nullable = false)
    private ZonedDateTime dataCadastro;

    @Column(name = "DATA_ATUALIZACAO")
    private ZonedDateTime dataAtualizacao;

    @PrePersist
    public void prePersist(){
        dataCadastro = ZonedDateTime.now(UTC);
    }

    @PreUpdate
    public void preUpdate(){
        dataAtualizacao = ZonedDateTime.now(UTC);
    }
}
