import java.util.ArrayList;

public class Curriculum {

    ArrayList<CourseData> curriculum = new ArrayList<>();
    public void addCourse(CourseData courseData) {
       curriculum.add(courseData);
    }

    public int getDuration() {
        return curriculum.stream().mapToInt(d -> d.duration).sum();
    }
}
