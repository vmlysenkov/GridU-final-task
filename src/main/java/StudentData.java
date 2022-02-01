import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
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

    public String getDate(int year, int month, int dayOfMonth) {
        Calendar startDate = new GregorianCalendar(year, month, dayOfMonth);
        DateFormat df = new SimpleDateFormat("d MMMM yyyy - EEEE");
        return (df.format(startDate.getTime()));
    }
}
