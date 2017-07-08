package Utils;

import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

/**
 * Created by USER on 7/9/2017.
 */
public class FormattedText extends Text {
    public FormattedText(String s){
        setText(s);
        setFill(Paint.valueOf("#ffffff"));
    }

    public FormattedText(){}
}
