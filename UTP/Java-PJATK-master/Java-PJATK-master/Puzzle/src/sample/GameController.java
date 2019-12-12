package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GameController {
    @FXML
    Text timer;
    @FXML
    AnchorPane anchor;
    @FXML
    AnchorPane an;

    int empty;
    boolean finish = true;

    int size = Integer.parseInt(Controller.size);

    GridPane gameGrid;
    Button emp;
    FileWriter writer;


    public Button[][] images;

    public Button[][] mixed;

    public void initialize() {
        createGrid();
        Timer t = new Timer();
        t.start();
        addToGrid(mixImage(cropImage()));
        addGridEvent();

    }

    public static void backToMenu(ActionEvent click, Parent menu) {
        Scene menuView = new Scene(menu);
        Stage game = (Stage) ((Node) click.getSource()).getScene().getWindow();
        game.setScene(menuView);
        game.show();
    }

    @FXML
    public void loadNewFxml(ActionEvent click) throws IOException {
        GameController.backToMenu(click, FXMLLoader.load(getClass().getResource("view/Menu.fxml")));
    }

    public Button[][] cropImage() {
        images = new Button[size][size];
        BufferedImage image = null;

        try {
            image = ImageIO.read(new File("/Users/alice/IdeaProjects/Puzzle/src/sample/view/05L8rjznMs51jPtLe-QmhTCjS867ufqrZQ_Z4VEsbQA.jpg"));
        } catch (IOException e) {
            System.out.println(e);
        }

        int row = size;
        int col = size;
        int width = image.getWidth();
        int height = image.getHeight();
        int pieceWidth = width / col;
        int pieceHeight = height / row;
        int x = 0;
        int y = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                try {

                    BufferedImage piece = image.getSubimage(y, x, pieceWidth, pieceHeight);
                    Image pieceImage = SwingFXUtils.toFXImage(piece, null);


                    if(j == images.length - 1 && i == images.length - 1){
                        emp = new Button();
                        emp.setVisible(false);
                        images[j][i] = emp;
                    } else {
                        Button b = new Button();
                        b.setGraphic(new ImageView(pieceImage));
                        images[j][i] = b;
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
                y += pieceWidth;
            }
            y = 0;
            x += pieceHeight;
        }
        System.out.println(Arrays.deepToString(images));
        System.out.println();
        return images;
    }

    public class Timer extends Thread {
        @Override
        public void run() {
            long start = System.currentTimeMillis();
            long currTime;
            String time;
            while (finish) {
                currTime = System.currentTimeMillis() - start;

                time = String.format("%02d:%02d",
                        TimeUnit.MILLISECONDS.toMinutes(currTime) -
                                TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(currTime)),
                        TimeUnit.MILLISECONDS.toSeconds(currTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(currTime)));
                timer.setText(time);

                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }

    public Button[][] mixImage(Button[][] arr) {
        Random rand = new Random();

        mixed = new Button[size][size];
        for(int i = 0; i < arr.length; i++ ) {
            for (int j =0; j < arr[0].length; j++) {
                mixed[i][j] = arr[i][j];
            }
        }

        for (int i = mixed.length - 1; i > 0; i--) {
            for (int j = mixed[i].length - 1; j > 0; j--) {

                    int m = rand.nextInt(i + 1);
                    int n = rand.nextInt(j + 1);

                    Button temp = mixed[i][j];
                    mixed[i][j] = mixed[m][n];
                    mixed[m][n] = temp;


            }
        }
        return mixed;
    }

    public void createGrid() {
        gameGrid = new GridPane();
        gameGrid.setGridLinesVisible(true);
        gameGrid.setAlignment(Pos.CENTER);
        an.getChildren().add(gameGrid);
    }

    public void addToGrid(Button[][] arr) {
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr[0].length; i++) {
                gameGrid.add(arr[j][i], j, i);
            }
        }
    }

    private void addGridEvent() {

        gameGrid.getChildren().forEach(item -> {
            item.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    int selectedIdx = gameGrid.getChildren().indexOf(item);

                    empty = gameGrid.getChildren().indexOf(emp);

                    int column1 = GridPane.getColumnIndex(gameGrid.getChildren().get(empty));
                    int row1 = GridPane.getRowIndex(gameGrid.getChildren().get(empty));

                    int column2 = GridPane.getColumnIndex(gameGrid.getChildren().get(selectedIdx));
                    int row2 = GridPane.getRowIndex(gameGrid.getChildren().get(selectedIdx));

                    Button tmp = mixed[column1][row1];

                    mixed[column1][row1] = mixed[column2][row2];
                    mixed[column2][row2] = tmp;

                    Button temp = mixed[row1][column1];
                    //Collections.swap(Arrays.asList(mixed),);
                    mixed[row1][column1] = mixed[row2][column2];
                    mixed[row2][column2] = temp;

                    if((column1 == column2 && row1 == row2+1)
                            || (column1 == column2 && row1 == row2-1)
                            || (column1 == column2+1 && row1 == row2)
                            ||(column1 == column2-1 && row1 == row2)) {
                    gameGrid.getChildren().remove(item);
                    gameGrid.getChildren().remove(emp);

                    gameGrid.add(item, column1, row1);
                    gameGrid.add(emp, column2, row2);


                    }


                    if (arrayComp(mixed, images)){
                        finish = false;
                    }

                    if(!finish) {
                        endOfGameMessege("Congratulations!");
                        writeTimeToFile();
                    }


                }
            });
        });
    }

    public boolean arrayComp(Button [] [] arr,Button [] [] brr) {
        for (int x = 0; x < arr.length; x ++){
            for (int p = 0; p < arr[0].length; p++){
                if (!(arr[x][p].equals(brr[x][p]))){
                    return false;
                }
            }
        }
        return true;
    }


    public void endOfGameMessege(String win) {
        Label errorLable = new Label(win);

        StackPane errorPane = new StackPane();
        errorPane.getChildren().add(errorLable);

        Scene errorScene = new Scene(errorPane, 500, 500);

        Stage endOfGameWindow = new Stage();
        endOfGameWindow.setTitle("End");
        endOfGameWindow.setScene(errorScene);
        endOfGameWindow.setX(Main.stage.getX() + 200);
        endOfGameWindow.setY(Main.stage.getY() + 100);
        endOfGameWindow.show();
    }

    public void writeTimeToFile() {
        try {
            writer = new FileWriter("/Users/alice/IdeaProjects/Puzzle/src/sample/time.txt");
            writer.write(timer.getText());
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}