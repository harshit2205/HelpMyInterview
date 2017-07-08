package Stages;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by staLker on 02-07-2017.
 */
public class ConfirmationDialog {
    private boolean isConfirmed = false;

    public boolean confirmationUtility(String title, String message){

        Stage window = new Stage();
        window.setTitle(title);

        VBox box = new VBox(10);
        box.setPadding(new Insets(10,10,10,10));

        Label messageLabel = new Label(message);


        HBox hBox = new HBox(20);
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");
        yesButton.setOnAction(e -> {
            isConfirmed = true;
            window.close();
        });
        noButton.setOnAction(e -> {
            isConfirmed = false;
            window.close();
        });
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(yesButton,noButton);
        box.setAlignment(Pos.CENTER);
        box.getChildren().addAll(messageLabel,hBox);

        Scene scene = new Scene(box , 350 ,100);
        scene.getStylesheets().add("Themes/Nevike.css");
        window.setScene(scene);
        window.showAndWait();
        return isConfirmed;
    }
}
