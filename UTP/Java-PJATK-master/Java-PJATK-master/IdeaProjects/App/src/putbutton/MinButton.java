package putbutton;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Random;

public class MinButton extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox scr = new VBox();
        Button[] arr = new Button[1000];
        for(int i = 0; i < 1000; i++){
            arr[i] = new Button("Butt");
            scr.getChildren().add(arr[i]);

        }
        for (Button b: arr){
            b.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (b.getStyle().equals("-fx-background-color: lightblue")){
                        b.setStyle("-fx-background-color: orangered");
                    }else {
                        b.setStyle("-fx-background-color: lightblue");
                    }
                }
            });
        }
        ScrollPane spane = new ScrollPane(scr);
        primaryStage.setTitle("Putting Buttons");
        Scene scene = new Scene(spane, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

