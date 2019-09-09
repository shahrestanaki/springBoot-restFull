package com.publics;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PublicServiceTest {

    public static String convertDate(Date data) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(data);
        return date;
    }

    public static String convertDate(Date data, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(data);
        return date;
    }

    public static String addCustomDate(String str, String word, Date date) {
        str = str.replace("}", ",\"" + word + "\":\"" + convertDate(date) + "\"}");
        return str;
    }

    public static String addCustomString(String str, String word, String value) {
        str = str.replace("}", ",\"trndate\":\"" + value + "\"}");
        return str;
    }

}
