package com.gerenciamentodecontas.demo.Controller;
import com.gerenciamentodecontas.demo.model.ContasAPagarModel;
import com.gerenciamentodecontas.demo.model.Request.AlterarStatusPagamentoRequest;
import com.gerenciamentodecontas.demo.model.Response.ContasAPagarResponse;
import com.gerenciamentodecontas.demo.Service.ContasAPagarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

    @RestController
    @RequestMapping(path = "/contas")
    public class ContasAPagarController {

        @Autowired
        private ContasAPagarService contasAPagarService;

        @PostMapping
        public ResponseEntity<ContasAPagarModel> cadastrarNovaConta(@RequestBody ContasAPagarModel contasAPagarModel) {
            ContasAPagarModel contas = contasAPagarService.cadastrarContas(contasAPagarModel);
            return new ResponseEntity<>(contas, HttpStatus.CREATED);
        }

        @GetMapping
        ResponseEntity<List<ContasAPagarResponse>> exibirTodosOsRegistrosDePagamento() {
            return ResponseEntity.ok(contasAPagarService.exibirTodosRegistrosDePagamento());
        }


        @GetMapping(path = "/{id}")
        ResponseEntity<Optional<ContasAPagarModel>> exibirPagamentosViaId(@PathVariable Long id) {
            return ResponseEntity.ok(contasAPagarService.exibirContasViaId(id));
        }


        @PutMapping(path = "/{id}")
        public ResponseEntity<ContasAPagarModel> alterarStatusDasContas(@RequestBody AlterarStatusPagamentoRequest alterarStatusPagamentoRequest, @PathVariable Long id) {
            return ResponseEntity.ok(contasAPagarService.alterarRegistrosDePagamento(alterarStatusPagamentoRequest, id));
        }

        @DeleteMapping(path = "/{id}")
        public void deletar(@PathVariable Long id){
            contasAPagarService.deletarConta(id);
        }
}
