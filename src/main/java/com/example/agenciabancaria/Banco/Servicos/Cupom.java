package com.example.agenciabancaria.Banco.Servicos;

import com.example.agenciabancaria.Banco.Conta.ContaCorrente;
import com.example.agenciabancaria.Utils;
import java.util.Date;

public class Cupom {
    private int id;
    private Date validade;
    private boolean utilizado;
    private ContaCorrente contaCorrente;
    private Operacao operacao;

    public Cupom(int id, Date validade, ContaCorrente contaCorrente, Operacao operacao) {
        this.id = id;
        this.validade = validade;
        this.utilizado = false;
        this.contaCorrente = contaCorrente;
        this.operacao = operacao;
    }

    public int getId() {
        return id;
    }

    public Date getValidade() {
        return validade;
    }

    public boolean isUtilizado() {
        return utilizado;
    }

    public void utilizar() {
        this.utilizado = true;
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public Operacao getOperacao() {
        return operacao;
    }

    @Override
    public String toString() {
        String validadeString = Utils.convertDateToString(this.validade);
        return "ID: " + id + " / Ag.: " + contaCorrente.getAgencia().getNome() + " / CC: " + contaCorrente.getId() + " / Op.: " + operacao.getId() + " / Válido até: " + validadeString;
    }
}
