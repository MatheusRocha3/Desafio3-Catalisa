package com.gerenciamentodecontas.demo.Repository;
import com.gerenciamentodecontas.demo.model.ContasAReceberModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasARececeberRepository extends JpaRepository<ContasAReceberModel, Long> {
}
