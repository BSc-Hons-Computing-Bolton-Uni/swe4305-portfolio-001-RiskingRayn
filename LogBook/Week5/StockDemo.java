package LogBook.Week5;

public class StockDemo {

    public void run()
    {
        test_stock_demo();
    }

    public void test_stock_demo()
    {
        Product product_t1 = new Product(1 , "test1", 50);
        Product product_t2 = new Product(2, "test2", 40);
        Product product_t3 = new Product(3, "test3", 13);
        StockList stock_list = new StockList();

        stock_list.add_product(product_t2);
        stock_list.add_product(product_t1);
        stock_list.add_product(product_t3);

        stock_list.print_stock_list();

    }

}
