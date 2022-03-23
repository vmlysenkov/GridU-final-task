import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class DetermineCourseCompletion {
    static int workHoursPerDay = 8;

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
