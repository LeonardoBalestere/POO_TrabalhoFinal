package com.example.agenciabancaria;

import com.example.agenciabancaria.Banco.Conta.Conta;
import com.example.agenciabancaria.Banco.Conta.ContaCorrente;
import com.example.agenciabancaria.Banco.Servicos.Cupom;
import com.example.agenciabancaria.Banco.Servicos.Operacao;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.time.LocalDate;

public class CuponsController extends BaseController {
    @FXML
    Pane basePane;

    @FXML
    protected Button voltarBtn;

    @FXML
    ListView<Cupom> list;

    @FXML
    ComboBox<Conta> contaCorrenteComboBox;

    @FXML
    ComboBox<Operacao> operacaoComboBox;

    @FXML
    DatePicker validadeDatePicker;

    DataStore dataStore;

    @FXML
    protected void onVoltarClicked() throws IOException {
        this.goBackToMain();
    }

    public void initialize() {
        this.dataStore = DataStore.getInstance();
        this.contaCorrenteComboBox.setItems(FXCollections.observableArrayList(this.dataStore.getContasCorrente()));
        this.operacaoComboBox.setItems(FXCollections.observableArrayList(this.dataStore.operacoes));
        this.list.setItems(FXCollections.observableArrayList(this.dataStore.cupons));
    }

    @FXML
    protected void onCreate() {
        ContaCorrente conta = (ContaCorrente)contaCorrenteComboBox.getValue();
        Operacao operacao = operacaoComboBox.getValue();
        LocalDate validade = validadeDatePicker.getValue();
        if (conta == null || operacao == null || validade == null) {
            return;
        }
        Cupom cupom = new Cupom(this.dataStore.generateCupomId(), Utils.convertLocalDateToDate(validade), conta, operacao);
        this.dataStore.cupons.add(cupom);
        list.getItems().add(cupom);
        this.contaCorrenteComboBox.setValue(null);
        this.operacaoComboBox.setValue(null);
        this.validadeDatePicker.setValue(null);
    }
}
