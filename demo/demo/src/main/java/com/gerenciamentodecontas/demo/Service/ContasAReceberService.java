package com.gerenciamentodecontas.demo.Service;
import com.gerenciamentodecontas.demo.Enum.Status;
import com.gerenciamentodecontas.demo.Enum.TipoRecebimento;
import com.gerenciamentodecontas.demo.Factory.Factory;
import com.gerenciamentodecontas.demo.model.ContasAReceberModel;
import com.gerenciamentodecontas.demo.Repository.ContasARececeberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ContasAReceberService {
    @Autowired
    ContasARececeberRepository contasARececeberRepository;

    public ContasAReceberModel adicionarConta(ContasAReceberModel contasAReceberModel, Factory factory) {
        LocalDate horaCadastro = LocalDate.now();
        if (contasAReceberModel.getStatus().equals(Status.PAGO)){
            contasAReceberModel.setDataDeRecebimento(horaCadastro);
            contasAReceberModel.setValorTotal(factory.getPagamentos(contasAReceberModel.getTipoRecebimento(),contasAReceberModel.getDataDeVencimento(), contasAReceberModel.getDataDeRecebimento()).calcularValor(contasAReceberModel.getValorRecebimento()));
        } if (contasAReceberModel.getStatus().equals(Status.VENCIDA)){
            contasAReceberModel.setDataDeRecebimento(contasAReceberModel.getDataDeVencimento().minusDays(1));
            contasAReceberModel.setValorTotal(factory.getPagamentos(contasAReceberModel.getTipoRecebimento(),contasAReceberModel.getDataDeVencimento(), contasAReceberModel.getDataDeRecebimento()).calcularValor(contasAReceberModel.getValorRecebimento()));
        }

        return contasARececeberRepository.save(contasAReceberModel);
    }

    public ContasAReceberModel alterarConta(ContasAReceberModel contasAReceberModel, Long id, Factory factory) {
        Optional<ContasAReceberModel> conta = contasARececeberRepository.findById(id);
        if (contasARececeberRepository.findAll().isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }   else if(conta != null) {
        LocalDate horaCadastro = LocalDate.now();
            if (contasAReceberModel.getStatus().equals(Status.PAGO)){
                contasAReceberModel.setDataDeRecebimento(horaCadastro);
                contasAReceberModel.setValorTotal(factory.getPagamentos(contasAReceberModel.getTipoRecebimento(),contasAReceberModel.getDataDeVencimento(), contasAReceberModel.getDataDeRecebimento()).calcularValor(contasAReceberModel.getValorRecebimento()));
            } if (contasAReceberModel.getStatus().equals(Status.VENCIDA)){
                contasAReceberModel.setDataDeRecebimento(contasAReceberModel.getDataDeVencimento().minusDays(1));
                contasAReceberModel.setValorTotal(factory.getPagamentos(contasAReceberModel.getTipoRecebimento(),contasAReceberModel.getDataDeVencimento(), contasAReceberModel.getDataDeRecebimento()).calcularValor(contasAReceberModel.getValorRecebimento()));
            }
            return contasARececeberRepository.save(contasAReceberModel);
        }
        throw new NoSuchElementException();

    }

    public List<ContasAReceberModel> listarContas() {

        if (contasARececeberRepository.findAll().isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        } else {
            return contasARececeberRepository.findAll();
        }
    }

    public List<ContasAReceberModel> mostrarPorBusca(String busca) {

        if (contasARececeberRepository.findAll().size() > 0) {
            if (busca.equalsIgnoreCase("PAGA") || busca.equalsIgnoreCase("VENCIDA") || busca.equalsIgnoreCase("AGUARDANDO")) {
                List<ContasAReceberModel> status1 = contasARececeberRepository.findByStatus(Status.valueOf(busca));

                if (status1.isEmpty()) {
                    throw new NoSuchElementException();
                } else {
                    return status1;
                }
            } else if (busca.equalsIgnoreCase("ALUGUEIS") || busca.equalsIgnoreCase("EMPREGO_CLT") || busca.equalsIgnoreCase("FREELANCER")) {
                List<ContasAReceberModel> status1 = contasARececeberRepository.findByTipoRecebimento(TipoRecebimento.valueOf(busca));

                if (status1.isEmpty()) {
                    throw new NoSuchElementException();
                } else {
                    return status1;
                }
            } throw new HttpClientErrorException(HttpStatus.EXPECTATION_FAILED);
        }throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
    }

    public List<ContasAReceberModel> mostrarPorDataDeVencimento(String localDate) {
        LocalDate localDate1 = LocalDate.parse(localDate);

        if (contasARececeberRepository.findAll().size() > 0) {
            if (contasARececeberRepository.findByDataDeVencimento(localDate1).isEmpty()){
                throw new NoSuchElementException();
            } else
                return contasARececeberRepository.findByDataDeVencimento(localDate1);
        } else
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
    }
    public void deletarConta(Long id){
        int tamanhoLista = contasARececeberRepository.findAll().size();
        if (tamanhoLista > 0 && contasARececeberRepository.findById(id).isPresent() ){
            contasARececeberRepository.deleteById(id);
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }else if (tamanhoLista > 0 && !(contasARececeberRepository.findById(id).isPresent())) {
            throw new NoSuchElementException();
        } else {
            throw new HttpServerErrorException(HttpStatus.NOT_FOUND);
        }

    }

    public Optional<ContasAReceberModel> buscarUmaContaPorId(Long id) {

        if (contasARececeberRepository.findAll().isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        } else if (contasARececeberRepository.findById(id).isPresent()) {
            return contasARececeberRepository.findById(id);
        } else
            throw new NoSuchElementException();
    }


}
