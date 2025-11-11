package POO.Exercice6.pay;

public class PartialTimeEmployee extends Employee {

    private int hoursWorked;
    private double houseRate;

    private PartialTimeEmployee(String name, int employeeNumber, int baseSalary, int hoursWorked, double houseRate){

        super(name, employeeNumber, baseSalary);
        this.hoursWorked = hoursWorked;
        this.houseRate = houseRate;
    }

    @Override
    public double calculateSalary() {

        return hoursWorked * houseRate;
    }
}

