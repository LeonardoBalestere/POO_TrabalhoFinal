package com.example.agenciabancaria.Banco.Conta;

import com.example.agenciabancaria.Banco.Agencia;
import com.example.agenciabancaria.Pessoa.Cliente;

import java.util.Date;
import java.util.List;

public class ContaPoupanca extends Conta{
    private float taxaJuros;

    public ContaPoupanca(int id, Agencia agencia, float saldo, List<Cliente> clientes, float taxaJuros) {
        super(id, agencia, saldo, clientes);
        this.taxaJuros = taxaJuros;
    }

    public float getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(float taxaJuros) {
        this.taxaJuros = taxaJuros;
    }
}
