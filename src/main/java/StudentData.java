public class StudentData {
    String name;
    String curriculum;

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
