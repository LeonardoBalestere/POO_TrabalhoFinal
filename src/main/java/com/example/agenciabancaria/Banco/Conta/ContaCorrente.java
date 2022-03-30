package com.example.agenciabancaria.Banco.Conta;

import com.example.agenciabancaria.Banco.Agencia;
import com.example.agenciabancaria.Banco.Servicos.Cupom;
import com.example.agenciabancaria.Banco.Servicos.Operacao;
import com.example.agenciabancaria.Enum.TipoOperacao;
import com.example.agenciabancaria.Pessoa.Cliente;

import java.util.Date;
import java.util.List;

public class ContaCorrente extends Conta {
    private float tarifa;
    private List<Operacao> operacoes;

    public ContaCorrente(int id, Agencia agencia, float saldo, List<Cliente> clientes, float tarifa) {
        super(id, agencia, saldo, clientes);
        this.tarifa = tarifa;
    }

    public float getTarifa() {
        return tarifa;
    }

    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }

    public void operar(int id, TipoOperacao tipoOperacao, String descricao, float valor){
        Operacao operacao = new Operacao(id,this,tipoOperacao,descricao,valor);
        operacoes.add(operacao);
        if(valor > 50000.00){
            System.out.println("Parabens, voce acaba de ganhar um cupom numero" + id);
            Cupom cupom = new Cupom(id, new Date(2023,01,01), this, operacao);
        }
    }

    @Override
    public String toString() {
        return "[CC] Ag.: " + getAgencia().getNome() + " / ID: " + getId() + " / Tarifa: " + getTarifa() + " / Saldo: " + getSaldo();
    }
}
