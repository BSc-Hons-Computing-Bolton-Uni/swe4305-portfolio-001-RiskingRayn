package LogBook.Week5;

public class Product {
    private int id;
    private String name;
    private int quantity;

    // constructer
    Product (int id , String name, int quantity)
    {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    // getters

    public int get_id()
        {return this.id;}

    public String get_name()
        {return this.name;}

    public int get_quantity()
        {return this.quantity;}

    //Setters

    public void set_id(int id)
        {this.id = id;}

    public void set_name(String name)
        {this.name = name;}

    public void set_quantity(int quantity)
        {this.quantity = quantity;}

    //console print values

    public void print_id()
        {System.out.println(this.id);}

    public void print_name()
        {System.out.println(this.name);}

    public void print_quantity()
        {System.out.println(this.quantity);}

    // console print all values.

    public void  print_all_values()
    {
        System.out.println("Product name: " + this.name);
        System.out.println("Product ID: " + this.id);
        System.out.println("Product quantity: " + this.quantity);
    }
}
