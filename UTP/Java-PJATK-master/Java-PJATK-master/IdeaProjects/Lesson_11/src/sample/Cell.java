package sample;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class Cell {

    private int value;

    public Cell(int value) {
        this.value = value;
    }

    @FXML
    private Text text;

    @FXML
    public void show() {
        text.setText(value + "");
    }

}

