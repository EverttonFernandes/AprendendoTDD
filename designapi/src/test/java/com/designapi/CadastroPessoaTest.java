package com.designapi;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CadastroPessoaTest {

    @Test
    public void deveCriarCadastroDePessoa(){
        // cenario e execucao
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        // verificacao
        Assertions.assertThat(cadastroPessoas.getPessoas()).isEmpty();
    }

    @Test
    public void deveAdicionarUmaPessoa(){
        // cenario
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Everton");
        // exeucacao
        cadastroPessoas.adicionarPessoas(pessoa);

        // verificacao
        Assertions.assertThat(cadastroPessoas.getPessoas()).isNotEmpty().hasSize(1).contains(pessoa);
    }

    @Test(expected = PessoaSemNotException.class)
    public void naoDeveAdicionarPessoaComNomeVazio () {
        // cenario
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        // exeucacao
        cadastroPessoas.adicionarPessoas(pessoa);
    }

    @Test
    public void deveRemoverUmaPessoa(){
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Everton");
        cadastroPessoas.adicionarPessoas(pessoa);
        cadastroPessoas.removerPessoa(pessoa);

        // verificacoes
        Assertions.assertThat(cadastroPessoas.getPessoas()).isEmpty();
    }

    @Test(expected = CadastroVazioExcepetion.class)
    public void deveLancarErroAoTentarRemoverPessoaInexistente(){
        Pessoa pessoa = new Pessoa();
        CadastroPessoas cadastroPessoas = new CadastroPessoas();

        cadastroPessoas.removerPessoa(pessoa);
    }
}
