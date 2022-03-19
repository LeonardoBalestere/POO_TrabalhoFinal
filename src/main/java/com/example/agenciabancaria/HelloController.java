package com.example.agenciabancaria;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    protected Button sairBtn;

    @FXML
    protected void onAgenciasBtnClicked() {
    }

    @FXML
    protected void onClientesBtnClicked() {
    }

    @FXML
    protected void onContasBtnClicked() {
    }

    @FXML
    protected void onOperacoesBtnClicked() {
    }

    @FXML
    protected void onEmprestimosBtnClicked() {
    }

    @FXML
    protected void onFuncionariosBtnClicked() {
    }

    @FXML
    protected void onCuponsBtnClicked() {
    }

    @FXML
    protected void onSairBtnClicked() {
        final Stage stage = (Stage) this.sairBtn.getScene().getWindow();
        stage.close();
    }
}