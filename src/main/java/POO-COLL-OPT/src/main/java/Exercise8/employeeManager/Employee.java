package Exercise8.employeeManager;

public class Employee {

    private String name;
    private String post;
    private int salary;


    public Employee(String name, int salary, String post) {
        this.name = name;
        this.salary = salary;
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public String getPost() {
        return post;
    }

    public int getSalary() {
        return salary;
    }
}
