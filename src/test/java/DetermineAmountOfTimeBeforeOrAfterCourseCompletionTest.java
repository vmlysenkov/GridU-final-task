import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class DetermineAmountOfTimeBeforeOrAfterCourseCompletionTest {

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
    public void shouldCalculateDaysAndHoursAfterCourseCompletionUsingLocalDate1() {
        LocalDateTime startDate = LocalDateTime.of(2022, Month.FEBRUARY, 4, 10, 0);
        int coursesDuration = 64;

        LocalDateTime endDate = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        ArrayList<Integer> actual = AmountOfTimeBeforeOrAfterCourseCompletion.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, coursesDuration);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(-14);
        expected.add(-5);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateDaysAndHoursAfterCourseCompletionUsingLocalDate2() {
        LocalDateTime startDate = LocalDateTime.of(2022, Month.FEBRUARY, 21, 10, 0);
        int coursesDuration = 30;

        LocalDateTime endDate = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        ArrayList<Integer> actual = AmountOfTimeBeforeOrAfterCourseCompletion.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, coursesDuration);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(-5);
        expected.add(-7);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateDaysAndHoursAfterCourseCompletionUsingLocalDate3() {
        LocalDateTime startDate = LocalDateTime.of(2022, Month.FEBRUARY, 18, 10, 0);
        int coursesDuration = 64;

        LocalDateTime endDate = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        ArrayList<Integer> actual = AmountOfTimeBeforeOrAfterCourseCompletion.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, coursesDuration);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(-5);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateDaysAndHoursBeforeCourseCompletionUsingLocalDate1() {
        LocalDateTime startDate = LocalDateTime.of(2022, Month.FEBRUARY, 21, 10, 0);
        int coursesDuration = 64;

        LocalDateTime endDate = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        ArrayList<Integer> actual = AmountOfTimeBeforeOrAfterCourseCompletion.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, coursesDuration);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(3);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateDaysAndHoursBeforeCourseCompletionUsingLocalDate2() {
        LocalDateTime startDate = LocalDateTime.of(2022, Month.FEBRUARY, 28, 10, 0);
        int coursesDuration = 30;

        LocalDateTime endDate = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        ArrayList<Integer> actual = AmountOfTimeBeforeOrAfterCourseCompletion.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, coursesDuration);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(1);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateDaysAndHoursBeforeCourseCompletionUsingLocalDate3() {
        LocalDateTime startDate = LocalDateTime.of(2022, Month.MARCH, 4, 10, 0);
        int coursesDuration = 30;

        LocalDateTime endDate = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        ArrayList<Integer> actual = AmountOfTimeBeforeOrAfterCourseCompletion.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, coursesDuration);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(7);
        expected.add(1);
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