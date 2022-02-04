import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class CourseCompletion {

    private static long daysFromCourseCompletion;
    private static long hoursFromCourseCompletion;

    public CourseCompletion() {

    }

    public CourseCompletion(long daysFromCourseCompletion, long hoursFromCourseCompletion) {
    }

    @Override
    public String toString() {
        return "CourseCompletion{}";
    }

    public static CourseCompletion getTimeFromCourseCompletion(Calendar endDate, int coursesDuration) {
        if ((coursesDuration % DetermineCourseCompletion.workHoursPerDay) != 0) {
            endDate.add(Calendar.DAY_OF_WEEK, -1);
            Calendar currentDate = Calendar.getInstance();
            long daysFromCourseCompletion = TimeUnit.MILLISECONDS.toDays(Math.abs(currentDate.getTimeInMillis() - endDate.getTimeInMillis()));
            long hoursFromCourseCompletion = coursesDuration % DetermineCourseCompletion.workHoursPerDay;


        } else {
            Calendar currentDate = Calendar.getInstance();
            long daysFromCourseCompletion = TimeUnit.MILLISECONDS.toDays(Math.abs(currentDate.getTimeInMillis() - endDate.getTimeInMillis()));
            long hoursFromCourseCompletion = 0;
        }
        return new CourseCompletion(daysFromCourseCompletion, hoursFromCourseCompletion);
    }
}
//, int coursesDuration