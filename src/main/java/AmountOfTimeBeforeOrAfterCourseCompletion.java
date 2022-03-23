import java.time.Duration;
import java.time.LocalDateTime;

public class AmountOfTimeBeforeOrAfterCourseCompletion {
    public static final int START_WORKING_HOUR = 10;
    public static final int END_WORKING_HOUR = 18;

    public static DurationBeforeOrAfterCourseCompletion calculateAmountOfTimeBeforeOrAfterCourseCompletion(LocalDateTime endDate, LocalDateTime currentDate) {
        int daysBetween = (int) Duration.between(currentDate, endDate).toDays();
        int hoursBetween = Duration.between(currentDate, endDate).toHoursPart();
        return new DurationBeforeOrAfterCourseCompletion(daysBetween, hoursBetween);
    }

    public static String createReportInfo(DurationBeforeOrAfterCourseCompletion timeBetweenCompletionAndNowForStudent1) {
        String reportOfStudent;
        if (timeBetweenCompletionAndNowForStudent1.getDays() == 0 && timeBetweenCompletionAndNowForStudent1.getHours() == 0) {
            reportOfStudent = "Training just finished. " + timeBetweenCompletionAndNowForStudent1.getDays() + " d "
                    + timeBetweenCompletionAndNowForStudent1.getHours() + " hours left.";
        } else if ((timeBetweenCompletionAndNowForStudent1.getDays() > 0 && timeBetweenCompletionAndNowForStudent1.getHours() > 0)
                || (timeBetweenCompletionAndNowForStudent1.getDays() == 0 && timeBetweenCompletionAndNowForStudent1.getHours() > 0)
                || (timeBetweenCompletionAndNowForStudent1.getDays() > 0 && timeBetweenCompletionAndNowForStudent1.getHours() == 0)) {
            reportOfStudent = "Training is not finished. " + timeBetweenCompletionAndNowForStudent1.getDays() + " d "
                    + timeBetweenCompletionAndNowForStudent1.getHours() + " hours are left until the end.";
        } else {
            reportOfStudent = "Training completed. " + Math.abs(timeBetweenCompletionAndNowForStudent1.getDays()) + " d "
                    + Math.abs(timeBetweenCompletionAndNowForStudent1.getHours()) + " hours have passed since the end.";
        }
        return reportOfStudent;
    }
}