package org.Exercise6;

import java.util.regex.Pattern;

public class ValidateurEmail {
    public boolean validateEmail(String email){
        String emailFormat = "^[a-zA-Z0-9._%+-] +@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailFormat);
        return pattern.matcher(email).matches();
    }
}
