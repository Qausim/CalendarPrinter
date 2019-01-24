package com.qausim;

import javax.xml.soap.Text;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.print("Do you want a single month printed (Press Y/N):>>>\t");
        boolean wantSingleMonth = new Scanner(System.in).nextLine().equalsIgnoreCase("y") ? true : false;

        System.out.print("In what year?\t");
        int year = new Scanner(System.in).nextInt();

        Month[] months = Month.values();

        if (wantSingleMonth) {
            System.out.print("Please input the month you want the calendar for:\t");
            String monthString = new Scanner(System.in).nextLine();


            Month month = null;
            for (Month eachMonth : months) {
                if (eachMonth.getDisplayName(TextStyle.FULL, Locale.getDefault()).equalsIgnoreCase(monthString))
                    month = eachMonth;
            }
            Printer.printMonth(month, year);
        } else {
            for (Month month : months) {
                Printer.printMonth(month, year);
            }
        }
    }
}
