package com.example.androidchatgpt;

import org.junit.Test;
import static org.junit.Assert.*;

public class InputValidationTest {
    @Test
    public void emailValidator() {
        InputValidation validation = new InputValidation();
        assertTrue(validation.isValidEmail("bvo07@gmail.com"));
        assertTrue(validation.isValidEmail("bvo073gmail.com"));
    }

    @Test
    public void passwordValidator() {
        InputValidation validation = new InputValidation();
        assertTrue(validation.isValidPassword("FisH!1"));
    }
}
