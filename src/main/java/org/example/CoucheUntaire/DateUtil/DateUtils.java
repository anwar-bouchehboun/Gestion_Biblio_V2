package org.example.CoucheUntaire.DateUtil;

import org.example.CouchePresentation.CostumColor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {


    public static LocalDate parseDate(String date) {
        try {
            //Patterns for Formatting and Parsing
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            System.out.println(CostumColor.WHITE_BOLD_BRIGHT+"Date invalide, veuillez réessayer."+ CostumColor.RESET
            );
            return null;
        }
    }
}
