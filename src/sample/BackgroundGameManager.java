package sample;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class BackgroundGameManager {
    public static void setRgb(Pane GamePane)
    {
        int r = Integer.valueOf(ReadFileSingleton.getInstance().kolorTła1);
        int g = Integer.valueOf(ReadFileSingleton.getInstance().kolorTła2);
        int b = Integer.valueOf(ReadFileSingleton.getInstance().kolorTła3);
        GamePane.setBackground(new Background(new BackgroundFill(Color.rgb(r,g,b), CornerRadii.EMPTY, Insets.EMPTY)));

    }

}
