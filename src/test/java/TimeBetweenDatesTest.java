import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class TimeBetweenDatesTest {
    LocalDateTime currentDate = LocalDateTime.of(2022, Month.MARCH, 2, 15, 0);

    @Test
    public void shouldCalculateDaysAndHoursBeforeCourseCompletionForIvanIvanov() {
        LocalDateTime currentDate = LocalDateTime.of(2020, Month.JUNE, 8, 15, 0);
        LocalDateTime startDate = LocalDateTime.of(2020, Month.JUNE, 1, 10, 0);
        int coursesDuration = 56;

        LocalDateTime endDate = DateOfCompletion.getCourseCompletionDate(startDate, coursesDuration);
        DurationBeforeOrAfterCourseCompletion actual = TimeBetweenDates.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, currentDate);
        DurationBeforeOrAfterCourseCompletion expected = new DurationBeforeOrAfterCourseCompletion(1, 3);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateDaysAndHoursAfterCourseCompletionForIvanSidorov() {
        LocalDateTime currentDate = LocalDateTime.of(2020, Month.JUNE, 8, 15, 0);
        LocalDateTime startDate = LocalDateTime.of(2020, Month.JUNE, 1, 10, 0);
        int coursesDuration = 42;

        LocalDateTime endDate = DateOfCompletion.getCourseCompletionDate(startDate, coursesDuration);
        DurationBeforeOrAfterCourseCompletion actual = TimeBetweenDates.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, currentDate);
        DurationBeforeOrAfterCourseCompletion expected = new DurationBeforeOrAfterCourseCompletion(0, -3);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateDaysAndHoursAfterCourseCompletionBoarderValueWithNextDay() {
        LocalDateTime currentDate = LocalDateTime.of(2022, Month.FEBRUARY, 5, 10, 0);
        LocalDateTime startDate = LocalDateTime.of(2022, Month.FEBRUARY, 4, 10, 0);
        int coursesDuration = 8;

        LocalDateTime endDate = DateOfCompletion.getCourseCompletionDate(startDate, coursesDuration);
        DurationBeforeOrAfterCourseCompletion actual = TimeBetweenDates.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, currentDate);
        DurationBeforeOrAfterCourseCompletion expected = new DurationBeforeOrAfterCourseCompletion(0, -16);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateDaysAndHoursAfterCourseCompletionBoarderValueWithSameDay() {
        LocalDateTime currentDate = LocalDateTime.of(2022, Month.FEBRUARY, 4, 18, 0);
        LocalDateTime startDate = LocalDateTime.of(2022, Month.FEBRUARY, 4, 10, 0);
        int coursesDuration = 8;

        LocalDateTime endDate = DateOfCompletion.getCourseCompletionDate(startDate, coursesDuration);
        DurationBeforeOrAfterCourseCompletion actual = TimeBetweenDates.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, currentDate);
        DurationBeforeOrAfterCourseCompletion expected = new DurationBeforeOrAfterCourseCompletion(0, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateDaysAndHoursAfterCourseCompletionBoarderValueOneHourLess() {
        LocalDateTime currentDate = LocalDateTime.of(2022, Month.FEBRUARY, 4, 18, 0);
        LocalDateTime startDate = LocalDateTime.of(2022, Month.FEBRUARY, 4, 10, 0);
        int coursesDuration = 7;

        LocalDateTime endDate = DateOfCompletion.getCourseCompletionDate(startDate, coursesDuration);
        DurationBeforeOrAfterCourseCompletion actual = TimeBetweenDates.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, currentDate);
        DurationBeforeOrAfterCourseCompletion expected = new DurationBeforeOrAfterCourseCompletion(0, -1);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateDaysAndHoursAfterCourseCompletionWithNextDay() {
        LocalDateTime currentDate = LocalDateTime.of(2022, Month.FEBRUARY, 3, 18, 0);
        LocalDateTime startDate = LocalDateTime.of(2022, Month.FEBRUARY, 4, 10, 0);
        int coursesDuration = 8;

        LocalDateTime endDate = DateOfCompletion.getCourseCompletionDate(startDate, coursesDuration);
        DurationBeforeOrAfterCourseCompletion actual = TimeBetweenDates.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, currentDate);
        DurationBeforeOrAfterCourseCompletion expected = new DurationBeforeOrAfterCourseCompletion(1, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateDaysAndHoursAfterCourseCompletionUsingLocalDateWhenCourseDividesWithoutRemainder() {
        LocalDateTime startDate = LocalDateTime.of(2022, Month.FEBRUARY, 4, 10, 0);
        int coursesDuration = 64;

        LocalDateTime endDate = DateOfCompletion.getCourseCompletionDate(startDate, coursesDuration);
        DurationBeforeOrAfterCourseCompletion actual = TimeBetweenDates.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, currentDate);
        DurationBeforeOrAfterCourseCompletion expected = new DurationBeforeOrAfterCourseCompletion(-14, -21);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateDaysAndHoursAfterCourseCompletionUsingLocalDateWhenCourseDividesWithRemainder() {
        LocalDateTime startDate = LocalDateTime.of(2022, Month.FEBRUARY, 21, 10, 0);
        int coursesDuration = 30;

        LocalDateTime endDate = DateOfCompletion.getCourseCompletionDate(startDate, coursesDuration);
        DurationBeforeOrAfterCourseCompletion actual = TimeBetweenDates.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, currentDate);
        DurationBeforeOrAfterCourseCompletion expected = new DurationBeforeOrAfterCourseCompletion(-5, -23);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateDaysAndHoursAfterCourseCompletionUsingLocalDateWhenCourseDividesWithoutRemainderBoarderValue() {
        LocalDateTime startDate = LocalDateTime.of(2022, Month.FEBRUARY, 18, 10, 0);
        int coursesDuration = 64;

        LocalDateTime endDate = DateOfCompletion.getCourseCompletionDate(startDate, coursesDuration);
        DurationBeforeOrAfterCourseCompletion actual = TimeBetweenDates.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, currentDate);
        DurationBeforeOrAfterCourseCompletion expected = new DurationBeforeOrAfterCourseCompletion(0, -21);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateDaysAndHoursAfterCourseCompletionUsingLocalDateUsingTaskCondition() {
        LocalDateTime startDate = LocalDateTime.of(2022, Month.FEBRUARY, 4, 10, 0);
        int coursesDuration = 42;

        LocalDateTime endDate = DateOfCompletion.getCourseCompletionDate(startDate, coursesDuration);
        DurationBeforeOrAfterCourseCompletion actual = TimeBetweenDates.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, currentDate);
        DurationBeforeOrAfterCourseCompletion expected = new DurationBeforeOrAfterCourseCompletion(-19, -3);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateDaysAndHoursBeforeCourseCompletionUsingLocalDateWhenCourseDividesWithoutRemainderBoarderValue() {
        LocalDateTime startDate = LocalDateTime.of(2022, Month.FEBRUARY, 21, 10, 0);
        int coursesDuration = 64;

        LocalDateTime endDate = DateOfCompletion.getCourseCompletionDate(startDate, coursesDuration);
        DurationBeforeOrAfterCourseCompletion actual = TimeBetweenDates.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, currentDate);
        DurationBeforeOrAfterCourseCompletion expected = new DurationBeforeOrAfterCourseCompletion(0, 3);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateDaysAndHoursBeforeCourseCompletionUsingLocalDateWhenCourseDividesWithRemainder() {
        LocalDateTime startDate = LocalDateTime.of(2022, Month.FEBRUARY, 28, 10, 0);
        int coursesDuration = 30;

        LocalDateTime endDate = DateOfCompletion.getCourseCompletionDate(startDate, coursesDuration);
        DurationBeforeOrAfterCourseCompletion actual = TimeBetweenDates.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, currentDate);
        DurationBeforeOrAfterCourseCompletion expected = new DurationBeforeOrAfterCourseCompletion(1, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateDaysAndHoursBeforeCourseCompletionUsingLocalDateWhenCourseDividesWithRemainderWithWeekendAfter() {
        LocalDateTime startDate = LocalDateTime.of(2022, Month.MARCH, 4, 10, 0);
        int coursesDuration = 30;

        LocalDateTime endDate = DateOfCompletion.getCourseCompletionDate(startDate, coursesDuration);
        DurationBeforeOrAfterCourseCompletion actual = TimeBetweenDates.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, currentDate);
        DurationBeforeOrAfterCourseCompletion expected = new DurationBeforeOrAfterCourseCompletion(7, 1);
        assertEquals(expected, actual);
    }
}