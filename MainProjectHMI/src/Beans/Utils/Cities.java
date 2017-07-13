package Beans.Utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Created by staLker on 03-07-2017.
 */
public class Cities {
    public static ObservableList<String> getAllCities(){
        ArrayList<String> cities = new ArrayList<>();
        ObservableList<String> observableList = FXCollections.observableList(cities);
        cities.add("New-Delhi");
        cities.add("Kanpur");
        cities.add("Ghaziabad");
        cities.add("Bengaluru");
        cities.add("Kolkata");
        cities.add("Varanasi");
        return observableList;

    }
}
