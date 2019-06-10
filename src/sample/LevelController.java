package sample;


import javafx.animation.Animation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.*;
import java.util.Properties;



public class LevelController extends MainController{
    @FXML
    private Button ButtonHard;
    @FXML
    private Button ButtonExpert;
    @FXML
    private Button ButtonMaster;
    public Scene scene;
    private MainController mainController;


    public int lvl;


    @FXML
    public void initialize()
    {

        lvl=Integer.valueOf(ReadFileSingleton.getInstance().liczbaStopniTrudnosci);
        if(lvl==2)
        {
            ButtonHard.setVisible(false);
            ButtonMaster.setVisible(false);
            ButtonExpert.setVisible(false);
        }
        if(lvl==3)
        {ButtonMaster.setVisible(false);
        ButtonExpert.setVisible(false);}
        if(lvl==4)
        {
            ButtonMaster.setVisible(false);
        }


    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void backToNick(ActionEvent actionEvent) {
        mainController.loadMenu();
    }

    public void goToGame(ActionEvent actionEvent) {

        Parent parent=null;
        try{
            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();


            FXMLLoader loader = new FXMLLoader(getClass().getResource("GameScene.fxml"));
            Parent root = loader.load();

            Stage stage =new Stage();
            GameController controller = loader.getController();
           stage.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
                if (KeyCode.ESCAPE == event.getCode()) {
                        System.out.println("wcisnalem");
                    if (controller.loop.getStatus() == Animation.Status.STOPPED) {
                        controller.loop.play();
                        controller.run = true;
                    } else{ controller.loop.stop();
                    controller.run = false;
                }
                }
            });
            scene = new Scene(root,Integer.valueOf(ReadFileSingleton.getInstance().początkowaSzerokośćPlanszy),Integer.valueOf(ReadFileSingleton.getInstance().początkowaWysokośćPlanszy));
            scene.setCursor(Cursor.CROSSHAIR);

            stage.setScene(scene);
            stage.setTitle(ReadFileSingleton.getInstance().nazwaGry);
            stage.show();
        }
        catch(IOException e){};

    }

}
