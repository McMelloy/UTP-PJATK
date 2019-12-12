package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage stage) throws Exception {
        // We are loading a soruce file which represents our window
        Parent root = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));

        // Let's say that Scene is similar to JFrame in Swing
        // Scene in JavaFX is responsible for contents
        // We pass contents (root), width (450) and height (275)
        Scene scene = new Scene(root, 450, 275);

        // Setting a title for a main window
        stage.setTitle("Logowanie do PJATK");
        // Setting a scene for a main window
        stage.setScene(scene);
        // When everything is done, we can show our window to a user
        stage.show();
    }

}