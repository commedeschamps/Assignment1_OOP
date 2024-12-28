public class Teacher extends Person {
    private String subject;
    private int yearsOfExperience;
    private int salary;

    public Teacher(String firstName, String lastName, int age, boolean gender, String subject, int yearsOfExperience, int salary) {
        super(firstName, lastName, age, gender);
        this.subject = subject;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void giveRaise(double percentage) {
        if (percentage > 0) {
            salary += (salary * percentage) / 100;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " I teach " + subject + ". Salary: " + salary;
    }
}
