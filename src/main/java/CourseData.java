public class CourseData {
    String course;
    int duration;

    public CourseData(String course, int duration) {
        this.course = course;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "CourseData{" +
                "course='" + course + '\'' +
                ", duration=" + duration +
                '}';
    }
}
