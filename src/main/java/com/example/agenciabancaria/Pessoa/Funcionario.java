package com.example.agenciabancaria.Pessoa;

import com.example.agenciabancaria.Banco.Agencia;
import com.example.agenciabancaria.Endereco.Cidade;
import com.example.agenciabancaria.Endereco.Estado;

import java.util.Date;
import java.util.List;

public class Funcionario implements Pessoa {
    private String nome;
    private String cpf;
    private Date nascimento;
    private Cidade cidade;
    private Estado estado;
    private int id;
    private List<String> dependentes;
    private Funcionario supervisor;
    private Date dataAdmissao;
    private Agencia agencia;
    private String cargo;

    public Funcionario(String nome, String cpf, Date nascimento, Cidade cidade, Estado estado, int id, List<String> dependentes, Funcionario supervisor, Agencia agencia, String cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.cidade = cidade;
        this.estado = estado;
        this.id = id;
        this.dependentes = dependentes;
        this.supervisor = supervisor;
        this.dataAdmissao = new Date();
        this.agencia = agencia;
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<String> dependentes) {
        this.dependentes = dependentes;
    }

    public Funcionario getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Funcionario supervisor) {
        this.supervisor = supervisor;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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
