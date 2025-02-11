package LogBook.Week3;

public class Main {
    public static void main(String[] args)
    {
        Student student = new Student(10011,"James", "smith");
        System.out.println(student.get_id());
        System.out.println(student.get_first_name());
        System.out.println(student.get_last_name());
        student.set_first_name("Bob");
        System.out.println(student.get_first_name());
    }
}
