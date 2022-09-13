package com.gerenciamentodecontas.demo.Repository;
import com.gerenciamentodecontas.demo.model.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long> {
}
