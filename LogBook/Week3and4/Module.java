package LogBook.Week3and4;

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

    public void print_values()
    {
        System.out.println("Module name is " + this.name);
        System.out.println("Module code is " + this.code);
    }

}
