package MarkApp;

import java.util.ArrayList;
import java.util.Scanner;

public class Menue {

    ArrayList<Grade> grades = new ArrayList<Grade>();
    ArrayList<Module> modules = new ArrayList<Module>();
    ArrayList<Student> students = new ArrayList<Student>();

    public Menue()
    {
        lode_values();
    }

    public void lode_values()
    {
        this.modules.add(new Module("Object Oriented Programming", "SWE4305"));
        this.modules.add(new Module("Maths for Computing","COM4301"));
        this.modules.add(new Module("Computer Science Fundamentals","COM4302"));
        this.modules.add(new Module("Computing Infrastructure","SWE4303"));
        this.modules.add(new Module("Databases","SWE4304"));
        this.modules.add(new Module("Systems Analysis and Design","SWE5306"));
        this.modules.add(new Module("Web Design and Programming","SWE5307"));
        this.modules.add(new Module("Cloud Technologies","SWE5308"));
        this.modules.add(new Module("Advanced Databases and Big Data","SWE5304"));
        this.modules.add(new Module("Advanced Operating Systems","SEC5304"));

        Student s1 = new Student("James", 19);
        s1.add_module(this.modules.get(2));
        s1.add_module(this.modules.get(5));
        s1.add_grade(new Grade(63, this.modules.get(2)));
        s1.add_grade(new Grade(57, this.modules.get(5)));
        this.students.add(s1);
        Student s2 = new Student("Bob", 21);
        s2.add_module(this.modules.get(3));
        s2.add_module(this.modules.get(1));
        s2.add_grade(new Grade(49, this.modules.get(3)));
        s2.add_grade(new Grade(91, this.modules.get(1)));
        this.students.add(s2);
        Student s3 = new Student("Jon", 19);
        s3.add_module(this.modules.get(4));
        s3.add_module(this.modules.get(5));
        s3.add_grade(new Grade(43, this.modules.get(4)));
        s3.add_grade(new Grade(67, this.modules.get(5)));
        this.students.add(s3);
    }

    private String check_ans_string(ArrayList<String> valid) {

        String ans = get_ans_string().replace(" ", "\\s");

        if (!valid.contains(ans)) {
            System.out.println("You need to enter one of the valid options. ");
            ans = check_ans_string(valid);
        }
        return ans;
    }

    private int check_ans_int(int p1, int p2)
        {
            int ans = get_ans_int();
            if (ans < p1 || ans > p2)
            {
                System.out.println("you need to enter a number between" + p1 +" and " + p2);
                ans = check_ans_int(p1,p2);
            }
            return ans;
        }


    // -----------------------------------------------------------------------------------|all user inputs|-------------------------------------------------------------------
    // get_ans_string gets a string anser from the user.
    // it error checks this to make sure that a string is input in the unlikley event that it is not.
    // this function will itarate itself until a valid anser is enterd
    private String get_ans_string() {
        Scanner scanner = new Scanner(System.in);
        String ans = "";
        try {
            ans = scanner.next();

        } catch (Exception e) {
            System.out.println("please enter enter a valid value");
            ans = get_ans_string();
        }
        if (ans.equals("")) {
            System.out.println("you must enter a something");
            ans = get_ans_string();
        }
        return ans;
    }

    // get_ans_float dose the same thing as get_ans_string but with a float insted
    private float get_ans_float() {
        Scanner scanner = new Scanner(System.in);
        float ans = -1;
        try {
            ans = scanner.nextFloat();

        } catch (Exception e) {
            System.out.println("please enter enter a valid value");
            ans = get_ans_float();
        }
        if (!(ans >= 0)) {
            System.out.println("you must enter a valid play count");
            ans = get_ans_float();
        }
        return ans;
    }

    // get_ans_float dose the same thing as get_ans_string but with an int insted
    private int get_ans_int() {
        Scanner scanner = new Scanner(System.in);
        int ans = -1;
        try {
            ans = scanner.nextInt();

        } catch (Exception e) {
            System.out.println("please enter enter a valid value");
            ans = get_ans_int();
        }
        if (!(ans >= 0)) {
            System.out.println("you must enter a valid play count");
            ans = get_ans_int();
        }
        return ans;
    }

    public void main_menue()
    {
        System.out.print(" enter the number of the option you want\n" +
                "1: add new student \n" +
                "2: add new module \n" +
                "3: inspect student\n"+
                "4: edit student\n" +
                "5: check module grades\n"
                );
        ArrayList<String> valid = new ArrayList<String>();
        valid.add("1");
        valid.add("2");
        valid.add("3");
        valid.add("4");
        valid.add("5");
        String ans = check_ans_string(valid);
        System.out.println(ans);
        if (ans.equals("1"))
            {add_new_student_menu();}
        else if (ans.equals("2"))
            {add_new_module_menu();}
        else if (ans.equals("3"))
            {inspect_student_menu();}
        else if (ans.equals("4"))
            {edit_student_menu();}
        else
            {;
            System.out.println("option 5");
            check_module_grades_menu();
            }
    }

