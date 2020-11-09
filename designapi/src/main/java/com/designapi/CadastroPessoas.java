package com.designapi;

import java.util.ArrayList;
import java.util.List;

public class CadastroPessoas {
    private List<Pessoa> pessoas;

    public CadastroPessoas() {
        this.pessoas = new ArrayList<>();
    }

    public List<Pessoa> getPessoas() {
        return this.pessoas;
    }

    public void adicionarPessoas(Pessoa pessoa) {
        if (pessoa.getNome() == null){
            throw new PessoaSemNotException();
        }
        this.pessoas.add(pessoa);
    }

    public void removerPessoa(Pessoa pessoa) {
        if (this.pessoas.isEmpty()){
            throw new CadastroVazioExcepetion();
        }
        this.pessoas.remove(pessoa);
    }
}
