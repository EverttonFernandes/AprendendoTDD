package com.designapi;

import org.junit.Assert;
import org.junit.Test;

public class PrimeiroTeste {

    @Test
    public void estruturaDeUmTeste () {
        // cenario
        int primeiroNumero = 10, segundoNumero = 5;
        // execucao
        int resultado = primeiroNumero + segundoNumero;
        // verificacoes
        Assert.assertEquals(15, resultado);
    }
}
