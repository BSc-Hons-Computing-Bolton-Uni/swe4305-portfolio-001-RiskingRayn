package MarkApp;

import java.util.ArrayList;

public class Student {
    String name;
    int age;
    ArrayList<Grade> grades = new ArrayList<Grade>();
    ArrayList<Module> modules = new ArrayList<Module>();

    public Student(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    // setters
    public void set_name(String name)
        {this.name = name;}
    public void set_age (int age)
        {this.age = age;}
    public void add_grade(Grade grade)
        {this.grades.add(grade);}
    public void add_module(Module module)
        {this.modules.add(module);}

    // gettser
    public String get_name()
        {return this.name;}
    public int get_age()
        {return this.age;}
    public ArrayList<Grade> get_grades()
        {return this.grades;}
    public ArrayList<Module> get_modules()
        {return this.modules;}

    public void print_all()
        {
            System.out.println("name: " + this.name);
            System.out.println("age: "+ this.age);
            System.out.println("grades: ");
            for (Grade grade : this.grades)
                {
                    grade.print_all();
                }
            System.out.println("enroled modules: ");
            for (Module module : this.modules)
                {module.print_all();}
        }


    // add up all the marks in the ArrayList and devides them by the amout to get the avrage.
    public int calculate_avrage_mark()
    {
        int t_mark = 0;
        int count = 0;
        for (Grade grade : this.grades)
        {
            t_mark+= grade.get_mark();
            count +=1;
        }
        int avrage = t_mark/count;
        return avrage;
    }

}
