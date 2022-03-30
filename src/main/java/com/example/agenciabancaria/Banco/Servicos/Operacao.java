package com.example.agenciabancaria.Banco.Servicos;

import com.example.agenciabancaria.Banco.Conta.ContaCorrente;
import com.example.agenciabancaria.Enum.TipoOperacao;

import java.util.Date;

public class Operacao {
    private int id;
    private ContaCorrente contaCorrente;
    private TipoOperacao tipoOperacao;
    private String descricao;
    private float valor;
    private Date date;

    public Operacao(int id, ContaCorrente contaCorrente, TipoOperacao tipoOperacao, String descricao, float valor) {
        this.id = id;
        this.contaCorrente = contaCorrente;
        this.tipoOperacao = tipoOperacao;
        this.descricao = descricao;
        this.valor = valor;
        this.date = new Date();
    }

    public int getId() {
        return id;
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public TipoOperacao getTipoOperacao() {
        return tipoOperacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public Date getDate() {
        return date;
    }
}
