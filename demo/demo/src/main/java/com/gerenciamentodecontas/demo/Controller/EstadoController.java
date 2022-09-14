package com.gerenciamentodecontas.demo.Controller;

import com.gerenciamentodecontas.demo.Exception.ExceptionHandlerLocalidades;
import com.gerenciamentodecontas.demo.Service.EstadoService;
import com.gerenciamentodecontas.demo.model.EstadoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class EstadoController extends ExceptionHandlerLocalidades {
    @Autowired
    EstadoService estadoService;

    @GetMapping(path = "/estados")
    public ResponseEntity<List<EstadoModel>> buscarTodos(){

        return ResponseEntity.ok(estadoService.buscarTodos());
    }

    @GetMapping(path = "/estados/{codigo}")
    public ResponseEntity<Optional<EstadoModel>> buscarPorId(@PathVariable Long codigo){
        return ResponseEntity.ok(estadoService.buscarPorId(codigo));
    }

    @PostMapping(path = "/estados")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity< EstadoModel> cadastrar(@RequestBody EstadoModel estado){
        return ResponseEntity.ok(estadoService.cadastrar(estado));
    }

    @PutMapping(path = "estados/{codigo}")
    public ResponseEntity<EstadoModel> alterarEstado(@RequestBody EstadoModel estado){
        return ResponseEntity.ok(estadoService.alterar(estado));
    }

    @DeleteMapping(path = "/estados/{codigo}")
    public ResponseEntity<List<EstadoModel>> deletarEstado(@PathVariable Long codigo){
        return ResponseEntity.ok(estadoService.deletar(codigo));
    }
    }

