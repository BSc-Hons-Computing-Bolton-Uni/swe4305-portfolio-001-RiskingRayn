package LogBook.Week1;
import java.lang.reflect.Array;
import java.time.YearMonth ;
import java.time.LocalDate;
import java.time.Period;

import java.util.Scanner;

public class Main
{
    static void hellow ()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.next();
        System.out.println("hello " + name);
    }
    static void rectangale()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter lenth number one: ");
        int len1  = scanner.nextInt();
        System.out.println ("Enter lenth number two: ");
        int len2  = scanner.nextInt();
        int aria = len1 * len2;
        System.out.println("the aria is: " + aria);
    }
    static void avrage()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter number 1");
        double num1 = scanner.nextDouble();
        System.out.println("enter number 2");
        double num2 = scanner.nextDouble();
        double ans = (num1 + num2)/2;
        System.out.println("the avrage is "+ ans);

    }

    static void task5()
    {
     Scanner scanner = new Scanner(System.in);
     System.out.println("enter number 1: ");
     double num1 = scanner.nextDouble();
     System.out.println("enter number 2: ");
     double num2 = scanner.nextDouble();
     System.out.println(num1 +" "+ num2);
     System.out.println(num2 +" " + num1);
    }

    static void task6()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your age: ");
        int age = scanner.nextInt();
        int year = YearMonth.now().getYear();
        int birth_year = year - age;
        System.out.println("your birth year is either " + birth_year + " or " + (birth_year-1));
    }

    static void task7()
    {
        Scanner scanner = new Scanner(System.in);
        int[] days_in_months =  {31,28,31,30,31,30,31,31,30,31,30,31};
        System.out.println("Enter your birth year: ");
        int birth_year = scanner.nextInt();
        System.out.println("Enter your birth month: ");
        int birth_month = scanner.nextInt();
        System.out.println("Enter your birth day: ");
        int birth_day = scanner.nextInt();
        LocalDate birth_date = LocalDate.of(birth_year, birth_month, birth_day);
        LocalDate now =  LocalDate.now();
        Period period = Period.between(birth_date, now);
        int days_diffrence = (period.getYears() * 365) + ((int) period.getYears() / 4);
        for (int month = 0; month < period.getMonths(); month+=1)
        {
            days_diffrence +=  days_in_months[month];
        }
        days_diffrence += period.getDays();
        System.out.println("You have lived for " + days_diffrence + " days");

    }
    public static void main (String []Args)
    {
        task7();

    }
}