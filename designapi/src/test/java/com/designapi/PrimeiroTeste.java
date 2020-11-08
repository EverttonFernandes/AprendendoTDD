package com.designapi;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PrimeiroTeste {

    @Test
    public void estruturaDeUmTeste () {
        // cenario
        int primeiroNumero = 10, segundoNumero = 5;
        // execucao
        int resultado = primeiroNumero + segundoNumero;
        // verificacoes
        Assertions.assertThat(resultado).isBetween(14,16);
    }
}
