package com.example.agenciabancaria;

import com.example.agenciabancaria.Banco.Agencia;
import com.example.agenciabancaria.Banco.Conta.Conta;
import com.example.agenciabancaria.Banco.Conta.ContaCorrente;
import com.example.agenciabancaria.Banco.Conta.ContaPoupanca;
import com.example.agenciabancaria.Pessoa.Cliente;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContasController extends BaseController {
    @FXML
    Pane basePane;

    @FXML
    ComboBox<Agencia> agenciaComboBox;

    @FXML
    ComboBox<Cliente> clienteComboBox;

    @FXML
    ComboBox<String> tipoContaComboBox;

    @FXML
    ListView<Conta> list;

    @FXML
    TextField tarifaTextField;

    @FXML
    TextField taxaJurosTextField;

    @FXML
    protected Button voltarBtn;

    DataStore dataStore;

    public void initialize() {
        this.dataStore = DataStore.getInstance();
        this.agenciaComboBox.setItems(FXCollections.observableArrayList(this.dataStore.agencias));
        this.clienteComboBox.setItems(FXCollections.observableArrayList(this.dataStore.clientes));
        this.tipoContaComboBox.setItems(FXCollections.observableArrayList(this.dataStore.tipoContas));
        this.list.setItems(FXCollections.observableArrayList(this.dataStore.contas));
        this.tarifaTextField.setDisable(true);
        this.taxaJurosTextField.setDisable(true);
    }

    @FXML
    protected void onVoltarClicked() throws IOException {
        this.goBackToMain();
    }

    @FXML
    protected void onCreate() {
        Agencia agencia = this.agenciaComboBox.getValue();
        Cliente cliente = this.clienteComboBox.getValue();
        String tipoConta = this.tipoContaComboBox.getValue();
        String tarifa = this.tarifaTextField.getText();
        String taxaJuros = this.taxaJurosTextField.getText();
        if (agencia == null || cliente == null || tipoConta == null || (tipoConta == "Corrente" && tarifa == null) || (tipoConta == "Poupanca" && taxaJuros == null)) {
            return;
        }
        Conta conta = null;
        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(cliente);
        if (tipoConta == "Corrente") {
            int id = this.dataStore.generateContaId(agencia);
            conta = new ContaCorrente(id, agencia, 0, clientes, Float.parseFloat(tarifa));
        }
        if (tipoConta == "Poupanca") {
            int id = this.dataStore.generateContaId(agencia);
            conta = new ContaPoupanca(id, agencia, 0, clientes, Float.parseFloat(taxaJuros));
        }
        cliente.getContas().add(conta);
        this.dataStore.contas.add(conta);
        this.list.getItems().add(conta);
        this.agenciaComboBox.setValue(null);
        this.clienteComboBox.setValue(null);
        this.tipoContaComboBox.setValue(null);
        this.tarifaTextField.setText(null);
        this.taxaJurosTextField.setText(null);
    }

    @FXML
    protected void onTipoContaChanged() {
        String tipoConta = this.tipoContaComboBox.getValue();
        if (tipoConta == "Corrente") {
            this.tarifaTextField.setDisable(false);
            this.taxaJurosTextField.setDisable(true);
            return;
        }
        this.tarifaTextField.setDisable(true);
        this.taxaJurosTextField.setDisable(false);
    }
}
