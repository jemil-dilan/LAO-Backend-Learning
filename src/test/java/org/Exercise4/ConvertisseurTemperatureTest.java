package org.Exercise4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ConvertisseurTemperatureTest {
    ConvertisseurTemperature objectUnderTest = new ConvertisseurTemperature();

    @Test
    void conversionToFahrenheitTest() {
        //given
        int temperature = 25;
        //when
        double actualResult = objectUnderTest.conversionToFahrenheit(temperature);
        //then
        assertEquals(77, actualResult);
    }

    @Test
    void conversionToFahrenheitToAnotherValueTest() {
        //given
        int temperature = 1;
        //when
        double actualResult= objectUnderTest.conversionToFahrenheit(temperature);
        //then
        assertEquals(33.8, actualResult);
    }

    @Test
    void conversionToFahrenheitFor0Test() {
        //given

        int temperature= 0;
        //when
        double actualResult = objectUnderTest.conversionToFahrenheit(temperature);
        //then
        assertEquals(32, actualResult);
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