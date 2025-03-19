package org.Exercise10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JeuDevinetteTest {
    JeuDevinette objectUnderTest = new JeuDevinette();

    @Test
    void randomNumberGenerationTest(){
        //given
        //when
        int actualResult = objectUnderTest.randomNumberGenerator();
        //then
        assertTrue(actualResult >=0 && actualResult < 100);
    }

    @Test
    void comparisonTest(){
        //given
        int userValue = 20;
        //when
        boolean actualResult = objectUnderTest.comparingValues(userValue);
        //then
        assertFalse(actualResult);
    }
}