    private void add_new_student_menu()
        {
            System.out.println("Enter the students name");
            String name = get_ans_string();
            System.out.println("Enter the students age");
            int age = get_ans_int();
            Student student = new Student(name, age);
            this.students.add(student);
            System.out.println("Student has been added.");

            System.out.println("Would you like to enroll this student to a module (y/n)");
            ArrayList<String> valid = new ArrayList<String>();
            valid.add("y");
            valid.add("n");
            String ans = check_ans_string(valid);
            if (ans.equals("y"))
                {enrole_student_menu();}
            else
            {
                main_menue();
            }
        }

    private void add_new_module_menu()
        {
            System.out.println("enter the module name: ");
            String name = get_ans_string();
            System.out.println("enter the module code: ");
            String code = get_ans_string();
            Module module = new Module(name, code);
            this.modules.add(module);
            System.out.println("the module has been added\n\n");
            main_menue();
        }

    private void inspect_student_menu()
        {
            Student student = find_student();
            student.print_all();
            main_menue();
        }

    private void edit_student_menu()
        {
            Student student = find_student();
            System.out.println("what would you like to edit about this student \n");
            System.out.print("1: add grade \n"+
                    "2: edit name \n"+
                    "3: edit age \n"+
                    "4: enroll on module \n"+
                    "5: remove student \n"
            );
            ArrayList<String> valid = new ArrayList<String>();
            valid.add("1");
            valid.add("2");
            valid.add("3");
            valid.add("4");
            valid.add("5");
            String ans = check_ans_string(valid);

            if (ans.equals("1"))
                {
                    System.out.println("enter the mark: ");
                    int mark = check_ans_int(0,100);
                    Module module = find_module();
                    Grade grade = new Grade(mark, module);
                    student.add_grade(grade);
                    System.out.println("grade added");
                }
            else if (ans.equals("2"))
                {
                    System.out.println("enter new name: ");
                    String name = get_ans_string();
                    student.set_name(name);
                    System.out.println("the name has been added");
                }
            else if (ans.equals("3"))
                {
                    System.out.println("enter the new age: ");
                    int age = get_ans_int();
                    student.set_age(age);
                    System.out.println("the age has been edited");
                }
            else if (ans.equals("4"))
                {
                    enrole_student_menu();
                }
            else
                {this.students.remove(student);
                System.out.println("student removed");
                }
            main_menue();
        }

    private void check_module_grades_menu()
        {
            Module module = find_module();
            ArrayList<Grade> module_grade = new ArrayList<Grade>();
            int total_mark = 0;
            int mark_amount =0;
            for (Student student : this.students)
            {
                ArrayList<Grade> grades = student.get_grades();
                for (Grade grade : grades)
                {
                    if (grade.get_module().get_module_name().equals(module.get_module_name()))
                    {
                        total_mark += grade.get_mark();
                        mark_amount += 1;
                    }
                }
            }
            float avrage = total_mark / mark_amount;
            System.out.println("the avrage for " + module.get_module_name() +" is " + avrage);
            main_menue();
        }

    private void enrole_student_menu()
        {
            Module module = find_module();
            Student student = find_student();
            student.add_module(module);
            System.out.println(student.get_name() + " is now enrolled on " + module.get_module_name());
            main_menue();
        }

    private Student find_student()
    {
        ArrayList<String> names = new ArrayList<String>(); //making sure onlt the existing students can be picked
        int count = -1;
        for (Student student : this.students)
        {
            names.add(student.get_name());
        }
        System.out.println("enter the name of the student");
        String name = check_ans_string(names);
        int index = 0;
        for (Student student : this.students) // finding the picked student.
        {
            count +=1;
            if (student.get_name().equals(name))
            {index = count;}
        }
        return this.students.get(index); // returning the picked student.
    }

    private Module find_module()
    {//making sure only the existing modules can be chosen
        ArrayList<String> module_codes = new ArrayList<String>();
        int count = -1;
        for (Module module : this.modules)
        {
            module_codes.add(module.get_module_code());
        }
        System.out.println("enter the module code");
        String code = check_ans_string(module_codes);

        int index = 0;
        for (Module module : this.modules) // finding the chosen module
        {
            count +=1;
            if (module.get_module_code().equals(code))
            {index = count;}
        }
        Module module = this.modules.get(index); // the picked module.
        return module;
    }

    private void show_all_students()
    {
        System.out.println("witch student would you like to inspect");
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> valid = new ArrayList<String>();
        int count = 0;
        for (Student student : this.students)
        {
            names.add(student.get_name());
            count +=1;
            System.out.println(count +": " + student.get_name());
            valid.add(String.valueOf(count));
        }
        String ans = check_ans_string(valid);
    }

}