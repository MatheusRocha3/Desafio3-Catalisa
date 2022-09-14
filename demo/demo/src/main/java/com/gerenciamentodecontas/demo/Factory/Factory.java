package com.gerenciamentodecontas.demo.Factory;
import com.gerenciamentodecontas.demo.Enum.TipoRecebimento;

import java.time.LocalDate;

public class Factory {
    public Pagamentos getPagamentos(TipoRecebimento tipoRecebimento, LocalDate vencimento, LocalDate pagamento) {
        if (vencimento.isEqual(pagamento)) {
            return new PagamentoEmDia();
        } else if (vencimento.isBefore(pagamento)) {
            return new PagamentoAluguelAtrasado();

        } else if (vencimento.isAfter(pagamento)) {
            return new PagamentoAluguelAdiantado();

        } else {
        return new PagamentoEmDia();
    }

    }
}
