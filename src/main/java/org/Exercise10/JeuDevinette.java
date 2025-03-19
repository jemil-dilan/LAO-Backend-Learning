package org.Exercise10;

public class JeuDevinette {

    public int randomNumberGenerator(){
        return (int) (Math.random() *100);
    }

    public boolean comparingValues(int userValue){
        return randomNumberGenerator() == userValue;
    }
}
