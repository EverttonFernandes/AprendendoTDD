package com.designapi;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class PrimeiroTeste {

    Calculadora calculadora;
    int numero1 = 10, numero2 = 5;

    /**
     * Metodo responsavel por inicializar a classe calculadora
     */
    @Before
    public void setUp(){
        calculadora = new Calculadora();
    }

    /**
     * Executa cenario de teste para somar dois numeros.
     */
    @Test
    public void deveSomarDoisNumero () {
        Assertions.assertThat(new Calculadora().somarNumero(numero1, numero2)).isBetween(14,16);
    }

    /**
     * Executa cenario de teste para nao aceitar a soma de numeros negativos
     */
    @Test(expected = RuntimeException.class)
    public void naoDeveSomarNumerosNegativos(){
        calculadora.somarNumero(-10,5);
    }

    /**
     * Executa cenario de teste para subtrair dois numeros.
     */
    @Test
    public void deveSubtrairDoisNumero(){
        Assertions.assertThat(calculadora.subtrairNumeros(numero1, numero2)).isEqualTo(5);
    }

    /**
     * Executa cenario de teste para multiplicar dois numeros.
     */
    @Test
    public void deveMultiplicarDoisNumero(){
        Assertions.assertThat(calculadora.multiplicarNumeros(numero1, numero2)).isEqualTo(50);
    }

    /**
     * Executa cenario de teste com a divisao de dois numeros.
     */
    @Test
    public void deveDividirDoisNumero(){
        Assertions.assertThat(calculadora.dividirNumeros(numero1, numero2)).isEqualTo(2);
    }

    /**
     * Executa cenario de teste que nao aceita divisao de numeros por zero.
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