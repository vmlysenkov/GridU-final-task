import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {
    public static DateFormat df = new SimpleDateFormat("d MMMM yyyy - EEEE");
    public static DateFormat df1 = new SimpleDateFormat("d MMMM yyyy, HH");

    public static void main(String[] args) {
        StudentData student1 = new StudentData("Ivanov Ivan", "Java Developer");
        Calendar startDateStudent1 = new GregorianCalendar(2022, 0, 17);
        CourseData course1_1 = new CourseData("Java", 16);
        CourseData course1_2 = new CourseData("JDBC", 24);
        CourseData course1_3 = new CourseData("Spring", 16);
        List<CourseData> coursesOfStudent1 = new ArrayList<>();
        coursesOfStudent1.add(course1_1);
        coursesOfStudent1.add(course1_2);
        coursesOfStudent1.add(course1_3);
        int coursesDurationOfStudent1 = coursesOfStudent1.stream().mapToInt(d -> d.duration).sum();
        System.out.printf("Total courses' duration of Student 1 is %d hours%n", coursesDurationOfStudent1);
        System.out.println(student1);
        System.out.println(df.format(startDateStudent1.getTime()));
        System.out.printf("%s \n%s \n%s%n", course1_1, course1_2, course1_3);
        //System.out.println("Student 1 will complete his education on " + df.format(DetermineCourseCompletion.getCourseCompletionDate(startDateStudent1, coursesDurationOfStudent1).getTime()));
        Calendar endDate = DetermineCourseCompletion.getCourseCompletionDate(startDateStudent1, coursesDurationOfStudent1);
        System.out.println(endDate.getTime());
        System.out.println(CourseCompletion.getTimeFromCourseCompletion(endDate, coursesDurationOfStudent1));

        //System.out.println(CourseCompletion.);

        StudentData student2 = new StudentData("Sidorov Ivan", "AQE");
        Calendar startDateStudent2 = new GregorianCalendar(2020, 5, 1);
        CourseData course2_1 = new CourseData("Test design", 10);
        CourseData course2_2 = new CourseData("Page Object", 16);
        CourseData course2_3 = new CourseData("Selenium", 16);
        List<CourseData> coursesOfStudent2 = new ArrayList<>();
        coursesOfStudent2.add(course2_1);
        coursesOfStudent2.add(course2_2);
        coursesOfStudent2.add(course2_3);
        int courseDurationOfStudent2 = coursesOfStudent2.stream().mapToInt(d -> d.duration).sum();
        System.out.printf("Total courses' duration of Student 2 is %d hours%n", courseDurationOfStudent2);
        System.out.println(student2);
        System.out.println(df.format(startDateStudent2.getTime()));
        System.out.printf("%s \n%s \n%s%n", course2_1, course2_2, course2_3);
        System.out.println("Student 2 will complete his education on " + df.format(DetermineCourseCompletion.getCourseCompletionDate(startDateStudent2, courseDurationOfStudent2).getTime()));
    }
}
