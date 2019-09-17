package order.repository.results.object;

public class EmployeeResult {
    private int employeeNumber;
    private String email;

    public EmployeeResult() {

    }

    public EmployeeResult(int employeeNumber, String email) {
        this.employeeNumber = employeeNumber;
        this.email = email;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}