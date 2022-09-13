package com.gerenciamentodecontas.demo.Repository;
import com.gerenciamentodecontas.demo.model.CidadeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<CidadeModel, Long> {
}
