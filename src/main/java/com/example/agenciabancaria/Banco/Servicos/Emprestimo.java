package com.example.agenciabancaria.Banco.Servicos;

import com.example.agenciabancaria.Banco.Agencia;
import com.example.agenciabancaria.Pessoa.Cliente;

import java.util.Date;

public class Emprestimo {
    private int id;
    private Agencia agencia;
    private float valor;
    private float juros;
    private Date date;
    private Cliente cliente;
    private int parcelas;

    public Emprestimo(int id, Agencia agencia, float valor, float juros, Date date, Cliente cliente, int parcelas) {
        this.id = id;
        this.agencia = agencia;
        this.valor = valor;
        this.juros = juros;
        this.date = date;
        this.cliente = cliente;
        this.parcelas = parcelas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getJuros() {
        return juros;
    }

    public void setJuros(float juros) {
        this.juros = juros;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }
}
