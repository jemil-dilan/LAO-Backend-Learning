package org.Exercise4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ConvertisseurTemperatureTest {
    ConvertisseurTemperature objectUnderTest = new ConvertisseurTemperature();

    @Test
    void conversionToFahrenheitTest() {
        //given
        int temperature = 25;
        int temperature2 = 1;
        int temperature3= 0;
        //when
        double actualResult = objectUnderTest.conversionToFahrenheit(temperature);
        double actualResult2= objectUnderTest.conversionToFahrenheit(temperature2);
        double actualResult3 = objectUnderTest.conversionToFahrenheit(temperature3);
        //then
        assertEquals(77, actualResult);
        assertEquals(33.8, actualResult2);
        assertEquals(32, actualResult3);
    }


    @Test
    void conversionToCelsius() {
        //given
        int temperature = 77;
        //when
        double actualResult = objectUnderTest.conversionToCelsius(temperature);
        //then
        assertEquals(25, actualResult);
    }
}