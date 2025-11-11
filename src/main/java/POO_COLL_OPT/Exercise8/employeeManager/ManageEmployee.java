package POO_COLL_OPT.Exercise8.employeeManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ManageEmployee {

    List<Employee> employees;

    public ManageEmployee(List<Employee> employees) {
        this.employees = new ArrayList<Employee>(employees);
    }

    public void addEmployee(Employee employee){

        employees.add(employee);
    }

    public void removeEmployee(Employee employee){

        employees.remove(employee);
    }

    public Optional<Employee> employeeWithBiggestSalary() {

        return  employees.stream().filter(Objects::nonNull).reduce((employee1, employee2) ->  employee1.getSalary() >= employee2.getSalary() ? employee1 : employee2);
    }
}
