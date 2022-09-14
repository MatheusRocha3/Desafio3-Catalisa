package com.gerenciamentodecontas.demo.Controller;
import com.gerenciamentodecontas.demo.Exception.ExceptionHandlerUsuario;
import com.gerenciamentodecontas.demo.model.Response.UsuarioResponse;
import com.gerenciamentodecontas.demo.model.UsuarioModel;
import com.gerenciamentodecontas.demo.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@RestController
public class UsuarioController extends ExceptionHandlerUsuario {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping(path = "/usuario")
    public ResponseEntity<UsuarioModel> cadastrarUsuario(@RequestBody @Valid UsuarioModel usuarioModel) throws HttpClientErrorException.UnprocessableEntity {
        return new ResponseEntity<>(usuarioService.adicionarUsuario(usuarioModel), HttpStatus.CREATED);
    }


    @GetMapping(path = "/usuario")
    public List<UsuarioResponse> mostrarUsuarios(){
        return usuarioService.verUsuarios();
    }

    @GetMapping(path = "/usuario/{id}")
    public Optional<UsuarioModel> mostrarPorId(@PathVariable Long id){
        return usuarioService.verUmUsuario(id);
    }

    @PutMapping(path = "/usuario/{id}")
    public UsuarioModel alterarUsuario(@PathVariable Long id, @RequestBody UsuarioModel usuarioModel){
        return usuarioService.editarUsuario(id, usuarioModel);
    }

    @DeleteMapping(path = "/usuario/{id}")
    public ResponseEntity<List<UsuarioResponse>> deletarPorId(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.deletarPorId(id));
    }
}
