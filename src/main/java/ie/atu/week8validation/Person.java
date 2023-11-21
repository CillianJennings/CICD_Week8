package ie.atu.week8validation;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person {
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 character")
    private String name;

    @NotBlank(message = "Title cannot be blank")
    @Size(min = 2, max = 9, message = "Name must be between 2 and 9 character")
    private String title;

    @NotBlank(message = "EmployeeID cannot be blank")
    private String employeeID;

    @NotNull(message = "Age cannot be blank")
    @PositiveOrZero(message = "Age cannot be below zero")
    private int age;

    @Email(message = "Invalid email address")
    @NotBlank(message = "email cannot be blank")
    private String email;

    private String position;

    private String department;

}
