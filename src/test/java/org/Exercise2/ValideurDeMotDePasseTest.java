package org.Exercise2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValideurDeMotDePasseTest {
    ValideurDeMotDePasse objectUnderTest = new ValideurDeMotDePasse();

    @Test
    void validPasswordTest(){
        //given
        String password = "UzuMym123@@";
        //when
        boolean actualTest = objectUnderTest.isValidPassword(password);
        //then
        assertTrue(actualTest);
    }

    @Test
    void passwordWith7Characters(){
        //given
        String password = "UzMy1@";
        //when
        boolean actualTest = objectUnderTest.isValidPassword(password);
        //then
        assertFalse(actualTest);
    }

    @Test
    void passwordWithNoCapitalLetters(){
        //given
        String password = "uzumym123@";
        //when
        boolean actualTest = objectUnderTest.isValidPassword(password);
        //then
        assertFalse(actualTest);
    }

    @Test
    void passwordWithNoSmallLetters(){
        //given
        String password = "UZUMYM123@";
        //when
        boolean actualTest = objectUnderTest.isValidPassword(password);
        //then
        assertFalse(actualTest);
    }

    @Test
    void passwordWithNoSpecialCharacters(){
        //given
        String password = "UzuMym123456";
        //when
        boolean actualTest = objectUnderTest.isValidPassword(password);
        //then
        assertFalse(actualTest);
    }

}