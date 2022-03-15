import java.util.Objects;

public class DurationBeforeOrAfterCourseCompletion {
    int days;
    int hours;

    public DurationBeforeOrAfterCourseCompletion(int days, int hours) {
        this.days = days;
        this.hours = hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DurationBeforeOrAfterCourseCompletion that = (DurationBeforeOrAfterCourseCompletion) o;
        return days == that.days && hours == that.hours;
    }

    @Override
    public int hashCode() {
        return Objects.hash(days, hours);
    }

    @Override
    public String toString() {
        return "DurationBeforeOrAfterCourseCompletion{" +
                "days=" + days +
                ", hours=" + hours +
                '}';
    }
}
