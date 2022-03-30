package com.example.agenciabancaria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        String appTitle = "Controle Bancário";
        String mainView = "hello-view.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(mainView));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(appTitle);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}