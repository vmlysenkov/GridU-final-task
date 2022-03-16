import lombok.Value;

@Value
public class DurationBeforeOrAfterCourseCompletion {
    int days;
    int hours;

    public DurationBeforeOrAfterCourseCompletion(int days, int hours) {
        this.days = days;
        this.hours = hours;
    }
}
