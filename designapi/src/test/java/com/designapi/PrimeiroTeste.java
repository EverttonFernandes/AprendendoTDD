package com.designapi;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class PrimeiroTeste {

    Calculadora calculadora;
    int numero1 = 10, numero2 = 5;

    @Before
    public void setUp(){
        calculadora = new Calculadora();
    }

    @Test
    public void deveSomarDoisNumero () {
        Assertions.assertThat(new Calculadora().somarNumero(numero1, numero2)).isBetween(14,16);
    }

    @Test(expected = RuntimeException.class)
    public void naoDeveSomarNumerosNegativos(){
        calculadora.somarNumero(-10,5);
    }

    /**
     * Executa cenario de teste ja com a sua execucao.
     */
    @Test
    public void deveSubtrairDoisNumero(){
        Assertions.assertThat(calculadora.subtrairNumeros(numero1, numero2)).isEqualTo(5);
    }

    /**
     * Executa cenario de teste ja com a sua execucao.
     */
    @Test
    public void deveMultiplicarDoisNumero(){
        Assertions.assertThat(calculadora.multiplicarNumeros(numero1, numero2)).isEqualTo(50);
    }

    /**
     * Executa cenario de teste ja com a sua execucao.
     */
    @Test
    public void deveDividirDoisNumero(){
        Assertions.assertThat(calculadora.dividirNumeros(numero1, numero2)).isEqualTo(2);
    }

    /**
     * Executa cenario de teste ja com a sua execucao.
     */
    @Test(expected = ArithmeticException.class)
    public void naoDeveDividirPorZero(){
        calculadora.dividirNumeros(10, 0);
    }
}

class Calculadora {

    int somarNumero (int num, int num2) {
        if (num < 0 || num2 <0) {
            throw new RuntimeException("Nao é permitido somar numeros negativos");
        }
        return num + num2;
    }

    int subtrairNumeros(int num, int num2){
        return num - num2;
    }

    int multiplicarNumeros (int num, int num2) {
        return num * num2;
    }

    float dividirNumeros (int num, int num2) {
        return num / num2;
    }
}