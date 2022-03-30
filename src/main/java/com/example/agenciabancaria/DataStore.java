package com.example.agenciabancaria;

import com.example.agenciabancaria.Banco.Agencia;
import com.example.agenciabancaria.Banco.Conta.Conta;
import com.example.agenciabancaria.Banco.Conta.ContaCorrente;
import com.example.agenciabancaria.Banco.Servicos.Cupom;
import com.example.agenciabancaria.Banco.Servicos.Emprestimo;
import com.example.agenciabancaria.Banco.Servicos.Operacao;
import com.example.agenciabancaria.Endereco.Cidade;
import com.example.agenciabancaria.Endereco.Estado;
import com.example.agenciabancaria.Enum.TipoCargo;
import com.example.agenciabancaria.Enum.TipoOperacao;
import com.example.agenciabancaria.Pessoa.Cliente;
import com.example.agenciabancaria.Pessoa.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class DataStore {
    private static DataStore instance;

    List<Estado> estados;
    List<Cidade> cidades;
    List<Agencia> agencias;
    List<Cliente> clientes;
    List<Conta> contas;
    List<Funcionario> funcionarios;
    List<String> tipoContas;
    List<Operacao> operacoes;
    List<TipoOperacao> tipoOperacoes;
    List<Emprestimo> emprestimos;
    List<TipoCargo> tipoCargos;
    List<Cupom> cupons;

    private DataStore() {
        this.estados = new ArrayList<Estado>();
        this.cidades = new ArrayList<Cidade>();
        this.agencias = new ArrayList<Agencia>();
        this.clientes = new ArrayList<Cliente>();
        this.contas = new ArrayList<Conta>();
        this.tipoContas = new ArrayList<String>();
        this.funcionarios = new ArrayList<Funcionario>();
        this.operacoes = new ArrayList<Operacao>();
        this.tipoOperacoes = new ArrayList<TipoOperacao>();
        this.emprestimos = new ArrayList<Emprestimo>();
        this.tipoCargos = new ArrayList<TipoCargo>();
        this.cupons = new ArrayList<Cupom>();
        this.populate();
    }

    private void populate() {
        this.estados.add(new Estado("Minas Gerais", "MG"));
        this.estados.add(new Estado("São Paulo", "SP"));
        this.cidades.add(new Cidade("Uberlândia"));
        this.cidades.add(new Cidade("Uberaba"));
        this.cidades.add(new Cidade("Belo Horizonte"));
        this.cidades.add(new Cidade("São Paulo"));
        this.cidades.add(new Cidade("Campinas"));
        this.tipoContas.add("Corrente");
        this.tipoContas.add("Poupanca");
        this.tipoOperacoes.add(TipoOperacao.CREDITO);
        this.tipoOperacoes.add(TipoOperacao.DEBITO);
        this.tipoCargos.add(TipoCargo.DIRETOR);
        this.tipoCargos.add(TipoCargo.SUPERVISOR);
        this.tipoCargos.add(TipoCargo.GERENTE);
        this.tipoCargos.add(TipoCargo.ANALISTA);
        this.tipoCargos.add(TipoCargo.DESENVOLVEDOR);
        this.tipoCargos.add(TipoCargo.ATENDENTE);
    }

    public static DataStore getInstance() {
        if (instance == null) {
            instance = new DataStore();
        }
        return instance;
    }

    public List<Funcionario> getGerentes() {
        return this.funcionarios.stream().filter((Funcionario funcionario) -> funcionario.getTipoCargo() == TipoCargo.GERENTE).toList();
    }

    public List<Conta> getContasCorrente() {
        return this.contas.stream().filter((Conta conta) -> conta.getClass() == ContaCorrente.class).toList();
    }

    public List<Funcionario> getSupervisores() {
        return this.funcionarios.stream().filter((Funcionario funcionario) -> funcionario.getTipoCargo() == TipoCargo.SUPERVISOR).toList();
    }

    protected int generateFuncionarioId() {
        if (this.funcionarios.isEmpty()) {
            return 1;
        }
        int lastItemIndex = this.funcionarios.size() - 1;
        Funcionario funcionario = this.funcionarios.get(lastItemIndex);
        return funcionario.getId() + 1;
    }

    protected int generateClienteId() {
        if (this.clientes.isEmpty()) {
            return 1;
        }
        int lastItemIndex = this.clientes.size() - 1;
        Cliente cliente = this.clientes.get(lastItemIndex);
        return cliente.getId() + 1;
    }

    protected int generateContaId(Agencia agencia) {
        List<Conta> contasDaAgencia = this.contas.stream().filter((c) -> c.getAgencia().getNome().equals(agencia.getNome())).toList();
        if (contasDaAgencia.isEmpty()) return 1;
        int lastItemIndex = contasDaAgencia.size() - 1;
        Conta conta = contasDaAgencia.get(lastItemIndex);
        return conta.getId() + 1;
    }

    protected int generateOperacaoId(ContaCorrente conta) {
        List<Operacao> operacoesDaConta = this.operacoes.stream().filter(
                (o) -> o.getContaCorrente().getAgencia().getNome().equals(conta.getAgencia().getNome()) && o.getContaCorrente().getId() == conta.getId()
        ).toList();
        if (operacoesDaConta.isEmpty()) return 1;
        int lastItemIndex = operacoesDaConta.size() - 1;
        Operacao operacao = operacoesDaConta.get(lastItemIndex);
        return operacao.getId() + 1;
    }

    protected int generateEmprestimoId() {
        if (this.emprestimos.isEmpty()) {
            return 1;
        }
        int lastItemIndex = this.emprestimos.size() - 1;
        Emprestimo emprestimo = this.emprestimos.get(lastItemIndex);
        return emprestimo.getId() + 1;
    }

    protected int generateCupomId() {
        if (this.cupons.isEmpty()) {
            return 1;
        }
        int lastItemIndex = this.cupons.size() - 1;
        Cupom cupom = this.cupons.get(lastItemIndex);
        return cupom.getId() + 1;
    }
}
