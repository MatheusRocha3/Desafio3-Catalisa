package com.gerenciamentodecontas.demo.Repository;
import com.gerenciamentodecontas.demo.Enum.Status;
import com.gerenciamentodecontas.demo.Enum.TipoRecebimento;
import com.gerenciamentodecontas.demo.model.ContasAReceberModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ContasARececeberRepository extends JpaRepository<ContasAReceberModel, Long> {
    List<ContasAReceberModel> findByStatus(Status status);
    List<ContasAReceberModel> findByTipoRecebimento(TipoRecebimento tipoRecebimento);
    List<ContasAReceberModel> findByDataDeVencimento(LocalDate localDate);
}
