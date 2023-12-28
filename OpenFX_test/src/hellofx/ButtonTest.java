package hellofx;   

import javafx.application.Application;  
import javafx.event.ActionEvent;  
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;  
import javafx.scene.control.Button;  
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;  
public class ButtonTest extends Application{  
  
    @Override  
    public void start(Stage primaryStage) throws Exception {  
        Button btn1=new Button("Say, Hello World");
        btn1.getStyleClass().add("btn1");
        Button btn2=new Button("Say, Goodbye World");
        btn2.getStyleClass().add("btn2");
        // btn2.setRotate(0);
        Button btn3=new Button("Say, I hate World");
        btn3.getStyleClass().add("btn3");
        // btn3.setRotate(0);
        Button btn4=new Button("Say, I love World");
        btn4.getStyleClass().add("btn4");
        btn4.setPrefSize(200, 50);
        // btn4.setRotate(0);
        btn1.setOnAction(new EventHandler<ActionEvent>() {  
            @Override  
            public void handle(ActionEvent event) {  
                System.out.println("hello world");  
            }  
        });  
        btn2.setOnAction(new EventHandler<ActionEvent>() {  
            @Override  
            public void handle(ActionEvent event) {  
                System.out.println("goodbye world");  
            }  
        });  
        btn3.setOnAction(new EventHandler<ActionEvent>() {  
            @Override  
            public void handle(ActionEvent event) {  
                System.out.println(">:C ****");  
            }  
        });  
        btn4.setOnAction(new EventHandler<ActionEvent>() {  
            @Override  
            public void handle(ActionEvent event) {  
                System.out.println("0v0 <33");  
            }  
        });  

        StackPane root = new StackPane();
        HBox row1 = new HBox();
        HBox row2 = new HBox();
        VBox col1 = new VBox();
        GridPane grid = new GridPane();     
        // row1.setSpacing(2);
        // row2.setSpacing(2);
        // col1.setSpacing(2);
        // row1.getChildren().add(btn1);
        // row1.getChildren().add(btn2);
        // col1.getChildren().add(row1);
        // row2.getChildren().add(btn3);
        // row2.getChildren().add(btn4);
        // col1.getChildren().add(row2);
        // root.getChildren().add(col1);
        grid.add(btn1, 0, 0);
        grid.add(btn2, 1, 0);
        grid.add(btn3, 0, 1);
        grid.add(btn4, 1, 1);
        grid.getStyleClass().add("grid-pane");
        grid.setAlignment(Pos.CENTER);

        primaryStage.setTitle("First JavaFX Application");  
        Scene scene = new Scene(grid,600,400);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);  
        primaryStage.show();  
    }  
    public static void main (String[] args) {  
        launch(args);  
    }  
  
}