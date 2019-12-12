package password;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class Cell {

    private static List<String> listOfUsernames = new ArrayList<>();

    private String username;
    private String password;


    public Cell(String username) throws UsernameAlreadyExistsException {
        if(listOfUsernames.contains(username)){
            throw new UsernameAlreadyExistsException("Username " + username + " already exists.");
        }
        this.username = username;
        this.password = generateRandomPassword();

        listOfUsernames.add(username);
    }

    private String generateRandomPassword(){
        String result = "";

        int length = (int)(Math.random() * 10 + 5);

        for(int i = 0; i < length; i++){
            result  += (char)(Math.random() * ('z' - 'a' + 1) + 'a');
        }

        return result;
    }

    @FXML private Text text;
    @FXML private Button btn;

    @FXML
    public void initialize(){
        text.setText(username);
        btn.setText("Show");
    }

    @FXML
    public void show() {
        if(text.getText().equals(username)) {
            text.setText(password + "");
            btn.setText("Hide");
        }else {
            text.setText(username + "");
            btn.setText("Show");
        }
    }
}