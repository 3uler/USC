package com.example.android.urbansportsclub.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Anon on 07.11.17.
 */

public class DateTimeStringProvider {
    public String getDateTimeString() {
        Date date = new Date();
        return getDateTimeStringFromDate(date);
    }

    public String getDateTimeStringFromDate(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("dd. MMMM yyyy h:mm");
        SimpleDateFormat ampm = new SimpleDateFormat("a");
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
