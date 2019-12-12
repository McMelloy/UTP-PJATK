package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    public  BufferedReader t;
    @FXML public Text time;
    @FXML public TextField x;
    public static String size;



    public void initialize() {
        setTime();
    }


    public void exitGame() {
        System.exit(0);
    }

    public void setTime() {
        try {
            t = new BufferedReader(new FileReader("/Users/alice/IdeaProjects/Puzzle/src/sample/time.txt"));
            time.setText(t.readLine());
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch ( IOException e) {
            System.out.println(e);
        }
    }


    public static void changeToGame(ActionEvent click, Parent puzzle) {
        Scene puzzleView = new Scene(puzzle);
        Stage game = (Stage)((Node)click.getSource()).getScene().getWindow();
        game.setMaximized(true);
        game.setScene(puzzleView);
        game.show();


    }

    @FXML
    public void loadNewFxml(ActionEvent click) throws IOException {

        Pattern digits = Pattern.compile("^[0-9]+$");
        Matcher mX = digits.matcher(x.getText());
        boolean isDigitX = mX.matches();

        if(x.getText().isEmpty()){
            errorWindow("Please,specify size");
        } else if(!isDigitX) {
            errorWindow("Please, enter digit");
            x.clear();
        } else if(Integer.parseInt(x.getText())<3) {
            errorWindow("Size should be more than 3");
        } else {
            size = x.getText();
            Controller.changeToGame(click, FXMLLoader.load(getClass().getResource("view/Game.fxml")));
        }

    }

    public void errorWindow(String errorMessage){
        Label errorLable = new Label(errorMessage);

        StackPane errorPane = new StackPane();
        errorPane.getChildren().add(errorLable);

        Scene errorScene = new Scene(errorPane, 230, 100);

        Stage errorWindow = new Stage();
        errorWindow.setTitle("Error");
        errorWindow.setScene(errorScene);

        errorWindow.setX(Main.stage.getX() + 200);
        errorWindow.setY(Main.stage.getY() + 100);

        errorWindow.show();
    }

    public String getSize(){
        return x.getText();
    }


}
