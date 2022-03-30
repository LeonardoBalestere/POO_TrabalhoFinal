package com.example.agenciabancaria.Banco.Conta;

import com.example.agenciabancaria.Banco.Agencia;
import com.example.agenciabancaria.Pessoa.Cliente;

import java.util.Date;
import java.util.List;

public abstract class Conta {
    private int id;
    private Agencia agencia;
    private float saldo;
    private Date dataCriacao;
    private Date ultimoAcesso;
    private List<Cliente> clientes;
    private boolean cancelado;

    public Conta(int id, Agencia agencia, float saldo, List<Cliente> clientes) {
        this.id = id;
        this.agencia = agencia;
        this.saldo = saldo;
        this.dataCriacao = new Date();
        this.ultimoAcesso = null;
        this.clientes = clientes;
        this.cancelado = false;
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

    public void acessar() {
        this.ultimoAcesso = new Date();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void cancelar() {
        this.cancelado = true;
    }

    public void sacar(float quantidade){
        if (saldo >= quantidade){
            saldo -= quantidade;
        } else{
            System.out.println("Saldo insuficiente");
        }
    }

    public void depositar(float quantidade){
        saldo += quantidade;
    }
}
