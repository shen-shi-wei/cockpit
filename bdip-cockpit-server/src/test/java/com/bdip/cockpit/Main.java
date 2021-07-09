package com.bdip.cockpit;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ssw
 * @Date: 2021/07/09/13:29
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("getDate(0) = " + getDate(0));
        System.out.println("getDate(0) = " + getDate(1));
        System.out.println("getDate(0) = " + getDate(2));
        System.out.println("getDate(0) = " + getDate(3));
        System.out.println("getDate(0) = " + getDate(4));
    }
    private static String getDate(int num) {
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-num);
        Date d=cal.getTime();
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
        return sp.format(d);
    }
}
