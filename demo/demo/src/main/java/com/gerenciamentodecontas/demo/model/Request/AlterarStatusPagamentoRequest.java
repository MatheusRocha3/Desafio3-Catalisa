package com.gerenciamentodecontas.demo.model.Request;
import com.gerenciamentodecontas.demo.Enum.Status;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
public class AlterarStatusPagamentoRequest {
    @Enumerated(EnumType.STRING)
    private Status status;
}
