package models;

import lombok.Data;

@Data
public class RegistrationDetails {
    private String firstName;
    private String lastName;
    private String email;
    private int telephone;
    private String password;
    private String passwordConfirmation;
}
