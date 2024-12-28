import java.io.*;
import java.util.*;


public class School {
    private List<Person> members;

    public School() {
        members = new ArrayList<>();
    }

    public void addMember(Person person) {
        members.add(person);
    }

    public List<Person> getMembers() {
        return members;
    }

    public void sortMembersBySurname() {
        members.sort(Comparator.comparing(p -> p.surname));
    }

    @Override
    public String toString() {
        sortMembersBySurname();
        StringBuilder result = new StringBuilder();
        for (Person member : members) {
            result.append(member.toString()).append("\n");
        }
        return result.toString();
    }
}
