package putbutton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;

public class ControllerButT {
    @FXML
    private Button btt;

    @FXML
    private void onButtonClick() {
        btt.setText("Clicked");
    }
}
