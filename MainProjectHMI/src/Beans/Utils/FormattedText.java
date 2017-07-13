package Beans.Utils;

import javafx.scene.paint.Paint;
import javafx.scene.text.Text;


public class FormattedText extends Text {
    public FormattedText(String s){
        setText(s);
        setFill(Paint.valueOf("#ffffff"));
    }
}
