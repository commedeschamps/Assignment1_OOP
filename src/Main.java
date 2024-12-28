import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        School school = new School();

        try (BufferedReader studentReader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = studentReader.readLine()) != null) {
                String[] studentData = line.split("\\s+");

                if (studentData.length < 5) {
                    System.out.println("Invalid student data: " + line);
                    continue;
                }

                String firstName = studentData[0];
                String lastName = studentData[1];
                int age = Integer.parseInt(studentData[2]);
                boolean gender = studentData[3].equalsIgnoreCase("Male");

                List<String> subjects = new ArrayList<>();
                List<Double> grades = new ArrayList<>();
                List<Integer> credits = new ArrayList<>();

                for (int i = 4; i < studentData.length; i += 2) {
                    if (i + 1 >= studentData.length) {
                        System.out.println("Mismatch in grades and credits for " + firstName + " " + lastName);
                        continue;
                    }

                    subjects.add(studentData[i]);
                    try {
                        grades.add(Double.parseDouble(studentData[i + 1]));
                        credits.add(3); // assuming 1 course - 3 credit
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid grade value: " + studentData[i + 1]);
                    }
                }

                if (grades.size() != subjects.size()) {
                    System.out.println("Mismatch in grades and subjects for " + firstName + " " + lastName);
                    continue;
                }

                Student student = new Student(firstName, lastName, age, gender, subjects, grades, credits);
                school.addMember(student);
            }
        } catch (IOException e) {
            System.out.println("Error reading students file: " + e.getMessage());
        }

        try (BufferedReader teacherReader = new BufferedReader(new FileReader("teachers.txt"))) {
            String line;
            while ((line = teacherReader.readLine()) != null) {
                String[] teacherData = line.split("\\s+");

                if (teacherData.length < 7) {
                    System.out.println("Invalid teacher data: " + line);
                    continue;
                }

                String firstName = teacherData[0];
                String lastName = teacherData[1];
                int age = Integer.parseInt(teacherData[2]);
                boolean gender = teacherData[3].equalsIgnoreCase("Male");
                String subject = teacherData[4];
                int yearsOfExperience = Integer.parseInt(teacherData[5]);
                int salary = Integer.parseInt(teacherData[6]);

                Teacher teacher = new Teacher(firstName, lastName, age, gender, subject, yearsOfExperience, salary);
                school.addMember(teacher);
            }
        } catch (IOException e) {
            System.out.println("Error reading teachers file: " + e.getMessage());
        }

        for (Person member : school.getMembers()) {
            if (member instanceof Teacher) {
                Teacher teacher = (Teacher) member;
                if (teacher.getYearsOfExperience() > 10) {
                    System.out.println("Before Raise: " + teacher);
                    teacher.giveRaise(10);
                    System.out.println("After Raise: " + teacher);
                }
            }
        }

        System.out.println(school);
    }
}
