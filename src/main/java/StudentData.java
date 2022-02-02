import java.util.HashMap;
import java.util.Map;

public class StudentData {
    String name;
    String curriculum;
    Map<String, Integer> courseAndDuration = new HashMap<>();

    public StudentData(String name, String curriculum) {
        this.name = name;
        this.curriculum = curriculum;
    }

    @Override
    public String toString() {
        return "StudentData{" +
                "name='" + name + '\'' +
                ", curriculum='" + curriculum + '\'' +
                '}';
    }
}
