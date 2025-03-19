package org.Exercise5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateurFactorielleTest {
    CalculateurFactorielle objectUnderTest = new CalculateurFactorielle();

    @Test
    void calculateFactorialTest() {
        //given
        int number = 5;
        //when
        int actualResult = objectUnderTest.calculateFactorial(number);
        //then
        assertEquals(120, actualResult);
    }

    @Test
    void calculateFactorialOf0Test() {
        //given
        int number = 0;
        //when
        int actualResult = objectUnderTest.calculateFactorial(number);
        //then
        assertEquals(1, actualResult);
    }

    @Test
    void calculateFactorialOf1Test() {
        //given
        int number = 1;
        //when
        int actualResult = objectUnderTest.calculateFactorial(number);
        //then
        assertEquals(1, actualResult);
    }

    @Test
    void calculateFactorialOfNegativeNumbersTest() {
        //given
        int number = -5;
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> objectUnderTest.calculateFactorial(number));
    }
}