package main;

import course.Course;

import course.CourseValidator;
import exception.CertificateEligibilityException;
import exception.InvalidCourseException;
import exception.InvalidRegistrationException;
import exception.InvalidStudentException;
import exception.NoSuchStudentException;
import registration.Registration;
import registration.RegistrationValidator;
import student.Student;
import student.StudentValidator;
import java.io.Writer;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentManagementSystem {
    private HashMap<String, Student> students;
    private HashMap<String, Course> courses;
    private ArrayList<Registration> registrations;

    public StudentManagementSystem() {
        this.students = new HashMap<>();
        this.courses = new HashMap<>();
        this.registrations = new ArrayList<>();
    }

    public void addStudent(Student student) throws InvalidStudentException {
        StudentValidator.validateID(student.getID());
        StudentValidator.validateAge(student.getAge());

        students.put(student.getID(), student);
        
    }

    public void addCourse(Course course) throws InvalidCourseException {
        CourseValidator.validateCode(course.getCode());
        CourseValidator.validateOffering(course.isOffered());

        courses.put(course.getCode(), course);
    }

    public void registerStudent(String studentID, String courseCode, double grade)
            throws InvalidRegistrationException, NoSuchStudentException, InvalidCourseException {

        if (!students.containsKey(studentID)) {
            throw new NoSuchStudentException("Student with ID " + studentID + " does not exist");
        }

        if (!courses.containsKey(courseCode)) {
            throw new InvalidCourseException("Course with code " + courseCode + " does not exist");
        }

        Student student = students.get(studentID);
        Course course = courses.get(courseCode);

        if (course.getCapacity() <= 0) {
            throw new InvalidRegistrationException("Course is full, cannot register");
        }

        RegistrationValidator.validateGrade(grade);

        Registration registration = new Registration(student, course, grade);
        registrations.add(registration);

        course.setCapacity(course.getCapacity() - 1);
    }

    public void printAllRegistrations() {
        for (Registration registration : registrations) {
            System.out.println("Student ID: " + registration.getStudent().getID() +
                    ", Course Code: " + registration.getCourse().getCode() +
                    ", Grade: " + registration.getGrade());
        }
    }

    public void printStudentTranscript(String studentID) throws NoSuchStudentException {
        if (!students.containsKey(studentID)) {
            throw new NoSuchStudentException("Student with ID " + studentID + " does not exist");
        }

        System.out.println("Transcript for Student ID: " + studentID);

        for (Registration registration : registrations) {
            if (registration.getStudent().getID().equals(studentID)) {
                System.out.println("Course Code: " + registration.getCourse().getCode() +
                        ", Grade: " + registration.getGrade());
            }
        }
    }
    


    public void exportTranscript(String studentID) throws NoSuchStudentException {
        if (!students.containsKey(studentID)) {
            throw new NoSuchStudentException("Student with ID " + studentID + " does not exist");
        }

        String fileName = "Transcript_" + studentID + ".txt";
        
        FileWriter writer = null;
		try {
			writer = new FileWriter(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			writer.write("Transcript for Student ID: " + studentID + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        for (Registration registration : registrations) {
            if (registration.getStudent().getID().equals(studentID)) {
                try {
					writer.write("Course Code: " + registration.getCourse().getCode() +
					        ", Grade: " + registration.getGrade() + "\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
    }

   
    


    public void exportCourseStudentList(String courseCode) throws InvalidCourseException {
        if (!courses.containsKey(courseCode)) {
            throw new InvalidCourseException("Course with code " + courseCode + " does not exist");
        }

        String fileName = "CourseStudents_" + courseCode + ".txt";

        FileWriter writer = null;
		try {
			writer = new FileWriter(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("here1");
		} 
        try {
			writer.write("Student List for Course Code: " + courseCode + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        for (Registration registration : registrations) {
            if (registration.getCourse().getCode().equals(courseCode)) {
                Student student = registration.getStudent();
                try {
					writer.write("Student ID: " + student.getID() + ", Name: " + student.getName() + "\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("here");
				}
            }}
        }
    public void getCertificate(String studentID) throws CertificateEligibilityException, NoSuchStudentException {
        if (!students.containsKey(studentID)) {
            throw new NoSuchStudentException("Student with ID " + studentID + " does not exist");
        }

        int enrolledCourses = 0;
        double totalGrade = 0;

        for (Registration registration : registrations) {
            if (registration.getStudent().getID().equals(studentID)) {
                enrolledCourses++;
                totalGrade += registration.getGrade();
            }
        }

        if (enrolledCourses >= 4 && (totalGrade / enrolledCourses) >= 75.0) {
            System.out.println(studentID + " is eligible for a certificate");
        } else {
            throw new CertificateEligibilityException("Student " + studentID +
                    " is not eligible for a certificate");
        }
    }

        

	public HashMap<String, Course> getCourses() {
		return courses;
	}

	public void setCourses(HashMap<String, Course> courses) {
		this.courses = courses;
	}

	
}