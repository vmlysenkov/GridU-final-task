import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class CourseCompletion {

    private static int daysFromCourseCompletion = 0;
    private static int hoursFromCourseCompletion = 0;
    private static ArrayList<Integer> daysAndHoursAfterCourseCompletion = new ArrayList<>();
    private static int startWorkingHour = 10;
    private static int endWorkingHour = 18;

//    public CourseCompletion() {
//
//    }
//
//    public CourseCompletion(int daysFromCourseCompletion, int hoursFromCourseCompletion) {
//    }
//
//    @Override
//    public String toString() {
//        return "CourseCompletion{}";
//    }

    public static ArrayList<Integer> getTimeFromCourseCompletion(Calendar endDate, int coursesDuration) {
        Calendar currentDate = Calendar.getInstance();
        int hoursToday = currentDate.get(Calendar.HOUR_OF_DAY);
        System.out.println(currentDate.get(Calendar.HOUR_OF_DAY));
        System.out.println(currentDate.getTime());
        System.out.println(endDate.getTime());
        if (currentDate.getTimeInMillis() < endDate.getTimeInMillis()) {
            currentDate.setTime(endDate.getTime());
            endDate.setTime(currentDate.getTime());

        }
        if ((coursesDuration % DetermineCourseCompletion.workHoursPerDay) == 0) {
            do {
                currentDate.add(Calendar.DAY_OF_MONTH, -1);
                daysFromCourseCompletion++;
            } while (currentDate.getTimeInMillis() > endDate.getTimeInMillis());

        }
        if (hoursToday >= startWorkingHour && hoursToday <= endWorkingHour) {
            hoursFromCourseCompletion = hoursToday - startWorkingHour;
            daysFromCourseCompletion--;
        } else {
            hoursFromCourseCompletion = 0;
        }

        daysAndHoursAfterCourseCompletion.add(daysFromCourseCompletion);
        daysAndHoursAfterCourseCompletion.add(hoursFromCourseCompletion);

//        if ((coursesDuration % DetermineCourseCompletion.workHoursPerDay) != 0) {
//            endDate.add(Calendar.DAY_OF_WEEK, -1);
//            Calendar currentDate = Calendar.getInstance();
//            long daysFromCourseCompletion = TimeUnit.MILLISECONDS.toDays(Math.abs(currentDate.getTimeInMillis() - endDate.getTimeInMillis()));
//            long hoursFromCourseCompletion = coursesDuration % DetermineCourseCompletion.workHoursPerDay;


//        } else {
//            Calendar currentDate = Calendar.getInstance();
//            long daysFromCourseCompletion = TimeUnit.MILLISECONDS.toDays(Math.abs(currentDate.getTimeInMillis() - endDate.getTimeInMillis()));
//            long hoursFromCourseCompletion = 0;
//        }
        return daysAndHoursAfterCourseCompletion;
        //return new CourseCompletion(daysFromCourseCompletion, hoursFromCourseCompletion);
    }
}
//, int coursesDuration