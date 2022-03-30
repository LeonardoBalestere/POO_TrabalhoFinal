package com.example.agenciabancaria;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

public abstract class BaseController {
    @FXML
    Pane basePane;

    protected Stage getCurrentStage() {
        return (Stage) this.basePane.getScene().getWindow();
    }

    protected void openScene(String fileName) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fileName));
        final Stage stage = this.getCurrentStage();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
    }

    protected void goBackToMain() throws IOException {
        this.openScene("hello-view.fxml");
    }
}
