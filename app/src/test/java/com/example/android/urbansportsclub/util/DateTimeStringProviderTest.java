package com.example.android.urbansportsclub.util;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateTimeStringProviderTest {
    @Test
    public void test1_00pm1stDecember2018() {
        // init
        LocalDateTime dateTime = LocalDateTime.of(2018, 12, 1, 13, 0);
        Date date = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
        DateTimeStringProvider dateTimeStringProvider = new DateTimeStringProvider();
        // run
        String dateTimeStringFromDate = dateTimeStringProvider.getDateTimeStringFromDate(date);
        //assert
        Assert.assertEquals("DateTime String muss lauten: 01. Dezember 2018 1:00 nachm.", "01. Dezember 2018 1:00 nachm.", dateTimeStringFromDate);
    }

    @Test
    public void test12_00am1stDecember2018() {
        // init
        LocalDateTime dateTime = LocalDateTime.of(2018, 12, 1, 0, 0);
        Date date = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
        DateTimeStringProvider dateTimeStringProvider = new DateTimeStringProvider();
        // run
        String dateTimeStringFromDate = dateTimeStringProvider.getDateTimeStringFromDate(date);
        //assert
        Assert.assertEquals("DateTime String muss lauten: 01. Dezember 2018 12:00 vorm.", "01. Dezember 2018 12:00 vorm.", dateTimeStringFromDate);
    }

    @Test
    public void test12_00pm1stDecember2018() {
        // init
        LocalDateTime dateTime = LocalDateTime.of(2018, 12, 1, 12, 0);
        Date date = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
        DateTimeStringProvider dateTimeStringProvider = new DateTimeStringProvider();
        // run
        String dateTimeStringFromDate = dateTimeStringProvider.getDateTimeStringFromDate(date);
        //assert
        Assert.assertEquals("DateTime String muss lauten: 01. Dezember 2018 12:00 nachm.", "01. Dezember 2018 12:00 nachm.", dateTimeStringFromDate);
    }
}