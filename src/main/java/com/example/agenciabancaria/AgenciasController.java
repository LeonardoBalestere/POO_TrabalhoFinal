package com.example.agenciabancaria;

import com.example.agenciabancaria.Banco.Agencia;
import com.example.agenciabancaria.Endereco.Cidade;
import com.example.agenciabancaria.Endereco.Estado;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import java.io.IOException;

public class AgenciasController extends BaseController {
    @FXML
    Pane basePane;

    @FXML
    ComboBox<Estado> estadoComboBox;

    @FXML
    ComboBox<Cidade> cidadesComboBox;

    @FXML
    TextField nomeTextField;

    @FXML
    ListView<Agencia> list;

    @FXML
    protected Button voltarBtn;

    private DataStore dataStore;

    public void initialize() {
        this.dataStore = DataStore.getInstance();
        this.estadoComboBox.setItems(FXCollections.observableArrayList(this.dataStore.estados));
        this.cidadesComboBox.setItems(FXCollections.observableArrayList(this.dataStore.cidades));
        this.list.setItems(FXCollections.observableArrayList(this.dataStore.agencias));
    }

    @FXML
    protected void onVoltarClicked() throws IOException {
        this.goBackToMain();
    }

    @FXML
    protected void onCreate() {
        Estado estado = this.estadoComboBox.getValue();
        Cidade cidade = this.cidadesComboBox.getValue();
        String nome = this.nomeTextField.getText();
        if (estado == null || cidade == null || nome.isEmpty()) {
            return;
        }
        Agencia agencia = new Agencia(nome, estado, cidade);
        this.dataStore.agencias.add(agencia);
        this.list.getItems().add(agencia);
        this.estadoComboBox.setValue(null);
        this.cidadesComboBox.setValue(null);
        this.nomeTextField.setText(null);
    }
}
