package fr.istic.vv;

import java.util.Calendar;


class Date implements Comparable<Date> {

    Date date;
    int day;
    int month;
    int year;


    public Date(int day, int month, int year) {
        day = day;
        month = month;
        year = year;
        date = new Date (day, month, year);
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
        return date.nextDate();
    }

    public Date previousDate() {
        return date.previousDate(); }

    public int compareTo(Date other) {
        if (other.equals(date)){
        return 0;
        }
        else return -1;
    }

}