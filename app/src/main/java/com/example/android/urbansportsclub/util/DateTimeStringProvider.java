package com.example.android.urbansportsclub.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Anon on 07.11.17.
 */

public class DateTimeStringProvider {
    public static String getDateTimeString() {

        SimpleDateFormat df = new SimpleDateFormat("dd. MMMM yyyy K:mm");
        SimpleDateFormat ampm = new SimpleDateFormat("a");
        Date date = new Date();
        String dateTimeString = df.format(date);
        String ampmString = ampm.format(date);
        if(ampmString.equals("AM")) {
            dateTimeString += " vorm.";
        } else {
            dateTimeString += " nachm.";
        }
        return dateTimeString;
    }
}
