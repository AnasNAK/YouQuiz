package org.NAK.YouQuiz.DTO.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    @NotBlank(message = "First name is required and cannot be blank.")
    @Size(max = 50, message = "First name must not exceed 50 characters.")
    private String firstName;

    @NotBlank(message = "Last name is required and cannot be blank.")
    @Size(max = 50, message = "Last name must not exceed 50 characters.")
    private String lastName;

    @NotBlank(message = "Address is required and cannot be blank.")
    @Size(max = 255, message = "Address must not exceed 255 characters.")
    private String address;

    @NotNull(message = "Birth date is required.")
    private LocalDate birthDate;

}
