package com.example.agenciabancaria.Banco.Conta;

import com.example.agenciabancaria.Banco.Agencia;
import com.example.agenciabancaria.Pessoa.Cliente;

import java.util.Date;
import java.util.List;

public class Conta {
    private int id;
    private Agencia agencia;
    private float saldo;
    private Date dataCriacao;
    private Date ultimoAcesso;
    private List<Cliente> clientes;

    public Conta(int id, Agencia agencia, float saldo, Date dataCriacao, Date ultimoAcesso, List<Cliente> clientes) {
        this.id = id;
        this.agencia = agencia;
        this.saldo = saldo;
        this.dataCriacao = dataCriacao;
        this.ultimoAcesso = ultimoAcesso;
        this.clientes = clientes;
    }

    public int getId() {
        return id;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public float getSaldo() {
        return saldo;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public Date getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(Date ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
