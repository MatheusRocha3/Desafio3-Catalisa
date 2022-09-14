package com.gerenciamentodecontas.demo.Service;
import com.gerenciamentodecontas.demo.model.CidadeModel;
import com.gerenciamentodecontas.demo.Repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    public List<CidadeModel> buscarTodas(){
        return cidadeRepository.findAll();
    }

    public Optional<CidadeModel> buscarPorId(Long id){
        return cidadeRepository.findById(id);
    }

    public CidadeModel cadastrar(CidadeModel cidade){
        return cidadeRepository.save(cidade);
    }

    public CidadeModel alterar(CidadeModel cidade){
        return cidadeRepository.save(cidade);
    }

    public List<CidadeModel> deletar(Long id){
        if (cidadeRepository.findById(id).isPresent()) {
            cidadeRepository.deleteById(id);
            throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
        }else if (cidadeRepository.findAll().isEmpty()){
            throw new HttpServerErrorException(HttpStatus.NOT_FOUND);
        }else
            throw new HttpServerErrorException(HttpStatus.NOT_FOUND);
    }
}
