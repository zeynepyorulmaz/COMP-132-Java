package student;

import exception.InvalidStudentException;

public class StudentValidator {
	public static void validateID(String ID) throws InvalidStudentException {
        if (!ID.matches("^00\\d{5}$")) {
            throw new InvalidStudentException("Invalid student ID format.");
        }
    }

    public static void validateAge(int age) throws InvalidStudentException {
        if (age <= 17) {
            throw new InvalidStudentException("Invalid age, must be a positive integer greater than 17");
        }
    }

}