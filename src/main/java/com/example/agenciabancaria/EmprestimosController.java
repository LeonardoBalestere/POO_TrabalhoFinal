package com.example.agenciabancaria;

import com.example.agenciabancaria.Banco.Agencia;
import com.example.agenciabancaria.Banco.Servicos.Emprestimo;
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
import java.util.Date;

public class EmprestimosController extends BaseController {
    @FXML
    Pane basePane;

    @FXML
    protected Button voltarBtn;

    @FXML
    ListView<Emprestimo> list;

    @FXML
    ComboBox<Agencia> agenciasComboBox;

    @FXML
    ComboBox<Cliente> clientesComboBox;

    @FXML
    TextField valorTextField;

    @FXML
    TextField jurosTextField;

    @FXML
    TextField parcelasTextField;

    DataStore dataStore;

    @FXML
    protected void onVoltarClicked() throws IOException {
        this.goBackToMain();
    }

    public void initialize() {
        this.dataStore = DataStore.getInstance();
        this.agenciasComboBox.setItems(FXCollections.observableArrayList(this.dataStore.agencias));
        this.clientesComboBox.setItems(FXCollections.observableArrayList(this.dataStore.clientes));
        this.list.setItems(FXCollections.observableArrayList(this.dataStore.emprestimos));
    }

    @FXML
    protected void onCreate() {
        Agencia agencia = this.agenciasComboBox.getValue();
        Cliente cliente = this.clientesComboBox.getValue();
        String valor = this.valorTextField.getText();
        String juros = this.jurosTextField.getText();
        String parcelas = this.parcelasTextField.getText();
        if (agencia == null || cliente == null || valor == null || juros == null || parcelas == null) {
            return;
        }
        Date date = new Date();
        Emprestimo emprestimo = new Emprestimo(this.dataStore.generateEmprestimoId(), agencia, Float.parseFloat(valor), Float.parseFloat(juros), date, new ArrayList<Cliente>(), Integer.parseInt(parcelas));
        emprestimo.getClientes().add(cliente);
        this.dataStore.emprestimos.add(emprestimo);
        list.getItems().add(emprestimo);
        this.agenciasComboBox.setValue(null);
        this.clientesComboBox.setValue(null);
        this.valorTextField.setText(null);
        this.jurosTextField.setText(null);
        this.parcelasTextField.setText(null);
    }
}
