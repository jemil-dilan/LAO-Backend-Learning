package org.Exercise6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateurEmailTest {
    ValidateurEmail objectUnderTest = new ValidateurEmail();

    @Test
    void validateEmailTest() {
        //given
        String email = "test_123@email.com";
        //when
        boolean actualResult = objectUnderTest.isValidEmail(email);
        //then
        assertTrue(actualResult);
    }

    @Test
    void validateEmailWithNoSpecialCharacter(){
        //given
        String email = "testemail.com";
        //when
        boolean actualResult = objectUnderTest.isValidEmail(email);
        //then
        assertFalse(actualResult);
    }

    @Test
    void validateEmailWithWrongFormat(){
        //given
        String email = "testemail@maccom";
        //when
        boolean actualResult = objectUnderTest.isValidEmail(email);
        //then
        assertFalse(actualResult);
    }

    @Test
    void validateEmailWithAnotherWrongFormat(){
        //given
        String email = "testemailmaccom";
        //when
        boolean actualResult = objectUnderTest.isValidEmail(email);
        //then
        assertFalse(actualResult);
    }
}