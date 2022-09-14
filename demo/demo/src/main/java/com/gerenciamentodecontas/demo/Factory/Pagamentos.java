package com.gerenciamentodecontas.demo.Factory;

import java.math.BigDecimal;

public interface Pagamentos {
    public BigDecimal calcularValor (BigDecimal valorRecebido);
}
