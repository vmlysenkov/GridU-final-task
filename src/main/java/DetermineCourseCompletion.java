import java.util.Calendar;

public class DetermineCourseCompletion {
    static int workHoursPerDay = 8;

    public static Calendar getCourseCompletionDate(Calendar startDate, int coursesDuration) {
      int coursesHoursLeftTillTheEnd = coursesDuration - workHoursPerDay;
        do {
            startDate.add(Calendar.DAY_OF_MONTH, 1);
            if (startDate.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startDate.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                coursesHoursLeftTillTheEnd = coursesHoursLeftTillTheEnd - workHoursPerDay;
            }

        } while (coursesHoursLeftTillTheEnd > 0);

        Calendar endDate = startDate;
        if ((coursesDuration % workHoursPerDay) == 0) {
            endDate.set(Calendar.HOUR_OF_DAY, CourseCompletion.endWorkingHour);
        } else {
            endDate.set(Calendar.HOUR_OF_DAY, ((coursesDuration % workHoursPerDay) + CourseCompletion.startWorkingHour));
        }
        return endDate;
    }
}
