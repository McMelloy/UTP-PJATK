package z13;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;

import java.awt.event.KeyEvent;


public class Main {

    private String leftName = "Pasha";
    private String rightName = "Masha";
    @FXML
    private javafx.scene.control.ListView<String> left;
    @FXML
    private javafx.scene.control.ListView<String>  right;


    @FXML
    private javafx.scene.control.TextArea lefttext;
    @FXML
    private javafx.scene.control.TextArea righttext;

    @FXML
    public  void sendleft(){
        String text = lefttext.getText();
        left.getItems().addAll(leftName+ " : "+text);
        right.getItems().addAll(leftName+ " : "+text);
        lefttext.setText(null);

    }

    @FXML
    public  void sendright(){
        String text = righttext.getText();
        left.getItems().addAll(rightName+ " : "+text);
        right.getItems().addAll(rightName+ " : "+text);
        righttext.setText(null);
    }

    @FXML
    void initialize() {
        lefttext.setOnKeyReleased(e -> {
            if(e.getCode()== KeyCode.ENTER){
                sendleft();
            }
            if(e.getCode()==KeyCode.ESCAPE){
                lefttext.setText(null);
            }
        });

        righttext.setOnKeyReleased(e -> {
            if(e.getCode()== KeyCode.ENTER){
                sendright();
            }

            if(e.getCode()==KeyCode.ESCAPE){
                righttext.setText(null);
            }
        });

    }
}
