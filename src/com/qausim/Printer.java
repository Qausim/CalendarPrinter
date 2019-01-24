package com.qausim;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Printer {
    public static void printMonth(Month month, int year) {
        DayOfWeek[] days = DayOfWeek.values();

        LocalDate localDate = LocalDate.of(year, month, 1);

        System.out.println();
        System.out.println(month.getDisplayName(TextStyle.FULL, Locale.getDefault()));

        DayOfWeek firstDayOfMonth = localDate.getDayOfWeek();

        List<Integer> leastMonthDays = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
                17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28);

        List<Integer> monthDays = new ArrayList<>(28);
        monthDays.addAll(leastMonthDays);

        List<Month> monthsWith30Days = Arrays.asList(Month.SEPTEMBER, Month.APRIL, Month.JUNE, Month.NOVEMBER);

        if (monthsWith30Days.contains(month)) {
            monthDays.add(29);
            monthDays.add(30);
        } else if (month == Month.FEBRUARY) {
            if (localDate.isLeapYear()) {
                monthDays.add(29);
            }
        } else {
            monthDays.add(29);
            monthDays.add(30);
            monthDays.add(31);
        }

        for (DayOfWeek day : days)
            System.out.print(String.format("%3s", day.getDisplayName(TextStyle.SHORT, Locale.getDefault())) + "\t");

        System.out.println("\n");

        for (int index = 0; index < days.length; index++) {
            if (days[index] != firstDayOfMonth) {
                System.out.print(String.format("%3s", "") + "\t");
            } else
                break;
        }

        for (Integer day : monthDays) {
            DayOfWeek dayOfWeek = localDate.withDayOfMonth(day).getDayOfWeek();

            if (dayOfWeek == DayOfWeek.MONDAY)
                System.out.println();

            System.out.print(String.format("%3d", day) + "\t");
        }

        System.out.println(); System.out.println();
    }
}
