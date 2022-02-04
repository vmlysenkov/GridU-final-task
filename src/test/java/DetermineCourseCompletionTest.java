import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class DetermineCourseCompletionTest {
    @Test
    public void dateTest1(){
        Calendar startDate = new GregorianCalendar(2022, 1, 4);
        int coursesDuration = 64;

        Calendar actual = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        Calendar expected = new GregorianCalendar(2022, 1, 15);

        assertEquals(expected.getTime(), actual.getTime());
    }
    @Test
    public void dateTest2(){
        Calendar startDate = new GregorianCalendar(2022, 1, 7);
        int coursesDuration = 30;

        Calendar actual = DetermineCourseCompletion.getCourseCompletionDate(startDate, coursesDuration);
        Calendar expected = new GregorianCalendar(2022, 1, 10);

        assertEquals(expected.getTime(), actual.getTime());
    }

}