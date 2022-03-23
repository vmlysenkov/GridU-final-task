import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Main {
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy HH:mm - EEEE");

    public static void main(String[] args) {
        LocalDateTime currentDate = LocalDateTime.of(2020, Month.JUNE, 8, 15, 0);
        LocalDateTime startDateStudent1 = LocalDateTime.of(2020, Month.JUNE, 1, 10, 0);
        StudentData student1 = new StudentData("Ivanov Ivan", "Java Developer");
        Curriculum curriculumOfStudent1 = new Curriculum();
        curriculumOfStudent1.addCourse(new CourseData("Java", 16));
        curriculumOfStudent1.addCourse(new CourseData("JDBC", 24));
        curriculumOfStudent1.addCourse(new CourseData("Spring", 16));
        int durationOfCurriculumOfStudent1 = curriculumOfStudent1.getDuration();

        System.out.println("Short report:");

        System.out.print(student1.name + " (" + student1.curriculum + ") - ");

        DurationBeforeOrAfterCourseCompletion timeBetweenCompletionAndNowForStudent1 =
                TimeBetweenDates.calculateAmountOfTimeBeforeOrAfterCourseCompletion(
                        (DateOfCompletion.getCourseCompletionDate(startDateStudent1, durationOfCurriculumOfStudent1)),
                        currentDate);
        System.out.println(TimeBetweenDates.createReportInfo(timeBetweenCompletionAndNowForStudent1));
        System.out.println();
        System.out.println("Full report:");
        System.out.println("student name: " + student1.name);
        System.out.println("working time (from " + TimeBetweenDates.START_WORKING_HOUR + " to "
                + TimeBetweenDates.END_WORKING_HOUR + ")");
        System.out.println("program name: " + student1.curriculum);
        System.out.println("program duration: " + durationOfCurriculumOfStudent1 + " hours");
        System.out.println("start date: " + startDateStudent1.format(formatter));
        System.out.println("end date: " + DateOfCompletion.getCourseCompletionDate(startDateStudent1,
                durationOfCurriculumOfStudent1).format(formatter));
        System.out.println(TimeBetweenDates.createReportInfo(timeBetweenCompletionAndNowForStudent1));
        System.out.println();

        LocalDateTime startDateStudent2 = LocalDateTime.of(2020, Month.JUNE, 1, 10, 0);
        StudentData student2 = new StudentData("Sidorov Ivan", "AQE");
        Curriculum curriculumOfStudent2 = new Curriculum();
        curriculumOfStudent2.addCourse(new CourseData("Test design", 10));
        curriculumOfStudent2.addCourse(new CourseData("Page Object", 16));
        curriculumOfStudent2.addCourse(new CourseData("Selenium", 16));
        int durationOfCurriculumOfStudent2 = curriculumOfStudent2.getDuration();

        System.out.println("Short report:");
        System.out.print(student2.name + " (" + student2.curriculum + ") - ");

        DurationBeforeOrAfterCourseCompletion timeBetweenCompletionAndNowForStudent2 =
                TimeBetweenDates.calculateAmountOfTimeBeforeOrAfterCourseCompletion(
                        (DateOfCompletion.getCourseCompletionDate(startDateStudent2, durationOfCurriculumOfStudent2)),
                        currentDate);
        System.out.println(TimeBetweenDates.createReportInfo(timeBetweenCompletionAndNowForStudent2));
        System.out.println();
        System.out.println("Full report:");
        System.out.println("student name: " + student2.name);
        System.out.println("working time (from " + TimeBetweenDates.START_WORKING_HOUR +
                " to " + TimeBetweenDates.END_WORKING_HOUR + ")");
        System.out.println("program name: " + student2.curriculum);
        System.out.println("program duration: " + durationOfCurriculumOfStudent2 + " hours");
        System.out.println("start date: " + startDateStudent2.format(formatter));
        System.out.println("end date: " + DateOfCompletion.getCourseCompletionDate(startDateStudent2,
                durationOfCurriculumOfStudent2).format(formatter));
        System.out.println(TimeBetweenDates.createReportInfo(timeBetweenCompletionAndNowForStudent2));
    }
}
