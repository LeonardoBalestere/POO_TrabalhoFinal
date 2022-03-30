package com.example.agenciabancaria;

import com.example.agenciabancaria.Banco.Conta.Conta;
import com.example.agenciabancaria.Endereco.Cidade;
import com.example.agenciabancaria.Endereco.Estado;
import com.example.agenciabancaria.Pessoa.Cliente;
import com.example.agenciabancaria.Pessoa.Funcionario;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientesController extends BaseController {
    @FXML
    Pane basePane;

    @FXML
    protected Button voltarBtn;

    @FXML
    ComboBox<Estado> estadoComboBox;

    @FXML
    ComboBox<Cidade> cidadesComboBox;

    @FXML
    ComboBox<Funcionario> gerenteComboBox;

    @FXML
    TextField nomeTextField;

    @FXML
    TextField cpfTextField;

    @FXML
    DatePicker dataNascimentoDatePicker;

    @FXML
    ListView<Cliente> list;

    DataStore dataStore;

    @FXML
    protected void onVoltarClicked() throws IOException {
        this.goBackToMain();
    }

    public void initialize() {
        this.dataStore = DataStore.getInstance();
        this.estadoComboBox.setItems(FXCollections.observableArrayList(this.dataStore.estados));
        this.cidadesComboBox.setItems(FXCollections.observableArrayList(this.dataStore.cidades));
        this.gerenteComboBox.setItems(FXCollections.observableArrayList(this.dataStore.getGerentes()));
        this.list.setItems(FXCollections.observableArrayList(this.dataStore.clientes));
    }

    @FXML
    protected void onCreate() {
        Estado estado = this.estadoComboBox.getValue();
        Cidade cidade = this.cidadesComboBox.getValue();
        String nome = this.nomeTextField.getText();
        String cpf = this.cpfTextField.getText();
        LocalDate nascimento = this.dataNascimentoDatePicker.getValue();
        Funcionario gerente = this.gerenteComboBox.getValue();
        if (estado == null || cidade == null || nome.isEmpty() || cpf.isEmpty() || nascimento == null || gerente == null) {
            return;
        }
        int id = this.dataStore.generateClienteId();
        List<Conta> contas = new ArrayList<Conta>();
        Date nascimentoDate = Utils.convertLocalDateToDate(nascimento);
        Cliente cliente = new Cliente(nome, cpf, nascimentoDate, cidade, estado, id, gerente, contas);
        this.dataStore.clientes.add(cliente);
        this.list.getItems().add(cliente);
        this.estadoComboBox.setValue(null);
        this.cidadesComboBox.setValue(null);
        this.nomeTextField.setText(null);
        this.cpfTextField.setText(null);
        this.dataNascimentoDatePicker.setValue(null);
        this.gerenteComboBox.setValue(null);
    }
}
