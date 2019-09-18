package order.management.web.domain.entities.object;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * Employee
 */
public class Employee {

    @NotEmpty
    @Email
    private String email;

    public Employee(@NotEmpty @Email String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
