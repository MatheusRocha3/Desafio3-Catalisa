package com.gerenciamentodecontas.demo.Factory;

import java.math.BigDecimal;

public class PagamentoAluguelAdiantado implements Pagamentos{
    @Override
    public BigDecimal calcularValor(BigDecimal valorRecebido) {
        BigDecimal desconto = BigDecimal.valueOf(0.05);
        BigDecimal valorDeDesconto = valorRecebido.multiply(desconto);
        BigDecimal valorTotal = valorRecebido.subtract(valorDeDesconto);

        return valorTotal;

    }
    }

