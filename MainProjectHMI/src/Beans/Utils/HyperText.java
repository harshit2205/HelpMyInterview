package Beans.Utils;

import java.awt.*;
import java.net.URL;

public class HyperText {
    public static void openWebPage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
