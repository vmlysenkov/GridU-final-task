import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class DetermineCourseCompletionTest {
    @Test
    public void dateTest1() {
        Calendar startDate = new GregorianCalendar(2022, 0, 27);
        int coursesDuration = 64;

        Calendar actual = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        Calendar expected = new GregorianCalendar(2022, 1, 7);
        expected.set(Calendar.HOUR_OF_DAY, 18);

        assertEquals(expected.getTime(), actual.getTime());
    }

    @Test
    public void dateTest2() {
        Calendar startDate = new GregorianCalendar(2022, 1, 18);
        int coursesDuration = 30;

        Calendar actual = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        Calendar expected = new GregorianCalendar(2022, 1, 23);
        expected.set(Calendar.HOUR_OF_DAY, 16);

        assertEquals(expected.getTime(), actual.getTime());
    }

    @Test
    public void shouldCalculateDaysAndHoursAfterCourseCompletion1() {
        Calendar startDate = new GregorianCalendar(2022, 1, 7);
        int coursesDuration = 64;

        Calendar endDate = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        ArrayList<Integer> actual = CourseCompletion.getTimeFromCourseCompletion(endDate, coursesDuration);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(0);
        assertEquals(actual, expected);
    }

    @Test
    public void shouldCalculateDaysAndHoursAfterCourseCompletion2() {
        Calendar startDate = new GregorianCalendar(2022, 1, 14);
        int coursesDuration = 30;

        Calendar endDate = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        ArrayList<Integer> actual = CourseCompletion.getTimeFromCourseCompletion(endDate, coursesDuration);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(2);
        assertEquals(expected, actual);
    }
}