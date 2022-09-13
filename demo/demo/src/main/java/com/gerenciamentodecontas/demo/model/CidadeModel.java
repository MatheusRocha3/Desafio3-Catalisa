package com.gerenciamentodecontas.demo.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cidades")
public class CidadeModel implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nome_cidade", length = 50, nullable = false)
    private String nomeCidade;

    @ManyToOne
    @JoinColumn(name = "estado_id", referencedColumnName = "id")
    private EstadoModel estado;

}
