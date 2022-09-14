package com.gerenciamentodecontas.demo.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "usuario")
@NoArgsConstructor
public class UsuarioModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private String nomeUsuario;

    @JsonIgnore //1
    @OneToMany(mappedBy = "usuario_id", cascade = CascadeType.ALL)
    private List<EnderecoModel> endereco_id;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario_id", cascade = CascadeType.ALL)
    private List<ContasAReceberModel> contas_id;

    public UsuarioModel(String nomeUsuario, LocalDate dataNascimento, String email, String cpf) {
        this.nomeUsuario = nomeUsuario;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.cpf = cpf;
    }

}
