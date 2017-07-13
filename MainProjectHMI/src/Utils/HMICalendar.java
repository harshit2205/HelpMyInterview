package Utils;

import java.sql.Date;
import java.util.Calendar;


public class HMICalendar {

    private static HMICalendar hmiCalendar;

    Calendar calendar;

    private void HMICalander(){

    }

    public static HMICalendar getCalendarInstance(){
        if(hmiCalendar == null){
            hmiCalendar = new HMICalendar();
        }
        return hmiCalendar;
    }

    public int[] getDate(Date date){

        calendar = Calendar.getInstance();
        calendar.setTime(date);
        int[] dob=new int[3];
        dob[0] = calendar.get(Calendar.DATE);
        dob[1] = calendar.get(Calendar.MONTH);
        dob[2] = calendar.get(Calendar.YEAR);
        return dob;
    }
}
