package LogBook.Week3and4;

import java.util.Scanner;

public class Module {
    //class atributes.
    private String name;
    private String code;

    // the constructer adding the atributes name and code.
    public Module(String name, String code)
    {
        this.code = code;
        this.name = name;
    }

    public String get_grads_from_marks(int mark)
    {
        String grade;
        if (mark > 100)
            grade = "Invalid grade";
        else if (mark >= 85)
            grade = "A*";
        else if (mark >= 75)
            grade = "A";
        else if (mark >= 65)
            grade = "B";
        else if (mark >= 55)
            grade = "C";
        else if (mark >= 40)
            grade = "D";
        else if (mark >= 0)
            grade = "f";
        else grade = "Invalid grade";
        return grade;
    }

    public void print_values()
    {
        System.out.println("Module name is " + this.name);
        System.out.println("Module code is " + this.code);
    }

}
