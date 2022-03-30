package com.example.agenciabancaria;

import com.example.agenciabancaria.Banco.Conta.Conta;
import com.example.agenciabancaria.Banco.Conta.ContaCorrente;
import com.example.agenciabancaria.Banco.Servicos.Cupom;
import com.example.agenciabancaria.Banco.Servicos.Operacao;
import com.example.agenciabancaria.Enum.TipoOperacao;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public class OperacoesController extends BaseController {
    @FXML
    Pane basePane;

    @FXML
    ListView<Operacao> list;

    @FXML
    ComboBox<Conta> contaCorrenteComboBox;

    @FXML
    ComboBox<TipoOperacao> tipoOperacaoComboBox;

    @FXML
    TextField descricaoTextField;

    @FXML
    TextField valorTextField;

    @FXML
    protected Button voltarBtn;

    DataStore dataStore;

    public void initialize() {
        this.dataStore = DataStore.getInstance();
        this.contaCorrenteComboBox.setItems(FXCollections.observableArrayList(this.dataStore.getContasCorrente()));
        this.tipoOperacaoComboBox.setItems(FXCollections.observableArrayList(this.dataStore.tipoOperacoes));
        this.list.setItems(FXCollections.observableArrayList(this.dataStore.operacoes));
    }

    @FXML
    protected void onVoltarClicked() throws IOException {
        this.goBackToMain();
    }

    @FXML
    protected void onCreate() {
        ContaCorrente contaCorrente = (ContaCorrente) this.contaCorrenteComboBox.getValue();
        TipoOperacao tipoOperacao = this.tipoOperacaoComboBox.getValue();
        String descricao = this.descricaoTextField.getText();
        String valor = this.valorTextField.getText();
        if (contaCorrente == null || tipoOperacao == null || descricao == null || valor == null) {
            return;
        }
        Operacao operacao = new Operacao(this.dataStore.generateOperacaoId(contaCorrente), contaCorrente, tipoOperacao, descricao, Float.parseFloat(valor));
        this.dataStore.operacoes.add(operacao);
        this.list.getItems().add(operacao);

        if (operacao.getValor() > 5000) {
            try {
                Date validade = Utils.convertStringToDate("31/12/2022");
                Cupom cupom = new Cupom(this.dataStore.generateCupomId(), validade, contaCorrente, operacao);
                this.dataStore.cupons.add(cupom);
            } catch (ParseException e) {
                //
            }
        }

        this.contaCorrenteComboBox.setValue(null);
        this.tipoOperacaoComboBox.setValue(null);
        this.descricaoTextField.setText(null);
        this.valorTextField.setText(null);
    }
}
