package com.designapi;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CadastroPessoaTest {

    @Test
    @DisplayName("Deve criar o cadastro de pessoas.")
    public void deveCriarCadastroDePessoa() {
        // cenario e execucao
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        // verificacao
        Assertions.assertThat(cadastroPessoas.getPessoas()).isEmpty();
    }

    @Test
    @DisplayName("Deve adicionar uma pessoa.")
    public void deveAdicionarUmaPessoa() {
        // cenario
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Everton");
        // exeucacao
        cadastroPessoas.adicionarPessoas(pessoa);

        // verificacao
        Assertions.assertThat(cadastroPessoas.getPessoas()).isNotEmpty().hasSize(1).contains(pessoa);
    }

    @Test
    @DisplayName("Nao deve adicionar pessoa com nome vazio.")
    public void naoDeveAdicionarPessoaComNomeVazio() {
        // cenario
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        // exeucacao
        org.junit.jupiter.api.Assertions.assertThrows(PessoaSemNotException.class, () -> cadastroPessoas.adicionarPessoas(pessoa));
    }

    @Test
    @DisplayName("Deve remover uma pessoa.")
    public void deveRemoverUmaPessoa() {
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Everton");
        cadastroPessoas.adicionarPessoas(pessoa);
        cadastroPessoas.removerPessoa(pessoa);

        // verificacoes
        Assertions.assertThat(cadastroPessoas.getPessoas()).isEmpty();
    }

    @Test
    @DisplayName("Deve lancar erro ao tentar remorever pessoa inexistente.")
    public void deveLancarErroAoTentarRemoverPessoaInexistente() {
        Pessoa pessoa = new Pessoa();

        CadastroPessoas cadastroPessoas = new CadastroPessoas();

        org.junit.jupiter.api.Assertions.assertThrows(CadastroVazioExcepetion.class, () -> cadastroPessoas.removerPessoa(pessoa));
    }
}
