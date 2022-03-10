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
        date = new Date();
    }

    @Test
    @DisplayName("date valide")
    void testIsValideDate(){
        assertTrue(isValidDate(day,month,year));
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
        assertEquals(1, date1.compareTo(date2));
    }



    @Test
    @DisplayName("not valide date")
    void testNotValideDate(){
        assertFalse(isValidDate(32,13,3000));
    }
}