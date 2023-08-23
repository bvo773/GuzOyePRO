package com.example.androidchatgpt;

import org.junit.Test;
import static org.junit.Assert.*;

public class InputValidationTest {
    @Test
    public void emailValidator() {
        InputValidation validation = new InputValidation();
        assertTrue(validation.isValidEmail("useremail@gmail.com"));
        assertTrue(validation.isValidEmail("useremailgmail.com"));
    }

    @Test
    public void passwordValidator() {
        InputValidation validation = new InputValidation();
        assertTrue(validation.isValidPassword("fish12345"));
    }
}
