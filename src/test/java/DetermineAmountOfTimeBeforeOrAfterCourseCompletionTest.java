import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class DetermineAmountOfTimeBeforeOrAfterCourseCompletionTest {

    @Test
    public void shouldDetermineEndDateWhenCourseEndsAt6PM() {
        LocalDate startDate = LocalDate.of(2022, Month.FEBRUARY, 4);
        int coursesDuration = 64;

        LocalDate actual = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        LocalDate expected = LocalDate.of(2022, Month.FEBRUARY, 15);
        expected.atTime(18, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldDetermineEndDateWhenCourseEndsDuringWorkingDay() {
        LocalDate startDate = LocalDate.of(2022, Month.FEBRUARY, 18);
        int coursesDuration = 30;

        LocalDate actual = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        LocalDate expected = LocalDate.of(2022, Month.FEBRUARY, 23);
        expected.atTime(16, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateDaysAndHoursAfterCourseCompletionUsingLocalDate1() {
        LocalDate startDate = LocalDate.of(2022, Month.FEBRUARY, 4);
        int coursesDuration = 64;

        LocalDate endDate = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        ArrayList<Integer> actual = AmountOfTimeBeforeOrAfterCourseCompletion.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, coursesDuration);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(9);
        expected.add(3);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateDaysAndHoursAfterCourseCompletionUsingLocalDate2() {
        LocalDate startDate = LocalDate.of(2022, Month.FEBRUARY, 4);
        int coursesDuration = 30;

        LocalDate endDate = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        ArrayList<Integer> actual = AmountOfTimeBeforeOrAfterCourseCompletion.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, coursesDuration);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(15);
        expected.add(5);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateDaysAndHoursBeforeCourseCompletionUsingLocalDate1() {
        LocalDate startDate = LocalDate.of(2022, Month.FEBRUARY, 16);
        int coursesDuration = 64;

        LocalDate endDate = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        ArrayList<Integer> actual = AmountOfTimeBeforeOrAfterCourseCompletion.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, coursesDuration);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(5);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateDaysAndHoursBeforeCourseCompletionUsingLocalDate2() {
        LocalDate startDate = LocalDate.of(2022, Month.FEBRUARY, 21);
        int coursesDuration = 30;

        LocalDate endDate = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        ArrayList<Integer> actual = AmountOfTimeBeforeOrAfterCourseCompletion.calculateAmountOfTimeBeforeOrAfterCourseCompletion(endDate, coursesDuration);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(5);
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