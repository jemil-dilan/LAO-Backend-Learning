package POO.Exercice6.pay;

import java.util.HashSet;
import java.util.Set;

public class PaySystem{
    
    Set<Employee> allTheEmployees = new HashSet<Employee>();

    public void payEmloyees() {

        System.out.println("Fiche de paye de tous les employés");
        for (Employee employee : allTheEmployees) {
            
            System.out.println("nom: " + employee.getName()
                + "\nmatricle: " + employee.getEmployeeNumber()
                + "\nsalaire: " + employee.calculateSalary()
            );
        }
    }
}
