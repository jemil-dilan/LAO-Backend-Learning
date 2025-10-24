package pay;

public class Contractual extends Employee {
 
    private int numberOfProjets;
    private double projectRate;

    public Contractual(String name, int employeeNumber, int baseSalary, int numberOfProjets, double projectRate){
        
        super(name, employeeNumber, baseSalary);
        this.numberOfProjets = numberOfProjets;
        this.projectRate = projectRate;
    }

    @Override
    public double calculateSalary() {

        return projectRate * numberOfProjets;
    }
}
