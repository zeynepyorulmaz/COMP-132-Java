package registration;

import course.Course;
import student.Student;

public class Registration {
	private Student student;
    private Course course;
    private double grade;

    public Registration(Student student, Course course, double grade) {
        this.student = student;
        this.course = course;
        this.grade = grade;
    }

	public Student getStudent() {
		return student;
	}

	public Course getCourse() {
		return course;
	}


	public double getGrade() {
		return grade;
	}

	
    

}