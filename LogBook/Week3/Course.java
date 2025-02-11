package LogBook.Week3;

public class Course {
    public String course_code;
    public String course_name;

    public String get_course_code(String course_code)
    {
        return this.course_code;
    }

    public String get_course_name(String course_name)
    {
        return this.course_name;
    }

    public void set_course_code(String course_code)
    {
        this.course_code = course_code;
    }

    public void set_course_name(String course_name)
    {
        this.course_name = course_name;
    }

    public void print_values()
    {
        System.out.println("the course code is " + this.course_code);
        System.out.println("the course name is " + this.course_name);
    }

    Course(String course_code, String course_name)
    {
        this.course_code = course_code;
        this.course_name = course_name;
    }




}
