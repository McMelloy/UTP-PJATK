package password;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MainController {

    @FXML private VBox listOfElements;
    @FXML private TextField textField;

    @FXML
    // When it is created
    private void initialize() {

    }

    public void addElement(){
        try{
            createChildElement();
        }catch (UsernameAlreadyExistsException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(textField.getText() + " is taken");
            alert.setContentText("Choose different username!");

            alert.showAndWait();
        }

    }

    // Here we are creating one component
    private void createChildElement() throws UsernameAlreadyExistsException {
        // Load a view
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Cell.fxml"));
        // Define a value to pass
        // Creat a controller on your own
        Cell controller = new Cell(textField.getText());
        // Set a controller for a view
        loader.setController(controller);
        Pane pane = null;
        try {
            // Load a view
            pane = loader.load();
            // Add view to a component
            listOfElements.getChildren().add(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}                