package com.gerenciamentodecontas.demo.Controller;

import com.gerenciamentodecontas.demo.Service.EnderecoService;

import com.gerenciamentodecontas.demo.model.EnderecoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class EnderecoController {
    @Autowired
    EnderecoService enderecoService;

    @GetMapping(path = "/enderecos")
    public ResponseEntity<List<EnderecoModel>> buscarTodosClientes(){

        return ResponseEntity.ok(enderecoService.buscarTodos());
    }

    @GetMapping(path = "/enderecos/{codigo}")
    public ResponseEntity<Optional<EnderecoModel>> buscarPorId(@PathVariable Long codigo){
        return ResponseEntity.ok(enderecoService.buscarId(codigo));
    }

    @PostMapping(path = "/enderecos")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EnderecoModel> cadastrarEndereco(@RequestBody EnderecoModel endereco){
        return ResponseEntity.ok(enderecoService.cadastrar(endereco));
    }

    @PutMapping(path = "/enderecos/{codigo}")
    public ResponseEntity<EnderecoModel> alterarEndereco(@RequestBody EnderecoModel endereco){
        return ResponseEntity.ok(enderecoService.alterar(endereco));
    }

    @DeleteMapping(path = "/enderecos/{codigo}")
    public void deletarEndereco(@PathVariable Long codigo){
        enderecoService.deletar(codigo);
    }
}
