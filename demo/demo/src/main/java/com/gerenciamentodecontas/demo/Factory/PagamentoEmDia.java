package com.gerenciamentodecontas.demo.Factory;

import java.math.BigDecimal;

public class PagamentoEmDia implements Pagamentos{
    @Override
    public BigDecimal calcularValor(BigDecimal valorRecebido) {
        return valorRecebido;
    }
}
