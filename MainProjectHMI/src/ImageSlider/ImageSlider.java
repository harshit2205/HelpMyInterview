package ImageSlider;

/**
 * Created by staLker on 30-06-2017.
 */
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ImageSlider {

    private static List<String> list = new ArrayList<String>();
    static int j = 0;
    static double orgCliskSceneX;
    static double orgReleaseSceneX;
    static Button lbutton;
    static Button rButton;
    static ImageView imageView;
    static Image[] images;
    static Thread thread = null;


    public static HBox getLayout() {
        // images in src folder.
        try {

            list.add("/ImageSlider/3.jpg");
            list.add("/ImageSlider/4.jpg");
            list.add("/ImageSlider/5.jpg");




            GridPane gridPane = new GridPane();

            gridPane.setAlignment(Pos.CENTER);

            lbutton = new Button("<");
            rButton = new Button(">");
            lbutton.getStyleClass().add("button-round");
            rButton.getStyleClass().add("button-round");

            images = new Image[list.size()];
            for (int i = 0; i < list.size(); i++) {
                images[i] = new Image(list.get(i));
            }

            imageView = new ImageView(images[j]);
            imageView.setCursor(Cursor.CLOSED_HAND);

            imageView.setOnMousePressed(circleOnMousePressedEventHandler);

            imageView.setOnMouseReleased(e -> {
                orgReleaseSceneX = e.getSceneX();
                if (orgCliskSceneX > orgReleaseSceneX) {
                    lbutton.fire();
                } else {
                    rButton.fire();
                }
            });

            rButton.setOnAction(e -> {
                j = j + 1;
                if (j == list.size()) {
                    j = 0;
                }
                imageView.setImage(images[j]);

            });
            lbutton.setOnAction(e -> {
                j = j - 1;
                if ( j > list.size() + 1 || j == -1) {
                    j = list.size() - 1;
                }
                imageView.setImage(images[j]);

            });

            if(isImageSliderThreadRunning()){
                //slideImages();
            }

            imageView.setFitHeight(300);
            imageView.setFitWidth(535);

            HBox hBox = new HBox();
            hBox.setSpacing(4);
            hBox.setAlignment(Pos.CENTER);
            // hBox.getChildren().addAll(lbutton, imageView, rButton);
            hBox.getChildren().addAll(lbutton,imageView,rButton);//----->uncomment to add buttons.
            //hBox.getChildren().add(imageView);
            //hBox.setStyle("-fx-background-color: #fded02");
            return hBox;

//            gridPane.add(hBox, 1, 1);
//            Scene scene = new Scene(gridPane, 800, 400);
//            return scene;
//            primaryStage.setScene(scene);
//            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static EventHandler<MouseEvent> circleOnMousePressedEventHandler = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent t) {
            orgCliskSceneX = t.getSceneX();
        }
    };


    private static boolean isImageSliderThreadRunning(){
        if(thread == null) {
            return true;
        }else{
            return false;
        }
    }

//    private static void slideImages(){
//        thread = new Thread(() -> {
//            while(true){
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                if((j + 1) == list.size()){
//                    j = 0;
//                }else j = j + 1;
//                imageView.setImage(images[j]);
//            }
//        });
//        thread.start();
//    }
}
