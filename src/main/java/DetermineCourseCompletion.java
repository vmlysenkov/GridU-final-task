import java.util.Calendar;

public class DetermineCourseCompletion {
    static int workHoursPerDay = 8;
    static int daysInWeek = 5;

    public static Calendar getCourseCompletionDate(Calendar endDate, int coursesDuration) {

        int wholeDaysToCompleteCourse = coursesDuration / workHoursPerDay;
        if (coursesDuration % workHoursPerDay != 0) {
            wholeDaysToCompleteCourse += 1;
        }
        int wholeWeeksToCompleteCourse = wholeDaysToCompleteCourse / daysInWeek;
        wholeDaysToCompleteCourse = wholeDaysToCompleteCourse + wholeWeeksToCompleteCourse * 2 - 1;

        endDate.add(Calendar.DAY_OF_WEEK, wholeDaysToCompleteCourse);
        return endDate;
    }
}
