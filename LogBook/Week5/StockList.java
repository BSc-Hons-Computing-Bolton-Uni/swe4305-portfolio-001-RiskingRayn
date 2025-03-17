package LogBook.Week5;

import java.util.ArrayList;


public class StockList {
    private ArrayList<Product> products = new ArrayList<Product>();

    /* making sure the list is orderd by id making it much simpler and faster to
     search fo a product in the list.
    *
    *
    * */

    private void add_to_product_list(Product product)
    {
        int size = this.products.size();
        if (this.products.isEmpty())
            {this.products.add(product);}
        else if (product.get_id() > (this.products.get(size-1)).get_id())
        {
           this.products.add(product);
        }
        else
        {
            int id = product.get_id();
            boolean found = false;
            int pointer = this.products.size()/2;
            int len = pointer;
            int current_id = 0 ;
            while (!found && len >= 1)
            {
                System.out.println("running ");
                Product current_product = this.products.get(pointer);
                current_id = current_product.get_id();
                if (current_id == id)
                    found =true;
                else
                {
                    pointer = len/2;
                    if (current_id < id)
                        pointer = pointer + len;
                    len = len/2;
                }
            }
            if (found)
                System.out.println("error id " + id + " is already in use");
            else
            {
                if (current_id > id)
                {
                    this.products.add(pointer, product);
                }
                else
                {
                    this.products.add(pointer, product);
                }
            }
        }
    }


    public void add_product(Product product)
        {add_to_product_list(product);}

    public void add_products(Product[] products)
    {
        for(Product p: products )
            {add_to_product_list(p);}
    }

    public void remove_product(Product product)
        {this.products.remove(product);}

    public void remove_products(Product[] products)
    {
        for(Product p: products)
            {this.products.remove(p);}
    }

    public Product find_product_with_name(String name)
    {
        int count = 0;
        Product product = null;
        for(Product p: this.products)
        {
            if((this.products.get(count).get_name() == name))
                {product = p;}
        }

        return product;
    }

    public void print_stock_list ()
    {
        for(Product p : this.products)
        {
            p.print_all_values();
        }
    }

    public Product find_product_with_id(int id)
    {
        Product product = null;
        int pointer = this.products.size();
        int size = pointer;
        boolean found = false;
        int current_id;
        while (!found && size > 1)
        {
            Product current_product = this.products.get(pointer);
            current_id = current_product.get_id();
            if (current_id == id)
            {
                found =true;
                product = products.get(pointer);
            }

            else
            {
                pointer = size/2;
                if (current_id < id)
                    pointer = pointer + size;
                size = size/2;
            }
        }
        return product;
    }
}
