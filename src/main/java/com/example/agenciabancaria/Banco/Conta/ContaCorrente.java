package com.example.agenciabancaria.Banco.Conta;

import com.example.agenciabancaria.Banco.Agencia;
import com.example.agenciabancaria.Pessoa.Cliente;

import java.util.Date;
import java.util.List;

public class ContaCorrente extends Conta{
    private float tarifa;

    public ContaCorrente(int id, Agencia agencia, float saldo, Date dataCriacao, Date ultimoAcesso, List<Cliente> clientes, float tarifa) {
        super(id, agencia, saldo, dataCriacao, ultimoAcesso, clientes);
        this.tarifa = tarifa;
    }

    public float getTarifa() {
        return tarifa;
    }

    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }
}
