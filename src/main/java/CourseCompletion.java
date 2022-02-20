import java.util.ArrayList;
import java.util.Calendar;

public class CourseCompletion {
    public static int startWorkingHour = 10;
    public static int endWorkingHour = 18;

    public static ArrayList<Integer> getTimeFromCourseCompletion(Calendar endDate, int coursesDuration) {
        ArrayList<Integer> daysAndHoursAfterCourseCompletion = new ArrayList<>();
        int daysFromCourseCompletion = 0;
        int hoursFromCourseCompletion = 0;
        endDate.set(Calendar.HOUR_OF_DAY, 24);
        Calendar currentDate = Calendar.getInstance();
        int hoursToday = currentDate.get(Calendar.HOUR_OF_DAY);
        System.out.println(currentDate.get(Calendar.HOUR_OF_DAY));
        System.out.println(currentDate.get(Calendar.DAY_OF_WEEK));
        System.out.println(currentDate.getTime());
        System.out.println(endDate.getTime());
        if (currentDate.getTimeInMillis() > endDate.getTimeInMillis()) {
            do {
                currentDate.add(Calendar.DAY_OF_MONTH, -1);
                daysFromCourseCompletion++;
            } while (currentDate.getTimeInMillis() > endDate.getTimeInMillis());

            if (hoursToday >= startWorkingHour && hoursToday <= endWorkingHour) {
                if (Calendar.getInstance().get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && Calendar.getInstance().get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                    hoursFromCourseCompletion = hoursToday - startWorkingHour;
                    daysFromCourseCompletion--;
                }
            } else {
                hoursFromCourseCompletion = 0;
            }
            if ((coursesDuration % DetermineCourseCompletion.workHoursPerDay) != 0) {
                hoursFromCourseCompletion = hoursFromCourseCompletion + endWorkingHour - (coursesDuration % DetermineCourseCompletion.workHoursPerDay + startWorkingHour);
            }
            daysAndHoursAfterCourseCompletion.add(daysFromCourseCompletion);
            daysAndHoursAfterCourseCompletion.add(hoursFromCourseCompletion);
        }
        return daysAndHoursAfterCourseCompletion;
    }
}