package MarkApp;

public class Grade {
    int mark;
    String letter_grade;
    Module module = new Module();

    public Grade (int mark, Module module) {
        this.mark = mark;
        this.letter_grade = calculate_grade(mark);
        this.module = module;
    }

    // setters

    public void set_letter_grade(String grade)
        {this.letter_grade = grade;}
    public void  set_mark(int mark)
        {this.mark = mark;}
    public void set_module(Module module)
        {this.module = module;}

    // getters
    public String get_letter_grade()
        {return this.letter_grade;}
    public int get_mark()
        {return this.mark;}
    public Module get_module()
        {return this.module;}

    public void print_all()
    {
        System.out.println("letter grade: " + this.letter_grade);
        System.out.println("mark: " + this.mark);
        this.module.print_all();
    }

    private String calculate_grade (int mark){
        String grade;
        if (mark < 69)
            {grade ="A";}
        else if (mark < 59)
            {grade = "B";}
        else if (mark < 49)
            {grade = "C";}
        else if (mark < 39)
            {grade = "C";}
        else
            {grade = "F";}
        return grade;
    }
    public boolean chek_mark_valid(int mark){
        if (mark >= 0 && mark <= 100)
        {return true;}
        else
        {return false;}

    }
}
