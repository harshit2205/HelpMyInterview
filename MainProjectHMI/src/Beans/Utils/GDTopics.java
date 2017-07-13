package Beans.Utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by staLker on 08-07-2017.
 */
public class GDTopics {
    //function to fetch list of topics........................
    public static ObservableList<String> fetchList() {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll(
                "What is the major cause of intense civil agitation in Kashmir?",
                "How escalating pollution rate in India can be controlled?",
                "Live in relations are increasing in India. What is the cause behind it?",
                "The performance of India in sports has gone down. What can be a possible cause of it?",
                "What can bring more development in India?",
                "How criminalization can be checked in India?",
                "Which plays crucial role in maintaining democracy in India?",
                "Draught situations have effected which field of India?",
                "What must be done to improve the education system of India?",
                "Many bulk data websites have been banned by telecom authorities."
        );
        return list;

        //can also be used to fetch list from management
    }
}
