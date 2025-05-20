package MarkApp;

public class Module {
    String module_code;
    String module_name;

    public Module (String name, String code)
    {
        this.module_code = code;
        this.module_name = name;
    }

    public Module ()
    {
        this.module_name = "";
        this.module_code = "";
    }

    //setters
    public void set_module_name(String name )
        {this.module_name = name;}
    public void set_module_code(String code )
        { this.module_code = code;}

    //getters
    public String get_module_name()
        {return this.module_name;}
    public String get_module_code()
        {return this.module_code;}

    public void print_all()
    {
        System.out.println("module name: " + this.module_name);
        System.out.println("module code: " + this.module_code);
    }

    public boolean check_null()
    {
        if (this.module_name == "" && this.module_code == "")
            {return true;}
        else
            {return false;}
    }
}
