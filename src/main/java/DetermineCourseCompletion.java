import java.util.Calendar;
import java.util.Map;
import java.util.stream.Collectors;

public class DetermineCourseCompletion {
    static int workHoursPerDay = 8;
    static int daysInWeek = 5;

    public static Calendar getCourseCompletionDate(Calendar startDate, Map<String, Integer> courseAndDuration) {
        Integer duration = courseAndDuration.entrySet().stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList())
                .stream().reduce(0, Integer::sum);

        int wholeDaysToCompleteCourse = duration / workHoursPerDay;
        if (duration % workHoursPerDay != 0) {
            wholeDaysToCompleteCourse += 1;
        }
        int wholeWeeksToCompleteCourse = wholeDaysToCompleteCourse / daysInWeek;
        wholeDaysToCompleteCourse = wholeDaysToCompleteCourse + wholeWeeksToCompleteCourse * 2 - 1;

        startDate.add(Calendar.DAY_OF_WEEK, wholeDaysToCompleteCourse);
        return startDate;
    }
}
