public abstract class Person {
    protected String name;
    protected String surname;
    protected int age;
    protected boolean gender; // true - Male, false - Female

    public Person(String name, String surname, int age, boolean gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Hi, I am " + name + " " + surname + ", a " + age + "-year-old " + (gender ? "Male" : "Female");
    }
}
