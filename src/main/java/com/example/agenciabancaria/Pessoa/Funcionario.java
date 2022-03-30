package com.example.agenciabancaria.Pessoa;

import com.example.agenciabancaria.Banco.Agencia;
import com.example.agenciabancaria.Endereco.Cidade;
import com.example.agenciabancaria.Endereco.Estado;
import com.example.agenciabancaria.Enum.TipoCargo;

import java.util.Date;
import java.util.List;

public class Funcionario implements Pessoa {
    private int id;
    private String nome;
    private String cpf;
    private Date nascimento;
    private Cidade cidade;
    private Estado estado;
    private TipoCargo tipoCargo;
    private List<String> dependentes;
    private Funcionario supervisor;
    private Date dataAdmissao;
    private Date dataPromocao;
    private Agencia agencia;

    public Funcionario(String nome, String cpf, Date nascimento, Cidade cidade, Estado estado, int id, List<String> dependentes, Funcionario supervisor, Agencia agencia, TipoCargo tipoCargo, Date admissao) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.cidade = cidade;
        this.estado = estado;
        this.id = id;
        this.dependentes = dependentes;
        this.supervisor = supervisor;
        this.dataAdmissao = admissao;
        this.agencia = agencia;
        this.tipoCargo = tipoCargo;
        this.dataPromocao = null;
    }

    public int getId() {
        return id;
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


    public TipoCargo getTipoCargo() {
        return tipoCargo;
    }

    public void promover(TipoCargo tipoCargo) {
        if(tipoCargo.ordinal() < this.tipoCargo.ordinal()) {
            System.out.println("Impossivel ser promovido para um cargo abaixo");
        } else {
            this.tipoCargo = tipoCargo;
            this.dataPromocao = new Date();
        }
    }

    public Date getDataPromocao() {
        return dataPromocao;
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

    @Override
    public String toString() {
        return nome + " (" + id + " / Ag.: " + agencia.getNome() + " / " + getTipoCargo().name() + ")";
    }
}
