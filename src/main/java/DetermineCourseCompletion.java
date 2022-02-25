import java.time.LocalDate;
import java.util.Calendar;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

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
            endDate.set(Calendar.HOUR_OF_DAY, AmountOfTimeBeforeOrAfterCourseCompletion.endWorkingHour);
        } else {
            endDate.set(Calendar.HOUR_OF_DAY, ((coursesDuration % workHoursPerDay) + AmountOfTimeBeforeOrAfterCourseCompletion.startWorkingHour));
        }
        return endDate;
    }

    public static LocalDate getCourseCompletionDate(LocalDate startDate, int coursesDuration) {
        int coursesHoursLeftTillTheEnd = coursesDuration - workHoursPerDay;
        do {
            startDate = startDate.plusDays(1);
            if (startDate.getDayOfWeek() != SATURDAY && startDate.getDayOfWeek() != SUNDAY) {
                coursesHoursLeftTillTheEnd = coursesHoursLeftTillTheEnd - workHoursPerDay;
            }
        } while (coursesHoursLeftTillTheEnd > 0);

        LocalDate endDate = startDate;
        if ((coursesDuration % workHoursPerDay) == 0) {
            endDate.atTime(AmountOfTimeBeforeOrAfterCourseCompletion.endWorkingHour, 0);
        } else {
            endDate.atTime(((coursesDuration % workHoursPerDay) + AmountOfTimeBeforeOrAfterCourseCompletion.startWorkingHour), 0);
        }
        return endDate;
    }
}
