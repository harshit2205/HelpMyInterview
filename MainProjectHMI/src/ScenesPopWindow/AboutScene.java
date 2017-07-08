package ScenesPopWindow;

import Utils.FormattedText;
import com.sun.javafx.font.freetype.HBGlyphLayout;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import javax.swing.*;


/**
 * Created by staLker on 01-07-2017.
 */
public class AboutScene {
    public static Scene getScene(){

        ImageView logoImage = new ImageView(new Image("/ImageResource/logo.png"));
        logoImage.setFitHeight(120);
        logoImage.setFitWidth(215);
        HBox hBoxForLogo = new HBox();//-->
        hBoxForLogo.getChildren().add(logoImage);

        FormattedText nameOfApplicationText = new FormattedText("Help My Interview");
        nameOfApplicationText.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD,25));
        FormattedText copyRightDetailText = new FormattedText("version 1.0.12\n\n\nCopyright 2017 DCODE Inc.\nAll right reserved.");
        copyRightDetailText.setTextAlignment(TextAlignment.CENTER);

        VBox vBox = new VBox();
//
        vBox.getChildren().addAll(logoImage,nameOfApplicationText,copyRightDetailText);
        vBox.setAlignment(Pos.CENTER);


        HBox hBoxroot = new HBox();
        hBoxroot.getChildren().add(vBox);
        hBoxroot.setAlignment(Pos.CENTER);



        Scene scene = new Scene(hBoxroot,400,350);
        return scene;
    }
}
