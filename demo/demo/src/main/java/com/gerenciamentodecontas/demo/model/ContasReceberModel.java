package com.gerenciamentodecontas.demo.model;
import com.gerenciamentodecontas.demo.Enum.RecebimentoAlugueis;
import com.gerenciamentodecontas.demo.Enum.TipoRecebimento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contas_receber")
public class ContasReceberModel implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "recebimento_contas_receber", length = 50, nullable = false)
    private String recebimento;

    @Column(name = "valor_recebimento_contas_receber", length = 200, nullable = false)
    private BigDecimal valorRecebimento;

    @Enumerated(EnumType.STRING)
    private TipoRecebimento tipoRecebimento;

    @Enumerated(EnumType.STRING)
    private RecebimentoAlugueis recebimentoAlugueis;

    @Column(name = "data_de_vencimento_contas_receber", length = 25, nullable = false)
    private LocalDate dataDeVencimento;

    @Column(name = "data_de_recebimento_contas_receber")
    public LocalDateTime dataDeRecebimento;

    @Column(name = "status_contas_receber", length = 75, nullable = false)
    private String status;


    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private UsuarioModel usuario;

}