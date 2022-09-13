package com.gerenciamentodecontas.demo.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class UsuarioModel implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nome_usuario", length = 50, nullable = false)
    private String nomeUsuario;

    @Column(name = "data_de_nascimento", length = 15, nullable = false)
    private LocalDate dataDeNascimento;

    @Column(name = "email_usuario", length = 30, nullable = false)
    @Email(message = "Erro, email inválido")
    @NotBlank(message = "Erro, e-mail não informado")
    private String email;

    @Column(name = "cpf_usuario", length = 14, nullable = false)
    @CPF(message = "Cpf inválido")
    @NotBlank(message = "Erro, cpf não informado")
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
    private List<EnderecoModel> enderecoModel = new ArrayList<>();


    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<ContasReceberModel> contasReceberModel = new ArrayList<>();

}
