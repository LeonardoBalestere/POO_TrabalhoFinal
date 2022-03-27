package com.example.agenciabancaria.Pessoa;

import com.example.agenciabancaria.Banco.Conta.Conta;
import com.example.agenciabancaria.Banco.Servicos.Emprestimo;
import com.example.agenciabancaria.Endereco.Cidade;
import com.example.agenciabancaria.Endereco.Estado;

import java.util.Date;
import java.util.List;

public class Cliente implements Pessoa {
    private String nome;
    private String cpf;
    private Date nascimento;
    private Cidade cidade;
    private Estado estado;
    private int id;
    private Funcionario gerente;
    private List<Conta> contas;
    private Emprestimo emprestimo;

    public Cliente(String nome, String cpf, Date nascimento, Cidade cidade, Estado estado, int id, Funcionario gerente, List<Conta> contas, Emprestimo emprestimo) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.cidade = cidade;
        this.estado = estado;
        this.id = id;
        this.gerente = gerente;
        this.contas = contas;
        this.emprestimo = emprestimo;
    }

    public int getId() {
        return id;
    }

    public Funcionario getGerente() {
        return gerente;
    }

    public void setGerente(Funcionario gerente) {
        this.gerente = gerente;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getCpf() {
        return cpf;
    }

    @Override
    public Date getNascimento() {
        return nascimento;
    }

    @Override
    public Cidade getCidade() {
        return cidade;
    }

    @Override
    public Estado getEstado() {
        return estado;
    }
}
