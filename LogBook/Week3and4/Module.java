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

    public Grades  get_grads_from_marks(int mark)
    {

        Grades grade = Grades.INVALID_MARK;
        if (mark > 85 && mark <= 100 )
            grade = Grades.A;
        else if (mark > 75)
            grade = Grades.B;
        else if (mark > 65)
            grade = Grades.C;
        else if (mark > 50)
            grade = Grades.D;
        else if (mark > 40)
            grade = Grades.E;
        else if (mark >= 0)
            grade = Grades.F;
        return grade;
    }

    public void print_values()
    {
        System.out.println("Module name is " + this.name);
        System.out.println("Module code is " + this.code);
    }

}
