package sample;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class MainController {

    @FXML
    private Text mainText;

    @FXML
    private void onButtonClick() {
        if(mainText.getText().equals("World!")){
            mainText.setText("Hello!");
        } else {
            mainText.setText("World!");
        }

    }

}