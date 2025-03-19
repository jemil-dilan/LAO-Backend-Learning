package org.Exercise9;

import java.time.LocalDate;
import java.time.Period;

public class CalculateurAge {

    public int calculateAge(int year, int month, int day){
        LocalDate currentDate = LocalDate.now();
        if(year > currentDate.getYear() && month > 12 && day > 31){
            throw new IllegalArgumentException("Wrong date inputed");
        }
        LocalDate userBirthDate = LocalDate.of(year, month, day);

        Period age = Period.between(userBirthDate, currentDate);
        return age.getYears();
    }
}
