package com.example.projeto_aplicacao;

import com.example.projeto_aplicacao.services.QuestoesService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.imageio.IIOParam;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        try{
            ScreenManeger.setStg(stage);

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tela_inicial.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("Tela Inicial");
            stage.setScene(scene);
            stage.show();



        } catch (IOException e ) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}