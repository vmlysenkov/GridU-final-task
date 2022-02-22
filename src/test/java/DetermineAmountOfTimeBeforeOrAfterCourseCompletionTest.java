import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class DetermineAmountOfTimeBeforeOrAfterCourseCompletionTest {
    @Test
    public void dateTest1() {
        Calendar startDate = new GregorianCalendar(2022, Calendar.FEBRUARY, 4);
        int coursesDuration = 64;

        Calendar actual = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        Calendar expected = new GregorianCalendar(2022, Calendar.FEBRUARY, 15);
        expected.set(Calendar.HOUR_OF_DAY, 18);

        assertEquals(expected.getTime(), actual.getTime());
    }

    @Test
    public void dateTest2() {
        Calendar startDate = new GregorianCalendar(2022, Calendar.FEBRUARY, 18);
        int coursesDuration = 30;

        Calendar actual = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        Calendar expected = new GregorianCalendar(2022, 1, 23);
        expected.set(Calendar.HOUR_OF_DAY, 16);

        assertEquals(expected.getTime(), actual.getTime());
    }

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