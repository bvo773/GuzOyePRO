package com.example.androidchatgpt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {
    // Email regex pattern
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";

    // Password criteria:
    // At least one digit, and one special character, longer than 4 characters (for now)
    private static final String PASSWORD_PATTERN =  "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$";

    /*
     * Validates email format
     *
     * @param email Email input
     * @return True if email is valid, false otherwise
     */
    
}
