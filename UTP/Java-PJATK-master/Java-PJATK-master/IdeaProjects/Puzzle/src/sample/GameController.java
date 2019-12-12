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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GameController {
    @FXML
    Text timer;
    @FXML
    AnchorPane anchor;
    @FXML AnchorPane an;




    int size = Integer.parseInt(Controller.size);

    GridPane test;


    public static Button[][] images;

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
                    Button b = new Button();
                    b.setGraphic(new ImageView(pieceImage));
                    images[j][i] = b;

                } catch (Exception e) {
                    e.printStackTrace();
                }
                y += pieceWidth;
            }
            y = 0;
            x += pieceHeight;
        }
        return images;
    }

    public class Timer extends Thread {
        @Override
        public void run() {
            long start = System.currentTimeMillis();
            long currTime;
            String time;
            while (true) {
                currTime = System.currentTimeMillis() - start;

                time = String.format("%02d:%02d",
                        TimeUnit.MILLISECONDS.toMinutes(currTime) -
                                TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(currTime)),
                        TimeUnit.MILLISECONDS.toSeconds(currTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(currTime)));
                timer.setText(time);

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }

    public Button [][] mixImage(Button[][] arr) {
            Random rand = new Random();

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = arr[i].length - 1; j > 0; j--) {
                int m = rand.nextInt(i + 1);
                int n = rand.nextInt(j + 1);

                Button temp = arr[i][j];
                arr[i][j] = arr[m][n];
                arr[m][n] = temp;
            }
        }
            return arr;
    }

   public void createGrid() {
        test = new GridPane();
        test.setGridLinesVisible(true);
        test.setAlignment(Pos.CENTER);
        an.getChildren().add(test);
   }

   public void addToGrid(Button [][] arr) {
       for(int j = 0; j < arr.length; j++) {
           for(int i = 0; i < arr[0].length; i++) {
               if(j==arr.length - 1 && i == arr.length - 1){
                   Button b = new Button(); // change
                   test.add(b, j ,i);
               } else {
                   test.add(arr[j][i], j ,i);
               }
           }
       }
   }

    private void addGridEvent() {

        test.getChildren().forEach(item -> {
            item.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    //Button b = test.getChildren(item);
                    Object selectedNode = event.getSource();
                    int selectedIdx  = test.getChildren().indexOf(selectedNode);
                    // Button n = (Button)test.getChildren().get(selectedIdx);
                    test.getChildren().remove(item);
                    test.add(item,2,2);
                }
            });
        });
    }
}