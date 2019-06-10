package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.*;
import java.util.Properties;

public class MainController  {
    @FXML
    public StackPane mainPane;

    public void setMainPane(StackPane mainPane) {
        this.mainPane = mainPane;
    }

    @FXML
    public void initialize()
    {

        loadMenu();
    }

    public void loadMenu() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("MenuScene.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        }
        catch(IOException e)
        {}
        MenuSceneController menuSceneController = loader.getController();
        menuSceneController.setMainController(this);
        setScene(pane);
    }

    public void setScene(Pane pane) {
        mainPane.getChildren().clear();
        mainPane.getChildren().add(pane);
    }

}
