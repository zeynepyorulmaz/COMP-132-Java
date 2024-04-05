package main;

import course.Course;
import exception.CertificateEligibilityException;
import exception.InvalidCourseException;
import exception.InvalidRegistrationException;
import exception.InvalidStudentException;
import exception.NoSuchStudentException;
import registration.Registration;
import student.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* *********** Pledge of Honor ************************************************ *

I hereby certify that I have completed this lab assignment on my own
without any help from anyone else. I understand that the only sources of authorized
information in this lab assignment are (1) the course textbook, (2) the
materials posted at the course website and (3) any study notes handwritten by myself.
I have not used, accessed or received any information from any other unauthorized
source in taking this lab assignment. The effort in the assignment thus belongs
completely to me.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Zeynep Yorulmaz, 83684>
********************************************************************************/



public class Main {
    public static void main(String[] args) throws InvalidCourseException {
    	StudentManagementSystem studentManagementSystem = new StudentManagementSystem();

        try {
            

            System.out.println("Part 1 - Results after Input file is read");
            readInputFile(studentManagementSystem);


            System.out.println("\nPart 2 - All Registrations And Transcripts");
            try {
            	Student student1 = new Student("0087548", "Zeynep", 19);
                Student student2 = new Student("0037432", "Fatos", 18);
                studentManagementSystem.addStudent(student1);
                studentManagementSystem.addStudent(student2);
            } catch (InvalidStudentException e) {
                System.err.println(e.getMessage());
            }
            registerStudents(studentManagementSystem);
            studentManagementSystem.printAllRegistrations();
            printStudentTranscripts(studentManagementSystem);

            System.out.println("\nPart 3 - Exception Testing");
            testExceptions(studentManagementSystem);

        } catch (FileNotFoundException e) {
            System.err.println("Input file not found.");
        }
    }

    private static void readInputFile(StudentManagementSystem studentManagementSystem) throws FileNotFoundException {
        File inputFile = new File("src/main/Input.txt");
        Scanner scanner = new Scanner(inputFile);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");

            if (parts[0].contains("C")) {

                try {
                    Course course = new Course(parts[0], parts[1] + " " + parts[2], Integer.parseInt(parts[3]), Boolean.parseBoolean(parts[4]));
                    studentManagementSystem.addCourse(course);
                    System.out.println("Course added: Code: " + parts[0] +
                            ", Title: " + parts[1] + " " + parts[2] +
                            ", Capacity: " + Integer.parseInt(parts[3]));
                    
                } catch (InvalidCourseException e) {
                    System.err.println(e.getMessage());
                    
                }
                
            }
           
        }

        scanner.close();
    }

    

    private static void registerStudents(StudentManagementSystem studentManagementSystem) {
        try {
            
            studentManagementSystem.registerStudent("0087548", "Comp132", 30.5);
            studentManagementSystem.registerStudent("0087548", "Comp304", 25.0);
            studentManagementSystem.registerStudent("0087548", "Comp306", 42.3);
            studentManagementSystem.registerStudent("0037432", "Comp132", 90.5);
            studentManagementSystem.registerStudent("0037432", "Comp341", 85.0);
            studentManagementSystem.registerStudent("0037432", "Comp412", 92.3);
            
        } catch (InvalidRegistrationException | NoSuchStudentException | InvalidCourseException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void printStudentTranscripts(StudentManagementSystem studentManagementSystem) {
        try {

        	System.out.println();
            studentManagementSystem.printStudentTranscript("0087548");
            System.out.println();
            studentManagementSystem.printStudentTranscript("0037432");
        } catch (NoSuchStudentException e) {
            System.out.println(e);
        }
    }

    private static void testExceptions(StudentManagementSystem studentManagementSystem) throws InvalidCourseException {

    	try {
            Student invalidStudent = new Student("0077777", "Invalid", 15);
            studentManagementSystem.addStudent(invalidStudent);
        } catch (InvalidStudentException e) {
        	System.out.println(e);
        }
        try {
            Student invalidStudent = new Student("000007", "Invalid", 20);
            studentManagementSystem.addStudent(invalidStudent);
        } catch (InvalidStudentException e) {
            System.out.println(e);
        }

        try {
            Course invalidCourse = new Course("Mat345345", "Invalid Course", 10, true);
            studentManagementSystem.addCourse(invalidCourse);
        } catch (InvalidCourseException e) {
            System.out.println(e);
        }
        try {
            Course invalidCourse = new Course("12ss000", "Invalid Course", 10, true);
            studentManagementSystem.addCourse(invalidCourse);
        } catch (InvalidCourseException e) {
            System.out.println(e);
        }
        try {
            Course invalidCourse = new Course("Mech777", "Invalid Course", 10, false);
            studentManagementSystem.addCourse(invalidCourse);
        } catch (InvalidCourseException e) {
            System.out.println(e);
        }

        try {
            studentManagementSystem.registerStudent("0087548", "Comp132", 110.0);
        } catch (InvalidRegistrationException | NoSuchStudentException | InvalidCourseException e) {
            System.out.println(e);
        }
        try {
        	Course invalidCourse = new Course("Comp123", "Invalid Course", 0, true);
        	studentManagementSystem.addCourse(invalidCourse);
            studentManagementSystem.registerStudent("0087548", "Comp123", 10.0);
        } catch (InvalidRegistrationException | NoSuchStudentException | InvalidCourseException e) {
            System.out.println(e);
        }


        try {
            studentManagementSystem.printStudentTranscript("0000001");
        } catch (NoSuchStudentException e) {
        	System.out.println(e);
        }
        /**** In-Lab Tests ****/
        /**** IMPORTANT ****/
        /*
        * Name of your StudentManagementSystem might be different.
        * If that's the case, change "studentManagementSystem" with the proper name.
        */
        System.out.println("\nIn-Lab Tests - Export and Certificate Eligibility");
        try {
        studentManagementSystem.exportTranscript("0087548");
        System.out.println("Transcript exported for student 0087548");
        } catch (NoSuchStudentException e) {
        System.err.println(e.getMessage());
        }
        try {
        studentManagementSystem.exportTranscript("0037432");
        System.out.println("Transcript exported for student 0037432");
        } catch (NoSuchStudentException e) {
        System.err.println(e.getMessage());
        }
        try {
        studentManagementSystem.exportCourseStudentList("Comp132");
        System.out.println("Student list exported for course Comp132");
        } catch (InvalidCourseException e) {
        System.err.println(e.getMessage());
        }

        try {
        studentManagementSystem.getCertificate("0087548");
        } catch (NoSuchStudentException | CertificateEligibilityException e) {
        System.err.println(e.getMessage());
        }
        try {
        studentManagementSystem.getCertificate("0037432");
        } catch (NoSuchStudentException | CertificateEligibilityException e) {
        System.err.println(e.getMessage());
        }
        System.out.println("Lets add one more course to 0037432 and try again");
        try {
        studentManagementSystem.registerStudent("0037432", "Comp412", 75.5);
        } catch (InvalidRegistrationException | NoSuchStudentException e) {
        System.err.println(e.getMessage());
        }
        try {
        studentManagementSystem.getCertificate("0037432");
        } catch (NoSuchStudentException | CertificateEligibilityException e) {
        System.err.println(e.getMessage());
        }
        System.out.println("Lets also reprint their (0037432) transcript");
        try {
        studentManagementSystem.exportTranscript("0037432");
        System.out.println("Transcript exported for student 0037432");
        } catch (NoSuchStudentException e) {
        System.err.println(e.getMessage());
    }


    }
    
}
