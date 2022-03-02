import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy - EEEE");
    public static void main(String[] args) {
//        LocalDate startDateStudent1 = LocalDate.of(2022, Month.FEBRUARY, 20);
//        StudentData student1 = new StudentData("Ivanov Ivan", "Java Developer");
//        CourseData course1_1 = new CourseData("Java", 16);
//        CourseData course1_2 = new CourseData("JDBC", 24);
//        CourseData course1_3 = new CourseData("Spring", 16);
//        List<CourseData> coursesOfStudent1 = new ArrayList<>();
//        coursesOfStudent1.add(course1_1);
//        coursesOfStudent1.add(course1_2);
//        coursesOfStudent1.add(course1_3);
//        int coursesDurationOfStudent1 = coursesOfStudent1.stream().mapToInt(d -> d.duration).sum();
//
//        System.out.println("Short report:");
//        System.out.print(student1.name + " (" + student1.curriculum + ") - ");
//        AmountOfTimeBeforeOrAfterCourseCompletion.calculateAmountOfTimeBeforeOrAfterCourseCompletion((DetermineCourseCompletion.getCourseCompletionDate(startDateStudent1, (course1_1.duration + course1_2.duration + course1_3.duration))), (course1_1.duration + course1_2.duration + course1_3.duration));
//        System.out.println();
//        System.out.println("Full report:");
//        System.out.println("student name: " + student1.name);
//        System.out.println("working time (from " + AmountOfTimeBeforeOrAfterCourseCompletion.startWorkingHour + " to " + AmountOfTimeBeforeOrAfterCourseCompletion.endWorkingHour + ")");
//        System.out.println("program name: " + student1.curriculum);
//        System.out.println("program duration: " + coursesDurationOfStudent1 + " hours");
//        System.out.println("start date: " + startDateStudent1.format(formatter));
//        System.out.println("end date: " + DetermineCourseCompletion.getCourseCompletionDate(startDateStudent1, coursesDurationOfStudent1).format(formatter));
//        AmountOfTimeBeforeOrAfterCourseCompletion.calculateAmountOfTimeBeforeOrAfterCourseCompletion((DetermineCourseCompletion.getCourseCompletionDate(startDateStudent1, (course1_1.duration + course1_2.duration + course1_3.duration))), (course1_1.duration + course1_2.duration + course1_3.duration));
//        System.out.println();
//
//        LocalDate startDateStudent2 = LocalDate.of(2022, Month.FEBRUARY, 4);
//        StudentData student2 = new StudentData("Sidorov Ivan", "AQE");
////        Calendar startDateStudent2 = new GregorianCalendar(2020, 5, 1);
//        CourseData course2_1 = new CourseData("Test design", 10);
//        CourseData course2_2 = new CourseData("Page Object", 16);
//        CourseData course2_3 = new CourseData("Selenium", 16);
//        List<CourseData> coursesOfStudent2 = new ArrayList<>();
//        coursesOfStudent2.add(course2_1);
//        coursesOfStudent2.add(course2_2);
//        coursesOfStudent2.add(course2_3);
//        int coursesDurationOfStudent2 = coursesOfStudent2.stream().mapToInt(d -> d.duration).sum();
//
//        System.out.println("Short report:");
//        System.out.print(student2.name + " (" + student2.curriculum + ") - ");
//        AmountOfTimeBeforeOrAfterCourseCompletion.calculateAmountOfTimeBeforeOrAfterCourseCompletion((DetermineCourseCompletion.getCourseCompletionDate(startDateStudent2, (course2_1.duration + course2_2.duration + course2_3.duration))), (course2_1.duration + course2_2.duration + course2_3.duration));
//        System.out.println();
//        System.out.println("Full report:");
//        System.out.println("student name: " + student2.name);
//        System.out.println("working time (from " + AmountOfTimeBeforeOrAfterCourseCompletion.startWorkingHour + " to " + AmountOfTimeBeforeOrAfterCourseCompletion.endWorkingHour + ")");
//        System.out.println("program name: " + student2.curriculum);
//        System.out.println("program duration: " + coursesDurationOfStudent2 + " hours");
//        System.out.println("start date: " + startDateStudent2.format(formatter));
//        System.out.println("end date: " + DetermineCourseCompletion.getCourseCompletionDate(startDateStudent2, coursesDurationOfStudent2).format(formatter));
//        AmountOfTimeBeforeOrAfterCourseCompletion.calculateAmountOfTimeBeforeOrAfterCourseCompletion((DetermineCourseCompletion.getCourseCompletionDate(startDateStudent2, (course2_1.duration + course2_2.duration + course2_3.duration))), (course2_1.duration + course2_2.duration + course2_3.duration));
//        System.out.println();
    }
}
