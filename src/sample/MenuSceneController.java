package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MenuSceneController {

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    private MainController mainController;
    @FXML
    public void openAplication(ActionEvent actionEvet) {

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("NickScene.fxml"));
        changePanel(loader);
    }

    public void openHelp(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("HelpScene.fxml"));
        changePanel(loader);

    }

    public void openScores() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("ScoreScene.fxml"));
        changePanel(loader);

    }

    public void changePanel(FXMLLoader loader) {
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
        }
        NickController nickController = loader.getController();
        nickController.setMainController(mainController);
        mainController.setScene(pane);
    }

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
    }
}
