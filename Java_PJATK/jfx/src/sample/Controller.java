package sample;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;

import java.awt.event.KeyEvent;


public class Controller {

    @FXML
    private javafx.scene.control.ListView<String> left;
    @FXML
    private javafx.scene.control.ListView<String> right;


    @FXML
    private javafx.scene.control.TextArea lefttext;
    @FXML
    private javafx.scene.control.TextArea righttext;

    @FXML
    public void AliceSays(){
        String text = lefttext.getText();
        left.getItems().addAll("Alice says : "+text);
        right.getItems().addAll("Alice says : "+text);
        lefttext.setText("");

    }

    @FXML
    public void BobSays(){
        String text = righttext.getText();
        left.getItems().addAll("Bob says : "+text);
        right.getItems().addAll("Bob says : "+text);
        righttext.setText("");
    }

    @FXML
    void initialize() {
        lefttext.setOnKeyReleased(e -> {
            if(e.getCode()== KeyCode.ENTER){
                AliceSays();
            }
            if(e.getCode()==KeyCode.ESCAPE){
                lefttext.setText("");
            }
        });

        righttext.setOnKeyReleased(e -> {
            if(e.getCode()== KeyCode.ENTER){
                BobSays();
            }

            if(e.getCode()==KeyCode.ESCAPE){
                righttext.setText("");
            }
        });

    }
}
