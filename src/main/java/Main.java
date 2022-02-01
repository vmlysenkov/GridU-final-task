public class Main {
    public static void main(String[] args) {
        StudentData student1 = new StudentData("Ivanov Ivan", "Java Developer");
        String student1StartDate = student1.getDate(2020, 5, 1);
        student1.courseAndDuration.put("Java", 16);
        student1.courseAndDuration.put("JDBC", 24);
        student1.courseAndDuration.put("Spring", 16);
        System.out.println(student1);
        System.out.println(student1StartDate);
        System.out.println(student1.courseAndDuration);
        System.out.println();

        StudentData student2 = new StudentData("Sidorov Ivan", "AQE");
        String student2StartDate = student2.getDate(2020, 5, 1);
        student2.courseAndDuration.put("Test design", 10);
        student2.courseAndDuration.put("Page Object", 16);
        student2.courseAndDuration.put("Selenium", 16);
        System.out.println(student2);
        System.out.println(student2StartDate);
        System.out.println(student2.courseAndDuration);
    }
}
