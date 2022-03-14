package fr.istic.vv;

import java.util.Calendar;


class Date implements Comparable<Date> {

    java.util.Date date;
    int day;
    int month;
    int year;


    public Date(int day, int month, int year) {
        day = day;
        month = month;
        year = year;
        date = new java.util.Date(day, month, year);
    }

    public Date(){

    }

    public int getDateDay(){
        return day;
    }
    public int getDateMonth(){
        return month;
    }
    public int getDateYear(){
        return year;
    }

    public static boolean isValidDate(int day, int month, int year) {

        if (day <= 0 || month <= 0 || year <= 0){
            return false;}
        if (month > 12 || day > 31){
            return false;}

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
        return year % 400 == 0 || ( year % 4 == 0 && year % 100 != 0 );
    }

    public Date nextDate() {
        int nextDay = getDateDay() + 1;
        int nextMonth = getDateMonth() + 1;
        int nextYear = getDateYear() + 1;
        Date nextDate;
        if (isValidDate(nextDay, month, year)) {
            return nextDate = new Date(nextDay, month, year);
        }
        else if (isValidDate(day, nextMonth, year)){
            return nextDate = new Date(day, nextMonth, year);
        }
        else {
            return nextDate = new Date(day, month, nextYear);
        }
    }

    public Date previousDate() {
        int previousDay = getDateDay() - 1;
        int previousMonth = getDateMonth() - 1;
        int previousYear = getDateYear() - 1;
        Date previousDate;
        if (isValidDate(previousDay, month, year)) {
            return previousDate = new Date(previousDay, month, year);
        }
        else if (isValidDate(day, previousMonth, year)){
            return previousDate = new Date(day, previousMonth, year);
        }
        else {
            return previousDate = new Date(day, month, previousYear);
        } }

    public int compareTo(Date other) {
     return other.date.compareTo(this.date);
    }

}