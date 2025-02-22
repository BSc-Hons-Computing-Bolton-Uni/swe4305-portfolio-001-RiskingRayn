package LogBook.Week3and4;

import java.util.ArrayList;
import java.util.Random;

public class Student {
    // defantion of class atributes.
    private int id;
    private String first_name;
    private String last_name;
    private Course course;
    private int[] marks;

    // getters and setter defonition.
    public int get_id ()
        {return this.id;}

    public String get_first_name()
        {return this.first_name;}

    public String get_last_name()
        {return this.last_name; }

    public void set_id (int new_id)
        {this.id = new_id;}

    public void  set_first_name (String new_first_name)
        {this.first_name = new_first_name;}

    public void set_last_name (String new_last_name)
        {this.last_name = new_last_name;}

    // allows the student to be enroled on to a course.
    public void enrol(Course course)
        {this.course = course; }

    // this function simpally prints all the class atributes to the console
    // it printo the course values as well using the course.print_values.
    public void print_values ()
    {
        System.out.println("id " + this.id);
        System.out.println("first name " + this.first_name);
        System.out.println("last name " + this.last_name);
        this.course.print_values();
        int count = 0;
        String[] grades = this.course.get_grades(this.marks);
        for (int mark: this.marks)
        {
            System.out.println("mark " + mark);
            System.out.println(grades[count]);
            count+=1;
        }

    }

        /* Allowing all the atributes to be passed through to the Student on creation.
        * the course atribute is not needed to be passed however it can be if needed
        * the first initaliser will catch it if it is not there and the second
        * one will catch it if it is there.*/

    public Student(int id, String first_name, String last_name)
    {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        Random random = new Random();
        int[]temp =
            {
                random.nextInt(100),
                random.nextInt(100),
                random.nextInt(100),
                random.nextInt(100)
            };
        this.marks = temp;
        this.course = null;
    }

    public Student(int id, String first_name, String last_name, Course course)
    {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        Random random = new Random();
        int[]temp =
            {
                random.nextInt(100),
                random.nextInt(100),
                random.nextInt(100),
                random.nextInt(100)
            };
        this.marks = temp;
        this.course = course;
    }

}
