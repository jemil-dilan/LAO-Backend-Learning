package org.Exercise6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateurEmailTest {
    ValidateurEmail objectUnderTest = new ValidateurEmail();

    @Test
    void validateEmailTest() {
        //given
        String email = "test@email.com";
        //when
        boolean actualResult = objectUnderTest.validateEmail(email);
        //then
        assertTrue(actualResult);
    }
}