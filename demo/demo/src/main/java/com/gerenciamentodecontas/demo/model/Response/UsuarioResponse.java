package com.gerenciamentodecontas.demo.model.Response;
import lombok.Data;


import java.time.LocalDate;


@Data
public class UsuarioResponse {
    private Long Id;
    private String email;
    private LocalDate dataNascimento;
    private String nomeUsuario;

}
