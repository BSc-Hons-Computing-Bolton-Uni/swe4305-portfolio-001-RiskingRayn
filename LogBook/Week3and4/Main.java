package LogBook.Week3and4;

public class Main {
    public static void main(String[] args)
    {
        Course course = new Course("wb232d","Bob");
        Student student = new Student(10011,"James", "smith");
        student.enrol(course);
        student.print_values();
    }
}
