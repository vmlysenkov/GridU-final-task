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
        List<LocalDateTime> dateUntilEnd =
                Stream.iterate(startDate, d -> d.plusDays(1))
                        .filter(d -> d.getDayOfWeek() != DayOfWeek.SATURDAY && d.getDayOfWeek() != DayOfWeek.SUNDAY)
                        .limit(coursesDuration / workHoursPerDay)
                        .collect(Collectors.toList());
        System.out.println(dateUntilEnd);

        LocalDateTime endDate = dateUntilEnd.get(dateUntilEnd.size() - 1);
        if ((coursesDuration % workHoursPerDay) == 0) {
            endDate = endDate.with(LocalTime.of(AmountOfTimeBeforeOrAfterCourseCompletion.endWorkingHour, 0));
        } else {
            endDate = endDate.plusDays(1).with(LocalTime.of(((coursesDuration % workHoursPerDay) + AmountOfTimeBeforeOrAfterCourseCompletion.startWorkingHour), 0));
        }
        return endDate;
    }

    public static LocalDateTime determineEndDateSkippingWeekends(LocalDateTime startDate, int coursesDuration) {
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
