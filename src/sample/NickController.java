package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import java.io.IOException;
public class NickController {

    private MainController mainController;
    public void backToMenu(ActionEvent actionEvent) {
        mainController.loadMenu();
    }
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void goToLevel(ActionEvent actionEvent) {

        loadLevel();

    }



    public void loadLevel() {

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("LevelScene.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
        }
        LevelController levelController = loader.getController();
        levelController.setMainController(mainController);

        mainController.setScene(pane);

    }
}
