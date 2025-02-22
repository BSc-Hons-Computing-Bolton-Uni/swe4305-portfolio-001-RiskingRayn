package LogBook.Week3and4;

import java.util.ArrayList;

public class Course {
    //course atributes.
    public String course_code;
    public String course_name;
    public ArrayList<Module> modules;

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
//      prints out all of the atributes in Course.
    //  this prossess uses the Module prosses print values to print the
    //  Module values.
    public void print_values()
    {
        System.out.println("the course code is " + this.course_code);
        System.out.println("the course name is " + this.course_name);
        for(Module module: this.modules)
            module.print_values();
    }

    // the constructer
    //uses temp as a placeholder value just to put the modules into module.
    Course(String course_code, String course_name)
    {
        this.course_code = course_code;
        this.course_name = course_name;
        ArrayList<Module> temp= new ArrayList<Module>();
        temp.add(new Module("networking","SW1TAK"));
        temp.add(new Module("programming", "SW2TAK"));
        temp.add(new Module("Computing fundamentals", "SW3TAK"));
        temp.add(new Module("Maths", "SW4TAK"));
        this.modules = temp;
    }




}
