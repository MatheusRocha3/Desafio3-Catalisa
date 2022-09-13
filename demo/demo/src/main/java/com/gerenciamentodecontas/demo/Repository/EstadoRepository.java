package com.gerenciamentodecontas.demo.Repository;
import com.gerenciamentodecontas.demo.model.EstadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<EstadoModel, Long> {
}
