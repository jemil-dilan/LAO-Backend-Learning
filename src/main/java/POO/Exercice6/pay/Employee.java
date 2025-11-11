package POO.Exercice6.pay;

public abstract class Employee {
    
    protected String name;
    protected int employeeNumber;
    protected int baseSalary;

    public Employee(String name, int employeeNumber, int baseSalary){
        
        this.name = name;
        this.employeeNumber = employeeNumber;
        this.baseSalary = baseSalary;
    }
    
    public String getName() {
        return name;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public abstract double calculateSalary();
}
