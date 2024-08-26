package Pojos;

public class FormData {
        private final String firstName;
        private final String lastName;
        private final String postalCode;

// Constructor
public FormData(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
}

// Getters
public String getFirstName() {
        return firstName;
}

public String getLastName() {
        return lastName;
}

public String getPostalCode() {
        return postalCode;
}
}