import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static DateFormat df = new SimpleDateFormat("d MMMM yyyy - EEEE");
    public static void main(String[] args) {
        StudentData student1 = new StudentData("Ivanov Ivan", "Java Developer");
        Calendar startDateStudent1 = new GregorianCalendar(2020, 5, 1);
        student1.courseAndDuration.put("Java", 16);
        student1.courseAndDuration.put("JDBC", 24);
        student1.courseAndDuration.put("Spring", 16);
        System.out.println(student1);
        System.out.println(df.format(startDateStudent1.getTime()));
        System.out.println(student1.courseAndDuration);
        System.out.println("Student 1 will complete his education on " + df.format(DetermineCourseCompletion.getCourseCompletionDate(startDateStudent1,student1.courseAndDuration).getTime()));
        System.out.println();

        StudentData student2 = new StudentData("Sidorov Ivan", "AQE");
        Calendar startDateStudent2 = new GregorianCalendar(2020, 5, 1);
        student2.courseAndDuration.put("Test design", 10);
        student2.courseAndDuration.put("Page Object", 16);
        student2.courseAndDuration.put("Selenium", 16);
        System.out.println(student2);
        System.out.println(df.format(startDateStudent2.getTime()));
        System.out.println(student2.courseAndDuration);
        System.out.println("Student 2 will complete his education on " + df.format(DetermineCourseCompletion.getCourseCompletionDate(startDateStudent2,student2.courseAndDuration).getTime()));
    }
}
