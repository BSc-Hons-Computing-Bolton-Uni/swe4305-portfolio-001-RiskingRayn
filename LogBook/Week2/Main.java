package LogBook.Week2;
import java.util.Scanner;
import java.time.YearMonth;

public class Main
{
    static void task1()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your age: ");
        int age = scanner.nextInt();
        int year = YearMonth.now().getYear();
        int birth_year = year - age;
        System.out.println("your birth year is either " + birth_year + " or " + (birth_year-1));
        if (age > 18)
            System.out.println("You are 18 or older");
    }

    public static void main(String args[])
    {
        task1();

    }
}
