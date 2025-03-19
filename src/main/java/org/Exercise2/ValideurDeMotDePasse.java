package org.Exercise2;

public class ValideurDeMotDePasse {
    public boolean isValidPassword(String password){
        final short MIN_LENGTH = 8;
        if (password.length() < MIN_LENGTH){
            return false;
        }

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialCharacter= false;

        for (char c: password.toCharArray()){
            if (Character.isUpperCase(c)){
                hasUppercase = true;
            } else if (Character.isLowerCase(c)){
                hasLowercase = true;
            } else if(Character.isDigit(c)){
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialCharacter= true;
            }
        }

        return hasUppercase && hasLowercase && hasDigit && hasSpecialCharacter;
    }
}
