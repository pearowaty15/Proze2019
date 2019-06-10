//package sample;
//
//import javafx.animation.KeyFrame;
//import javafx.animation.Timeline;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Bounds;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Label;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.Pane;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Circle;
//import javafx.util.Duration;
//
//import javax.swing.text.StyledEditorKit;
//import java.sql.Time;
//import java.util.Random;
//
//public class CircleManager extends GameController {
//    public double radius;
//    public double x;
//    public double y;
//
//
//    private Double ratioChange;
//    int qqq;
//    String level;
//    public Circle createCircle(Pane GamePane, Label score, Label numberOfLive, Label levelName,  Boolean run)
//    {
//        getRatioChange();
//        level=ReadFileLevelSingleton.getInstance().nazwaPoziomu1;
//        radius=Double.valueOf(ReadFileSingleton.getInstance().początkowaSzerokośćPlanszy);
//        radius=radius/100;
//        radius=radius*Double.valueOf(ReadFileSingleton.getInstance().początkowaSzerokośćObiektuGryJakoProcentPoczątkowejSzerokościPlanszy);
//        x=(int) radius;
//        System.out.println(x);
//
//        Circle circle = new Circle(x);
//        circle.relocate(5, 5);
//        circle.setLayoutY(80);
//        circle.setLayoutX(80);
//        circle.setFill(Color.BLUE);
//        GamePane.getChildren().add(circle);
//        String quantity;
//        quantity=ReadFileLevelSingleton.getInstance().liczbaŻyć1;
//        qqq= Integer.parseInt(quantity);
//
//        //Creating the mouse event handler
//        System.out.println(run);
//
//        // Funkcja odpowiedzialna za sprawdzenie allertow
//        createAllert(circle, GamePane,numberOfLive,levelName,run);
//        eventClick(circle, score,run);
//
//        return circle;
//    }
//    public void eventClick(Circle circle, Label score,Boolean run)
//    {
//        //Registering the event filter
//
//        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
//            int scor=0;
//            int k=10;
//            @Override
//            public void handle(MouseEvent e) {
//
//                if (run) {
//                    circle.setVisible(false);
//                    try {
//                        Thread.sleep(100);
//                    }catch(InterruptedException ex){}
//                    circle.setVisible(true);
//                    Random rand = new Random();
//                    int c=Integer.valueOf(ReadFileSingleton.getInstance().początkowaSzerokośćPlanszy);
//                    c=c/2;
//                    int randX = rand.nextInt(c);
//                    randX=randX+100;
//                    Random randy = new Random();
//                    int b=Integer.valueOf(ReadFileSingleton.getInstance().początkowaWysokośćPlanszy);
//                    b=b/2;
//                    int randY = randy.nextInt(b);
//                    randX=randX+100;
//                    randY=randY/2;
//                    randY=randY+100;
//                    circle.setLayoutY(randY);
//                    circle.setLayoutX(randX);
//                    score.setText(String.valueOf(scor + k));
//                    if(level.equals("Poziom 1")){
//                        k = k + 10;}
//                    if(level.equals("Poziom 2"))
//                    {
//                        k=k+20;
//                    }
//                    if(level.equals("Poziom 3"))
//                    {
//                        k=k+30;
//                    }
//                }
//            }
//        };
//        //Registering the event filter
//        circle.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
//    }
//    public void moveSystem(Circle circle, double ratio,Pane GamePane){
//        loop = new Timeline(new KeyFrame(Duration.millis(40*ratio), new EventHandler<ActionEvent>() {
//
//            double deltaX = 1;
//            double deltaY = 1;
//
//            @Override
//            public void handle(final ActionEvent t) {
//                circle.setLayoutX(circle.getLayoutX() + deltaX);
//                circle.setLayoutY(circle.getLayoutY() + deltaY);
//
//                final Bounds bounds = GamePane.getBoundsInLocal();
//                final boolean atRightBorder = circle.getLayoutX() >= (bounds.getMaxX() - circle.getRadius());
//                final boolean atLeftBorder = circle.getLayoutX() <= (bounds.getMinX() + circle.getRadius());
//                final boolean atBottomBorder = circle.getLayoutY() >= (bounds.getMaxY() - circle.getRadius());
//                final boolean atTopBorder = circle.getLayoutY() <= (bounds.getMinY() + circle.getRadius());
//
//                if (atRightBorder || atLeftBorder) {
//                    deltaX *= -1;
//                }
//                if (atBottomBorder || atTopBorder) {
//                    deltaY *= -1;
//                }
//
//            }
//        }));
//
//        loop.setCycleCount(Timeline.INDEFINITE);
//        loop.play();
//    }
//        public void createAllert(Circle circle, Pane GamePane, Label numberOfLive, Label levelName,Boolean run){
//        EventHandler<MouseEvent> eventHandlerPane = new EventHandler<MouseEvent>() {
//            int k = 1;
//
//            @Override
//            public void handle(MouseEvent e) {
//                System.out.println(run);
//                if(run){
//                    numberOfLive.setText(String.valueOf(qqq - k));
//
//                    k++;
//                    if (k == 11 && !level.equals("Poziom 3") ) {
//                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                        alert.setTitle("Information Dialog");
//                        alert.setHeaderText(null);
//                        alert.setContentText("Gratulacje, zakończono poziom: " + level + "!");
//                       // loop.stop();
//                        alert.showAndWait();
//                        k = 1;
//                        qqq = Integer.valueOf(ReadFileLevelSingleton.getInstance().liczbaŻyć2);
//
//                         numberOfLive.setText(String.valueOf(qqq - k));
//                        if (level.equals("Poziom 1")) {
//                            level = ReadFileLevelSingleton.getInstance().nazwaPoziomu2;
//                            levelName.setText(level);
//                            numberOfLive.setText(String.valueOf(Integer.valueOf(ReadFileLevelSingleton.getInstance().liczbaŻyć2)));
//                           moveSystem(circle, 1,GamePane);
//                        } else {
//                            level = ReadFileLevelSingleton.getInstance().nazwaPoziomu3;
//                            levelName.setText(level);
//                            numberOfLive.setText(String.valueOf(Integer.valueOf(ReadFileLevelSingleton.getInstance().liczbaŻyć3)));
//                            moveSystem(circle, ratioChange*ratioChange,GamePane);
//
//                        }
//                    }
//                    if (k == 11 && level.equals("Poziom 3") ){
//
//                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                        alert.setTitle("Information Dialog");
//                        alert.setHeaderText(null);
//                        alert.setContentText("Gratulacje, ukonczyles gre!");
//                        loop.stop();
//                        alert.showAndWait();
//                    }
//                }}
//
//        };
//
//        GamePane.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerPane);
//    }
//    public void setRatioChange(){
////        ratioChange=Double.valueOf(ReadFileSingleton.getInstance().zmianaStopniTrudnosci );
////        ratioChange=ratioChange/100;
////        ratioChange=1-ratioChange;
////
////    }
//}
