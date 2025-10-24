package pay;

public class FullTimeEmployee extends Employee {
    
    private double advantages;

    public FullTimeEmployee(String name, int employeeNumber, int baseSalary, double advantages){

        super(name, employeeNumber, baseSalary);
        this.advantages = advantages;
    }

    @Override
    public double calculateSalary() {

        return (baseSalary + advantages);
    }
}
