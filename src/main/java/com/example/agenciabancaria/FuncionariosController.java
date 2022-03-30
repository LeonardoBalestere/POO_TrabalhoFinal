package com.example.agenciabancaria;

import com.example.agenciabancaria.Banco.Agencia;
import com.example.agenciabancaria.Endereco.Cidade;
import com.example.agenciabancaria.Endereco.Estado;
import com.example.agenciabancaria.Enum.TipoCargo;
import com.example.agenciabancaria.Pessoa.Funcionario;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FuncionariosController extends BaseController {
    @FXML
    Pane basePane;

    @FXML
    protected Button voltarBtn;

    @FXML
    ListView<Funcionario> list;

    @FXML
    ComboBox<Estado> estadoComboBox;

    @FXML
    ComboBox<Cidade> cidadeComboBox;

    @FXML
    TextField nomeTextField;

    @FXML
    TextField cpfTextField;

    @FXML
    DatePicker nascimentoDatePicker;

    @FXML
    ComboBox<TipoCargo> cargoComboBox;

    @FXML
    ComboBox<Funcionario> supervisorComboBox;

    @FXML
    ComboBox<Agencia> agenciaComboBox;

    @FXML
    TextField dependentesTextField;

    @FXML
    DatePicker admissaoDatePicker;

    DataStore dataStore;

    public void initialize() {
        this.dataStore = DataStore.getInstance();
        this.estadoComboBox.setItems(FXCollections.observableArrayList(this.dataStore.estados));
        this.cidadeComboBox.setItems(FXCollections.observableArrayList(this.dataStore.cidades));
        this.cargoComboBox.setItems(FXCollections.observableArrayList(this.dataStore.tipoCargos));
        this.supervisorComboBox.setItems(FXCollections.observableArrayList(this.dataStore.getSupervisores()));
        this.agenciaComboBox.setItems(FXCollections.observableArrayList(this.dataStore.agencias));
        this.list.setItems(FXCollections.observableArrayList(this.dataStore.funcionarios));
    }

    @FXML
    protected void onVoltarClicked() throws IOException {
        this.goBackToMain();
    }

    @FXML
    protected void onCreate() {
        Estado estado = this.estadoComboBox.getValue();
        Cidade cidade = this.cidadeComboBox.getValue();
        String nome = this.nomeTextField.getText();
        String cpf = this.cpfTextField.getText();
        LocalDate nascimento = this.nascimentoDatePicker.getValue();
        TipoCargo cargo = this.cargoComboBox.getValue();
        Funcionario supervisor = this.supervisorComboBox.getValue();
        Agencia agencia = this.agenciaComboBox.getValue();
        LocalDate admissao = this.admissaoDatePicker.getValue();
        String dependentes = this.dependentesTextField.getText();
        if (estado == null
                || cidade == null
                || nome == null
                || cpf == null
                || nascimento == null
                || cargo == null
                || agencia == null
                || admissao == null
        ) {
            return;
        }
        List<String> dependentesList = new ArrayList<String>();
        Arrays.stream(dependentes.split(",")).toList().forEach((String dependente) -> dependentesList.add(dependente));
        Funcionario funcionario = new Funcionario(
                nome,
                cpf,
                Utils.convertLocalDateToDate(nascimento),
                cidade,
                estado,
                this.dataStore.generateFuncionarioId(),
                dependentesList,
                supervisor,
                agencia,
                cargo,
                Utils.convertLocalDateToDate(admissao)
        );
        this.dataStore.funcionarios.add(funcionario);
        list.getItems().add(funcionario);
        this.estadoComboBox.setValue(null);
        this.cidadeComboBox.setValue(null);
        this.cargoComboBox.setValue(null);
        this.supervisorComboBox.setValue(null);
        this.agenciaComboBox.setValue(null);
        this.nomeTextField.setText(null);
        this.cpfTextField.setText(null);
        this.nascimentoDatePicker.setValue(null);
        this.admissaoDatePicker.setValue(null);
        this.dependentesTextField.setText(null);
    }
}
