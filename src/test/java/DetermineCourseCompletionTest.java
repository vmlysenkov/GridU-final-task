import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class DetermineCourseCompletionTest {

    @Test
    public void shouldDetermineEndDateWhenCourseEndsAt6PM() {
        LocalDateTime startDate = LocalDateTime.of(2022, Month.FEBRUARY, 4, 10, 0);
        int coursesDuration = 64;

        LocalDateTime actual = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        LocalDateTime expected = LocalDateTime.of(2022, Month.FEBRUARY, 15, 18, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldDetermineEndDateWhenCourseEndsDuringWorkingDay() {
        LocalDateTime startDate = LocalDateTime.of(2022, Month.FEBRUARY, 18, 10, 0);
        int coursesDuration = 30;

        LocalDateTime actual = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        LocalDateTime expected = LocalDateTime.of(2022, Month.FEBRUARY, 23, 16, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldAvoidIndexOutOfBoundsException() {
        LocalDateTime startDate = LocalDateTime.of(2022, Month.FEBRUARY, 4, 10, 0);
        int coursesDuration = 7;

        LocalDateTime actual = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        LocalDateTime expected = LocalDateTime.of(2022, Month.FEBRUARY, 4, 17, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldAvoidWeekendBug() {
        LocalDateTime startDate = LocalDateTime.of(2022, Month.FEBRUARY, 4, 10, 0);
        int coursesDuration = 9;

        LocalDateTime actual = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        LocalDateTime expected = LocalDateTime.of(2022, Month.FEBRUARY, 7, 11, 0);
        assertEquals(expected, actual);
    }
}