package cn.com.huangdc.utils;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {
    @Test
    public void testSimpleDateFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
        System.out.println(sdf.format(new Date()));
    }

    /**
     * set(int)
     */
    @Test
    public void testCalendar() {
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);

        c.add(Calendar.DAY_OF_MONTH, 10);
        System.out.println(c.getTime());

        c.set(Calendar.DAY_OF_MONTH, 11);
        System.out.println(c.getTime());
    }
}
