import java.util.Calendar;

public class DetermineCourseCompletion {
    static int workHoursPerDay = 8;

    public static Calendar getCourseCompletionDate(Calendar endDate, int coursesDuration) {
        endDate.add(Calendar.DAY_OF_MONTH, -1);
        do {
            endDate.add(Calendar.DAY_OF_MONTH, 1);
            if (endDate.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && endDate.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                coursesDuration = coursesDuration - workHoursPerDay;
            }
        } while (coursesDuration > 0);
        return endDate;
    }
}
