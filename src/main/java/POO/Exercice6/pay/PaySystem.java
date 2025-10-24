package pay;

import java.util.ArrayList;
import java.util.List;

public class PaySystem{
    
    List<Employee> allTheEmployees = new ArrayList<Employee>();

    public void payEmloyees() {

        System.out.println("Fiche de paye de tous les employés");
        for (Employee employee : allTheEmployees) {
            
            System.out.println(
                "nom: " + employee.getName()
                + "\nmatricle: " + employee.getEmployeeNumber()
                + "\nsalaire: " + employee.calculateSalary()
            );
        }
    }
}
