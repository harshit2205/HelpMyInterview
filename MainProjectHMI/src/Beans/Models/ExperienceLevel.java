package Beans.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Created by staLker on 09-07-2017.
 */
public class ExperienceLevel {
    public static ObservableList<String> getAllLevels(){
        ArrayList<String> levels = new ArrayList<>();
        ObservableList<String> observableList = FXCollections.observableList(levels);
        levels.add("Beginner");
        levels.add("Intermediate");
        levels.add("Advanced");
        return  observableList;
    }
}
