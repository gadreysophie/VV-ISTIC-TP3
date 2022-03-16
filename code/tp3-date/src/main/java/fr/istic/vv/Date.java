package fr.istic.vv;

import java.util.Calendar;


class Date implements Comparable<Date> {

    java.util.Date date;
    int day;
    int month;
    int year;


    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        date = new java.util.Date(day, month, year);
    }

    public Date() {

    }

    public int getDateDay() {
        return day;
    }

    public int getDateMonth() {
        return month;
    }

    public int getDateYear() {
        return year;
    }

    public static boolean isValidDate(int day, int month, int year) {

        if (day <= 0 || month <= 0 || year <= 0) {
            return false;
        }
        if (month > 12 || day > 31) {
            return false;
        }

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);

        // Find the maximum field value possible for the day with the year and month.
        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (day > maxDay) {
            return false;
        }
        return true;
    }

    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public Date nextDate() {
        int nextDay = getDateDay() + 1;
        int nextMonth = getDateMonth() + 1;
        int nextYear = getDateYear() + 1;
        Date nextDate;
        if (isValidDate(nextDay, month, year)) {
            return nextDate = new Date(nextDay, month, year);
        } else if (isValidDate(day, nextMonth, year)) {
            return nextDate = new Date(1, nextMonth, year);
        } else {
            return nextDate = new Date(1, 1, nextYear);
        }
    }

    public Date previousDate() {
        int previousDay = getDateDay() - 1;
        int previousMonth = getDateMonth() - 1;
        int previousYear = getDateYear() - 1;
        if (isValidDate(previousDay, month, year)) {
            return new Date(previousDay, month, year);
        } else if (isValidDate(day, previousMonth, year)) {
            if (isValidDate(31,previousMonth,year)){
                return new Date(31, previousMonth, year);
            }
            else if (isValidDate(30,previousMonth,year)){
                return new Date(30, previousMonth, year);
            }
            else if (isValidDate(29,previousMonth,year)){
                return new Date(29, previousMonth, year);
            }
            else return new Date(28, previousMonth, year);
        } else {
            return new Date(31, 12, previousYear);
        }
    }

    public int compareTo(Date other) {
        return other.date.compareTo(this.date);
    }

    public boolean equals(Object other) {
        if (other instanceof Date) {
            return compareTo((Date) other) == 0;
        } else return false;
    }
}