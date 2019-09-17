package order.domain.entities.object;

import order.domain.value.object.EmployeeNumber;

public class Employee {
    private EmployeeNumber employeeNumber;
    private String email;;

    public Employee(EmployeeNumber employeeNumber, String email) {
        this.employeeNumber = employeeNumber;
        this.email = email;
    }

    public EmployeeNumber getEmployeeNumber() {
        return employeeNumber;
    }

    public String getEmail() {
        return email;
    }
}
