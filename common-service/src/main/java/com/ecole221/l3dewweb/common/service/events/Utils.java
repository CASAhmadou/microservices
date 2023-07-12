package com.ecole221.l3dewweb.common.service.events;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Utils {

    public static long getYearsBetweenToDates(LocalDate date1 /* older */, LocalDate date2 /* most recent*/){
        Period diff = Period.between(date1, date2);
        return diff.getYears();
    }

    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    /**public static Date convertToDateViaInstant(LocalDate dateToConvert){
        return;
    }**/
}
