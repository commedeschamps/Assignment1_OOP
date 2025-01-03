import java.util.*;

public class Student extends Person {
    private static int studentIDCounter = 1;
    private int studentID;
    private List<Double> grades;
    private List<Integer> credits;
    private double gpa;

    public Student(String name, String surname, int age, boolean gender, List<String> subjects, List<Double> grades, List<Integer> credits) {
        super(name, surname, age, gender);
        this.studentID = studentIDCounter++;
        this.grades = grades;
        this.credits = credits;
        calculateGPA();
    }

    private void calculateGPA() {
        double totalGrade = 0;
        int totalCredits = 0;
        for (int i = 0; i < grades.size(); i++) {
            totalGrade += grades.get(i) * credits.get(i);
            totalCredits += credits.get(i);
        }
        gpa = totalCredits > 0 ? Math.round((totalGrade / totalCredits) * 100.0) / 100.0 : 0.0;
    }

    public void setGrades(List<Double> grades) {
        this.grades = grades;
        calculateGPA();
    }

    public void setCredits(List<Integer> credits) {
        this.credits = credits;
        calculateGPA();
    }

    public void setGradeForCourse(int index, double grade) {
        if (index >= 0 && index < grades.size()) {
            grades.set(index, grade);
            calculateGPA();
        }
    }

    public void setCreditForSubject(int index, int credit) {
        if (index >= 0 && index < credits.size()) {
            credits.set(index, credit);
            calculateGPA();
        }
    }

    public double getGPA() {
        return gpa;
    }

    @Override
    public String toString() {
        return super.toString() + " I am a student with ID " + studentID + ". GPA: " + gpa;
    }
}
