package com.gerenciamentodecontas.demo.Factory;

import java.math.BigDecimal;

public class PagamentoAluguelAtrasado implements Pagamentos{
    @Override
    public BigDecimal calcularValor(BigDecimal valorRecebido) {
        BigDecimal multa = BigDecimal.valueOf(0.035);
        BigDecimal valorDesconto = valorRecebido.multiply(multa);
        BigDecimal valorTotal = valorRecebido.add(valorDesconto);
        return valorTotal;

    }
    }

