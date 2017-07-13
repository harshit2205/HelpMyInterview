package Beans.Utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Created by staLker on 07-07-2017.
 */
public class DOB {
    private int date;
    private int month;
    private int year;


    public DOB() {
        //empty constructor was made intentionally
    }

    public DOB(int date, int month, int year) {
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public static ObservableList<Integer> getAllDateList(){
        ArrayList<Integer> allDate = new ArrayList<>();
        for (int i=1;i<=31;i++){
            allDate.add(i);
        }
        return FXCollections.observableList(allDate);
    }
    public static ObservableList<Integer> getAllMonthList(){
        ObservableList<Integer> allMonth = FXCollections.observableArrayList();

       for(int i=1 ; i<=12; i++){
           allMonth.add(i);
       }
        return allMonth;
    }
    public static ObservableList<Integer> getAllYears(){
        ArrayList<Integer> allYear = new ArrayList<>();
        for (int i=2017;i>=1950;i--){
            allYear.add(i);
        }
        return FXCollections.observableList(allYear);
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
