package course;

import exception.InvalidCourseException;

public class CourseValidator {
	public static void validateCode(String code) throws InvalidCourseException {
        if (code.length() != 7) {
            throw new InvalidCourseException("Invalid course code format, course ID should contain 7 characters exactly");
        }
        if (!code.matches("[A-Za-z]{4}[0-9]{3}")) {
        	throw new InvalidCourseException("Invalid course code format, course ID starts with four letters and ends with three digits.");
        }
    }

    public static void validateOffering(boolean isOffered) throws InvalidCourseException {
        if (!isOffered) {
            throw new InvalidCourseException("Course is not offered");
        }
    }

}