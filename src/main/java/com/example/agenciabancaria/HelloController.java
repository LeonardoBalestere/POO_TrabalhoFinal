package com.example.agenciabancaria;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController extends BaseController {
    @FXML
    protected Button sairBtn;

    @FXML
    Pane basePane;

    @FXML
    protected void onAgenciasBtnClicked() throws IOException {
        this.openScene("agencias.fxml");
    }

    @FXML
    protected void onClientesBtnClicked() throws IOException {
        this.openScene("clientes.fxml");
    }

    @FXML
    protected void onContasBtnClicked() throws IOException {
        this.openScene("contas.fxml");
    }

    @FXML
    protected void onOperacoesBtnClicked() throws IOException {
        this.openScene("operacoes.fxml");
    }

    @FXML
    protected void onEmprestimosBtnClicked() throws IOException {
        this.openScene("emprestimos.fxml");
    }

    @FXML
    protected void onFuncionariosBtnClicked() throws IOException {
        this.openScene("funcionarios.fxml");
    }

    @FXML
    protected void onCuponsBtnClicked() throws IOException {
        this.openScene("cupons.fxml");
    }

    @FXML
    protected void onSairBtnClicked() {
        final Stage stage = this.getCurrentStage();
        stage.close();
    }
}