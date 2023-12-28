package calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Button btn[] = new Button[12];
        for (int i=0; i<=10; i++) {
            btn[i] = new Button(Integer.toString(i));
            btn[i].getStyleClass().add("number-btn");
        }
        btn[10].setText(".");

        GridPane grid = new GridPane();
        grid.add(btn[0], 0, 4);
        grid.add(btn[1], 0, 3);
        grid.add(btn[4], 0, 2);
        grid.add(btn[7], 0, 1);
        grid.add(btn[2], 1, 3);
        grid.add(btn[5], 1, 2);
        grid.add(btn[8], 1, 1);
        grid.add(btn[3], 2, 3);
        grid.add(btn[6], 2, 2);
        grid.add(btn[9], 2, 1);
        grid.add(btn[10], 1, 4);

        primaryStage.setTitle("Calculator");
        Scene scene = new Scene(grid, 400, 600);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }   
}