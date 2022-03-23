import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class DateOfCompletion {
    public static final int WORK_HOURS_PER_DAY = 8;

    public static LocalDateTime getCourseCompletionDate(LocalDateTime startDate, int coursesDuration) {
        LocalDateTime endDate = startDate;
        int amountOfHoursLeftUntilEnd = coursesDuration - WORK_HOURS_PER_DAY;
        while (amountOfHoursLeftUntilEnd > 0) {
            endDate = endDate.plusDays(1);
            if (!(endDate.getDayOfWeek() == DayOfWeek.SATURDAY || endDate.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                amountOfHoursLeftUntilEnd -= WORK_HOURS_PER_DAY;
            }
        }
        if (coursesDuration % WORK_HOURS_PER_DAY == 0) {
            endDate = LocalDateTime.of(endDate.getYear(), endDate.getMonth(), endDate.getDayOfMonth(),
                    TimeBetweenDates.END_WORKING_HOUR, 0);
        } else {
            endDate = LocalDateTime.of(endDate.getYear(), endDate.getMonth(), endDate.getDayOfMonth(),
                    TimeBetweenDates.START_WORKING_HOUR + coursesDuration % WORK_HOURS_PER_DAY,
                    0);
        }
        return endDate;
    }
}
