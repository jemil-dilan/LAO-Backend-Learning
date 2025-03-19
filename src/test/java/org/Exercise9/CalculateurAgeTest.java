package org.Exercise9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateurAgeTest {
    CalculateurAge objectUnderTest = new CalculateurAge();

    @Test
    void calculateAgeTest() {
        //given
        int year = 1998;
        int month = 1;
        int day = 10;
        //when
        int actualResult = objectUnderTest.calculateAge(year, month, day);
        //then
        assertEquals(27, actualResult);
    }

    @Test
    void calculateAgeInMonthsTest() {
        //given
        int year = 2025;
        int month = 2;
        int day = 12;
        //when
        int actualResult = objectUnderTest.calculateAge(year, month, day);
        //then
        assertEquals(1, actualResult);
    }

    @Test
    void calculateAgeWithWrongValueTest() {
        //given
        int year = 2026;
        int month = 8;
        int day = 12;
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> objectUnderTest.calculateAge(year, month, day));
    }


}