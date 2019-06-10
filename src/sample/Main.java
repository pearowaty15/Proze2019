package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.Properties;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("mainScene.fxml"));
        StackPane stackpane = loader.load();
        Scene scene = new Scene(stackpane,300,300);
        primaryStage.setScene(scene);
        primaryStage.setTitle(ReadFileSingleton.getInstance().nazwaGry);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
        ReadFileSingleton readFileSingleton = ReadFileSingleton.getInstance();


    }
}