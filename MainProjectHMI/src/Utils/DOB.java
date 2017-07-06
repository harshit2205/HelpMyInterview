package Utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by staLker on 07-07-2017.
 */
public class DOB {
    private String date;
    private String month;
    private String year;


    public DOB() {
        //empty constructor was made intentionally
    }

    public DOB(String date, String month, String year) {
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public static ObservableList<String> getAllDateList(){
        ArrayList<String> allDate = new ArrayList<>();
        for (int i=1;i<=31;i++){
            allDate.add(i+"");
        }
        return FXCollections.observableList(allDate);
    }
    public static ObservableList<String> getAllMonthList(){
        ArrayList<String> allMonth = new ArrayList<>();
        allMonth.add("Jan");
        allMonth.add("Feb");
        allMonth.add("Mar");
        allMonth.add("Apr");
        allMonth.add("May");
        allMonth.add("Jun");
        allMonth.add("Jul");
        allMonth.add("Aug");
        allMonth.add("Sept");
        allMonth.add("Oct");
        allMonth.add("Nov");
        allMonth.add("Dec");
        return FXCollections.observableList(allMonth);
    }
    public static ObservableList<String> getAllYears(){
        ArrayList<String> allYear = new ArrayList<>();
        for (int i=2017;i>=1950;i--){
            allYear.add(i+"");
        }
        return FXCollections.observableList(allYear);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
