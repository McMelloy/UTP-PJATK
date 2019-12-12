package sample;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
public class Controller {

    @FXML
    private Label result;

    @FXML
    private TextField values;

    @FXML
    private void onButtonClick() {
        String[] num = values.getText().replaceAll("\\s+","").split("\\+");
        //double[] numbers = new double[num.length];   // The valid place for loop
        int sum =0;
        for (int i = 0; i < num.length; ++i)
        {
            //numbers[i] = Double.valueOf(num[i]);
            sum += Double.parseDouble(num[i]);
        }
            result.setText(String.valueOf(sum));



    }

}
