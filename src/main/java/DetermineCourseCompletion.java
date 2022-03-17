import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static LocalDateTime getCourseCompletionDate(LocalDateTime startDate, int coursesDuration) {
        LocalDateTime endDate = startDate;
        int amountOfHoursLeftUntilEnd = coursesDuration - workHoursPerDay;
        while (amountOfHoursLeftUntilEnd > 0) {
            endDate = endDate.plusDays(1);
            if (!(endDate.getDayOfWeek() == DayOfWeek.SATURDAY || endDate.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                amountOfHoursLeftUntilEnd -= workHoursPerDay;
            }
        }
        if (coursesDuration % workHoursPerDay == 0) {
            endDate = LocalDateTime.of(endDate.getYear(), endDate.getMonth(), endDate.getDayOfMonth(),
                    AmountOfTimeBeforeOrAfterCourseCompletion.endWorkingHour, 0);
        } else {
            endDate = LocalDateTime.of(endDate.getYear(), endDate.getMonth(), endDate.getDayOfMonth(),
                    AmountOfTimeBeforeOrAfterCourseCompletion.startWorkingHour + coursesDuration % workHoursPerDay,
                    0);
        }
        return endDate;
    }
}
