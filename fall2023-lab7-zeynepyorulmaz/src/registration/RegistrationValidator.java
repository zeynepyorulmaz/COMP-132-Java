package registration;

import exception.InvalidRegistrationException;

public class RegistrationValidator {
	public static void validateGrade(double grade) throws InvalidRegistrationException {
        if (grade < 0.0 || grade > 100.0) {
            throw new InvalidRegistrationException("Invalid grade, must be between 0.0 and 100.0");
        }
    }
}