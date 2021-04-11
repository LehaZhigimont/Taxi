package Date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDate {
    private Date date;
    private SimpleDateFormat dateFormat;

    public String CurrentDateDMYHHMMSS (){
        date = new Date();
        dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return dateFormat.format(date);
    }




    public int CurrentDate(){
        date = new Date();
        dateFormat = new SimpleDateFormat("dd");
        return Integer.parseInt(dateFormat.format(date));
    }

    public int CurrentMonth(){
        date = new Date();
        dateFormat = new SimpleDateFormat("MM");
        return Integer.parseInt(dateFormat.format(date));
    }

    public int CurrentYear(){
        date = new Date();
        dateFormat = new SimpleDateFormat("yy");
        return Integer.parseInt(dateFormat.format(date));
    }

    public int CurrentHours(){
        date = new Date();
        dateFormat = new SimpleDateFormat("HH");
        return Integer.parseInt(dateFormat.format(date));
    }

    public int CurrentMinutes(){
        date = new Date();
        dateFormat = new SimpleDateFormat("mm");
        return Integer.parseInt(dateFormat.format(date));
    }
    public int CurrentSeconds(){
        date = new Date();
        dateFormat = new SimpleDateFormat("ss");
        return Integer.parseInt(dateFormat.format(date));
    }
}
