package Controller.ImageSlider;

/**
 * Created by staLker on 30-06-2017.
 */
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class ImageSlider {

    private static List<String> list = new ArrayList<String>();
    static int j = 0;
    static double orgCliskSceneX;
    static double orgReleaseSceneX;
    static Button lbutton;
    static Button rButton;
    static ImageView imageView;
    static Image[] images;


    public static HBox getLayout() {
        // images in src folder.
//        new Thread() {
//            public void run() {
//                Platform.runLater(() -> {
//                    for (int i = 0; i < images.length; i++) {
//                        imageView.setImage(images[i]);
//                        try {
//                            sleep(2000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        if (i == images.length - 1) {
//                            i = 0;
//                        }
//                    }
//                });
//
//            }
//        }.start();

        try {

            list.add("/Controller/ImageSlider/3.png");
            list.add("/Controller/ImageSlider/4.png");
            list.add("/Controller/ImageSlider/5.png");


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

            imageView = new ImageView(images[0]);
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
                if (j > list.size() + 1 || j == -1) {
                    j = list.size() - 1;
                }
                imageView.setImage(images[j]);

            });


//--------------------------------------------------------------------------


            imageView.setFitHeight(300);
            imageView.setFitWidth(535);

            HBox hBox = new HBox();
            hBox.setSpacing(4);
            hBox.setAlignment(Pos.CENTER);
            // hBox.getChildren().addAll(lbutton, imageView, rButton);
            hBox.getChildren().addAll(lbutton, imageView, rButton);//----->uncomment to add buttons.
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





}
