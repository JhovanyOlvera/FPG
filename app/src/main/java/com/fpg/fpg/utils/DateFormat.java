package com.fpg.fpg.utils;

import com.fpg.fpg.models.DateNews;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * Created by Jhovany Olvera on 27/06/2017.
 */

public class DateFormat {

    public static String Format(DateNews dateNews) {

        HashMap<String, Integer> hmMonth = new HashMap<>();
        hmMonth.put("ENERO", 1);
        hmMonth.put("FEBRERO", 2);
        hmMonth.put("MARZO", 3);
        hmMonth.put("ABRIL", 4);
        hmMonth.put("MAYO", 5);
        hmMonth.put("JUNIO", 6);
        hmMonth.put("JULIO", 7);
        hmMonth.put("AGOSTO", 8);
        hmMonth.put("SEPTIEMBRE", 9);
        hmMonth.put("OCTUBRE", 10);
        hmMonth.put("NOVIEMBRE", 11);
        hmMonth.put("DICIEMBRE", 12);

        String[] strDays = new String[]{
                "Domingo",
                "Lunes",
                "Martes",
                "Miercoles",
                "Jueves",
                "Viernes",
                "Sabado"};

        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;

        try {
            fecha = dateFormatter.parse(Integer.valueOf(dateNews.getYear()) + "-" +
                    Integer.valueOf(hmMonth.get(dateNews.getMonth())) + "-" +
                    Integer.valueOf(dateNews.getStartDay()));
        } catch (ParseException ex) {
            ex.toString();
        }

        calendar.setTime(fecha);

        return strDays[calendar.get(Calendar.DAY_OF_WEEK) - 1].toString()
                + " , " + dateNews.getStartDay() + " de " +
                StringUtils.capitalize(dateNews.getMonth().toLowerCase()) + " del " +
                dateNews.getYear();
    }
}
