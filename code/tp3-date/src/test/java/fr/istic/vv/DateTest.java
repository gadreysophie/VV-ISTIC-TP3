package fr.istic.vv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;

import static fr.istic.vv.Date.isLeapYear;
import static fr.istic.vv.Date.isValidDate;
import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    Date date;
    int day;
    int month;
    int year;

    @BeforeEach
    void init(){
        day = 2;
        month = 2;
        year = 2020;
        date = new Date(day,month,year);
    }

    @Test
    @DisplayName("date valide")
    void testIsValideDate(){
        assertTrue(isValidDate(day,month,year));
    }


    @Test
    @DisplayName("date non valide")
    void testIsNotValideDate(){
        assertFalse(isValidDate(32,13,2020));
        assertFalse(isValidDate(-1,-1,2020));
    }

    @Test
    @DisplayName("leap year")
    void testLeapYear(){
        assertTrue(isLeapYear(year));
    }

    @Test
    @DisplayName("compare dates egales")
    void testCompareDate() {
        Date date1 = new Date(day,month,year);
        Date date2 = new Date(day,month,year);
        assertEquals(0, date1.compareTo(date2));
    }


    @Test
    @DisplayName("Test sur previousDate")
    void testPreviousDate(){
        Date previousDate = new Date(1,2,2020);
        assertTrue(date.previousDate().compareTo(previousDate) == 0);
    }

    @Test
    @DisplayName("Test sur previousDate avec changement de mois")
    void testPreviousDateChangeMois(){
        Date date1 = new Date (1,2,2020);
        Date previousDate1 = new Date(31,1,2020);
        Date date2 = new Date (1,3,2020);
        Date previousDate2 = new Date(29,2,2020);
        Date date3 = new Date(1, 4, 2020);
        Date previousDate3 = new Date (31,3, 2020);
        assertTrue(date1.previousDate().compareTo(previousDate1) == 0);
        assertTrue(date2.previousDate().compareTo(previousDate2) == 0);
        assertTrue(date3.previousDate().compareTo(previousDate3) == 0);
    }

    @Test
    @DisplayName("Test sur previousDate avec changement d'année")
    void testPreviousDateChangeAnnee(){
        Date date1 = new Date (1,1,2020);
        Date previousDate1 = new Date(31,12,2019);
        assertTrue(date1.previousDate().compareTo(previousDate1) == 0);
    }

    @Test
    @DisplayName("Test sur nextDate")
    void testNextDate(){
        Date date1 = new Date (1,2,2020);
        Date nextDate1 = new Date(2,2,2020);
        assertTrue(date1.nextDate().compareTo(nextDate1) == 0);
    }

    @Test
    @DisplayName("Test sur nextDate avec changement de mois")
    void testNextDateChangeMois(){
        Date date1 = new Date (29,2,2020);
        Date nextDate1 = new Date (1,3,2020);
        assertTrue(date1.nextDate().compareTo(nextDate1) == 0);
    }

    @Test
    @DisplayName("Test sur nextDate avec changement d'année")
    void testNextDateChangeAnnee(){
        Date date1 = new Date (31,31,2020);
        Date nextDate1 = new Date (1,1,2021);
        assertTrue(date1.nextDate().compareTo(nextDate1) == 0);
    }

    @Test
    @DisplayName("not valide date")
    void testNotValideDate(){
        assertFalse(isValidDate(32,13,3000));
    }
}