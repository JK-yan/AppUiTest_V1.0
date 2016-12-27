package Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by jackiezero on 2016/12/26.
 */
public class TimeUtils {

    public String GetLocalTime(){
        String timeformat="yyyy/MM/dd HH:mm:ss";
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(timeformat);
        String hehe = dateFormat.format(now);
        System.out.println(hehe);
        System.out.println(dateFormat);
        return hehe;
    }

public String GetLocalTime(String timeformat){
//        String timeformat="yyyy/MM/dd HH:mm:ss";
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(timeformat);
        String hehe = dateFormat.format(now);
        System.out.println(hehe);
        System.out.println(dateFormat);
        return hehe;
    }
    public static void  GetTime(){
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int date = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        System.out.println(year + "/" + month + "/" + date + " " +hour + ":" +minute + ":" + second);
    }
}
