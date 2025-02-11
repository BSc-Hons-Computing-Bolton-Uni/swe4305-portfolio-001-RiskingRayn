package LogBook.Week3;

public class Student
{
    private int id;
    private String first_name ;
    private String last_name ;
    private Course course;

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

    public void print_values ()
    {
        System.out.println("id " + this.id);
        System.out.println("first name " + this.first_name);
        System.out.println("last name " + this.last_name);
        this.course.print_values();
    }

    Student(int id, String first_name, String last_name, Course course )
    {
            this.id = id;
            this.first_name = first_name;
            this.last_name = last_name;
            this.course = course;
    }


}
