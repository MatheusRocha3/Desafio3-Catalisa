package com.gerenciamentodecontas.demo.Repository;

import com.gerenciamentodecontas.demo.model.ContasAPagarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasAPagarRepository  extends JpaRepository<ContasAPagarModel, Long> {
}
