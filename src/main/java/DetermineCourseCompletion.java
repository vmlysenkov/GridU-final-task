import java.util.Calendar;

public class DetermineCourseCompletion {
    static int workHoursPerDay = 8;

    public static Calendar getCourseCompletionDate(Calendar startDate, int coursesDuration) {
      coursesDuration -= workHoursPerDay;
        do {
            startDate.add(Calendar.DAY_OF_MONTH, 1);
            if (startDate.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startDate.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                coursesDuration = coursesDuration - workHoursPerDay;
            }

        } while (coursesDuration > 0);

        Calendar endDate = startDate;
        return endDate;
    }
}
