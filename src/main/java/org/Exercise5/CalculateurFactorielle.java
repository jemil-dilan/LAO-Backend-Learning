package org.Exercise5;

public class CalculateurFactorielle {
    public int calculateFactorial(int number){
        if (number < 0) {
            throw new IllegalArgumentException("Number must be greater than zero");
        }
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
