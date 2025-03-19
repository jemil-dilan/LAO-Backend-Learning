package org.Exercise10;

public class JeuDevinette {

    public int randomNumberGenerator(){
        return (int) (Math.random() *10);
    }

    public boolean comparingValues(int userValue){
        if (Character.isLetter(userValue)){
            throw new IllegalArgumentException("Enter a digit not a letter");
        }
        return randomNumberGenerator() == userValue;
    }
}
