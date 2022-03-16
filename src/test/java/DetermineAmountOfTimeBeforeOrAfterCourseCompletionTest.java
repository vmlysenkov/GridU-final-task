import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class DetermineAmountOfTimeBeforeOrAfterCourseCompletionTest {
    LocalDateTime currentDate = LocalDateTime.of(2022, Month.MARCH, 2, 15, 0);

    @Test
    public void shouldCalculateDaysAndHoursAfterCourseCompletionUsingLocalDateWhenCourseDividesWithoutRemainder() {
        LocalDateTime startDate = LocalDateTime.of(2022, Month.FEBRUARY, 4, 10, 0);
        int coursesDuration = 64;

        LocalDateTime endDate = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        DurationBeforeOrAfterCourseCompletion actual = AmountOfTimeBeforeOrAfterCourseCompletion.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, currentDate, coursesDuration);
        DurationBeforeOrAfterCourseCompletion expected = new DurationBeforeOrAfterCourseCompletion(-14, -5);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateDaysAndHoursAfterCourseCompletionUsingLocalDateWhenCourseDividesWithRemainder() {
        LocalDateTime startDate = LocalDateTime.of(2022, Month.FEBRUARY, 21, 10, 0);
        int coursesDuration = 30;

        LocalDateTime endDate = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        DurationBeforeOrAfterCourseCompletion actual = AmountOfTimeBeforeOrAfterCourseCompletion.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, currentDate, coursesDuration);
        DurationBeforeOrAfterCourseCompletion expected = new DurationBeforeOrAfterCourseCompletion(-5, -7);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateDaysAndHoursAfterCourseCompletionUsingLocalDateWhenCourseDividesWithoutRemainderBoarderValue() {
        LocalDateTime startDate = LocalDateTime.of(2022, Month.FEBRUARY, 18, 10, 0);
        int coursesDuration = 64;

        LocalDateTime endDate = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        DurationBeforeOrAfterCourseCompletion actual = AmountOfTimeBeforeOrAfterCourseCompletion.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, currentDate, coursesDuration);
        DurationBeforeOrAfterCourseCompletion expected = new DurationBeforeOrAfterCourseCompletion(0, -5);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateDaysAndHoursAfterCourseCompletionUsingLocalDateUsingTaskCondition() {
        LocalDateTime startDate = LocalDateTime.of(2022, Month.FEBRUARY, 4, 10, 0);
        int coursesDuration = 42;

        LocalDateTime endDate = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        DurationBeforeOrAfterCourseCompletion actual = AmountOfTimeBeforeOrAfterCourseCompletion.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, currentDate, coursesDuration);
        DurationBeforeOrAfterCourseCompletion expected = new DurationBeforeOrAfterCourseCompletion(-19, -3);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateDaysAndHoursBeforeCourseCompletionUsingLocalDateWhenCourseDividesWithoutRemainderBoarderValue() {
        LocalDateTime startDate = LocalDateTime.of(2022, Month.FEBRUARY, 21, 10, 0);
        int coursesDuration = 64;

        LocalDateTime endDate = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        DurationBeforeOrAfterCourseCompletion actual = AmountOfTimeBeforeOrAfterCourseCompletion.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, currentDate, coursesDuration);
        DurationBeforeOrAfterCourseCompletion expected = new DurationBeforeOrAfterCourseCompletion(0, 3);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateDaysAndHoursBeforeCourseCompletionUsingLocalDateWhenCourseDividesWithRemainder() {
        LocalDateTime startDate = LocalDateTime.of(2022, Month.FEBRUARY, 28, 10, 0);
        int coursesDuration = 30;

        LocalDateTime endDate = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        DurationBeforeOrAfterCourseCompletion actual = AmountOfTimeBeforeOrAfterCourseCompletion.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, currentDate, coursesDuration);
        DurationBeforeOrAfterCourseCompletion expected = new DurationBeforeOrAfterCourseCompletion(1, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateDaysAndHoursBeforeCourseCompletionUsingLocalDateWhenCourseDividesWithRemainderWithWeekendAfter() {
        LocalDateTime startDate = LocalDateTime.of(2022, Month.MARCH, 4, 10, 0);
        int coursesDuration = 30;

        LocalDateTime endDate = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        DurationBeforeOrAfterCourseCompletion actual = AmountOfTimeBeforeOrAfterCourseCompletion.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, currentDate, coursesDuration);
        DurationBeforeOrAfterCourseCompletion expected = new DurationBeforeOrAfterCourseCompletion(7, 1);
        assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void dateTest1() {
        Calendar startDate = new GregorianCalendar(2022, Calendar.FEBRUARY, 4);
        int coursesDuration = 64;

        Calendar actual = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        Calendar expected = new GregorianCalendar(2022, Calendar.FEBRUARY, 15);
        expected.set(Calendar.HOUR_OF_DAY, 18);

        assertEquals(expected.getTime(), actual.getTime());
    }

    @Ignore
    @Test
    public void dateTest2() {
        Calendar startDate = new GregorianCalendar(2022, Calendar.FEBRUARY, 18);
        int coursesDuration = 30;

        Calendar actual = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        Calendar expected = new GregorianCalendar(2022, 1, 23);
        expected.set(Calendar.HOUR_OF_DAY, 16);

        assertEquals(expected.getTime(), actual.getTime());
    }

    @Ignore
    @Test
    public void shouldCalculateDaysAndHoursAfterCourseCompletion1() {
        Calendar startDate = new GregorianCalendar(2022, Calendar.FEBRUARY, 4);
        int coursesDuration = 64;

        Calendar endDate = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        ArrayList<Integer> actual = AmountOfTimeBeforeOrAfterCourseCompletion.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, coursesDuration);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(6);
        expected.add(7);
        assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void shouldCalculateDaysAndHoursAfterCourseCompletion2() {
        Calendar startDate = new GregorianCalendar(2022, Calendar.FEBRUARY, 4);
        int coursesDuration = 30;

        Calendar endDate = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        ArrayList<Integer> actual = AmountOfTimeBeforeOrAfterCourseCompletion.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, coursesDuration);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(12);
        expected.add(9);
        assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void shouldCalculateDaysAndHoursBeforeCourseCompletion1() {
        Calendar startDate = new GregorianCalendar(2022, Calendar.FEBRUARY, 16);
        int coursesDuration = 64;

        Calendar endDate = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        ArrayList<Integer> actual = AmountOfTimeBeforeOrAfterCourseCompletion.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, coursesDuration);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(1);
        assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void shouldCalculateDaysAndHoursBeforeCourseCompletion2() {
        Calendar startDate = new GregorianCalendar(2022, Calendar.FEBRUARY, 21);
        int coursesDuration = 30;

        Calendar endDate = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        ArrayList<Integer> actual = AmountOfTimeBeforeOrAfterCourseCompletion.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, coursesDuration);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(7);
        assertEquals(expected, actual);
    }
}