package Beans.Utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Created by staLker on 03-07-2017.
 */
public class States {
    public static ObservableList<String> getAllStates(){
        ArrayList<String> states = new ArrayList<>();
        ObservableList<String> observableList = FXCollections.observableList(states);
        states.add("Uttar-Pradesh");
        states.add("Madhya-Pradesh");
        states.add("Delhi");
        states.add("Maharastra");
        states.add("West-Bengal");
        states.add("Tamil-Nadu");
        return  observableList;
    }
}
