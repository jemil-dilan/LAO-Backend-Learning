package org.Exercise1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator objectUnderTest = new Calculator();

    @Test
    void additionTestForPositiveNumbers(){
        //Given
        double a = 17.0;
        double b = 18.0;
        int expected = 35;
        //When
        double actualResult = objectUnderTest.addition(a, b);
        //Then
        assertEquals(expected,actualResult);
    }

    @Test
    void additionTestForNegativeNumbers(){
        //Given
        double expected = -11.0;
        double a = -5.0;
        double b = -6.0;
        //When
        double actualResult = objectUnderTest.addition(a, b);
        //Then
        assertEquals(expected, actualResult);
    }

    @Test
    void addTestForZeros(){
        //Given
        double a = -3.0;
        double b = 0.0;
        double expected = -3.0;
        //When
        double actualResult = objectUnderTest.addition(a, b);
        //Then
        assertEquals(expected, actualResult);
    }

    //cas de teste pour la soustraction
    @Test
    void subtractionTestForPositiveNumbers(){
        //Given
        double a = 17.0;
        double b = 18.0;
        int expected = 1;
        //When
        double actualResult = objectUnderTest.subtraction(a, b);
        //Then
        assertEquals(expected,actualResult);
    }

    @Test
    void subtractionTestForNegativeNumbers(){
        //Given
        double expected = 1.0;
        double a = -6.0;
        double b = -5.0;
        //When
        double actualResult = objectUnderTest.subtraction(a, b);
        //Then
        assertEquals(expected, actualResult);
    }

    @Test
    void subtractionTestForZeros(){
        //Given
        double a = -3.0;
        double b = 0.0;
        double expected = 3.0;
        //When
        double actualResult = objectUnderTest.subtraction(a, b);
        //Then
        assertEquals(expected, actualResult);
    }

    //Cas de test pour multiplication
    @Test
    void multiplicationTestForPositiveNumbers(){
        //Given
        double b = 3.0;
        double a = 2.0;
        double expected = 6.0;
        //When
        double actualResult = objectUnderTest.multiplication(a, b);
        //Then
        assertEquals(expected,actualResult);
    }

    @Test
    void multiplicationTestForNegativeNumbers(){
        //Given
        double a = -2.0;
        double b = -5.0;
        double expected = 10.0;
        //When
        double actualResult = objectUnderTest.multiplication(a, b);
        //Then
        assertEquals(expected, actualResult);
    }

    @Test
    void multiplicationTestForZero(){
        //Given
        double a = 2.0;
        double b = 0.0;
        double expected = 0.0;
        //When
        double actualResult = objectUnderTest.multiplication(a, b);
        //Then
        assertEquals(expected, actualResult);
    }

    //cas de teste pour division
    @Test
    void divisionTestForPositiveNumbers(){
        //Given
        double a = 9.0;
        double b = 18.0;
        int expected = 2;
        //When
        double actualResult = objectUnderTest.division(a, b);
        //Then
        assertEquals(expected,actualResult);
    }

    @Test
    void divisionTestForNegativeNumbers(){
        //Given
        double expected = -5.0;
        double a = 5.0;
        double b = -25.0;
        //When
        double actualResult = objectUnderTest.division(a, b);
        //Then
        assertEquals(expected, actualResult);
    }

    @Test
    void divisionTestForZerosAsDenominator(){
        //Given
        double a = 0.0;
        double b = 10.0;
        //When
        double actualResult = objectUnderTest.division(a, b);
        //Then
        assertTrue(Double.isInfinite(actualResult));
}



}