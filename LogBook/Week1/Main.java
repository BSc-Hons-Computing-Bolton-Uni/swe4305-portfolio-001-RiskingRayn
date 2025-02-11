package LogBook.Week1;
import java.time.YearMonth ;
import java.time.LocalDate;
import java.time.Period;

import java.util.Scanner;

public class Main
{
    /*
    * task 2 is want the creation of a program that can display text
    * asking the users name and then replying with hello.
    */
    static void task2 ()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.next();
        System.out.println("hello " + name);
    }
    /*
    * task 3 is a program that asks the user to two lengths on a rectangle
    * and then the program will take the entered values and multiply them together to
    * get the aria of the rectangle.
    *
    * */
    static void task3()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter lenth number one: ");
        int len1  = scanner.nextInt();
        System.out.println ("Enter lenth number two: ");
        int len2  = scanner.nextInt();
        int aria = len1 * len2;
        System.out.println("the aria is: " + aria);
    }
    /*
    * task 4 is a prosses that finds the avrage of two user enteerd numbers.
    * it does this by adding the number then deviding them by 2
    */
    static void task4()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter number 1");
        double num1 = scanner.nextDouble();
        System.out.println("enter number 2");
        double num2 = scanner.nextDouble();
        double ans = (num1 + num2)/2;
        System.out.println("the avrage is "+ ans);

    }                                                                                                            
    /*
    * 
    */
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
            days_diffrence +=  days_in_months[month];
        days_diffrence += period.getDays();
        System.out.println("You have lived for " + days_diffrence + " days");
    }

    static void task8 ()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount of feet: ");
        double feet = scanner.nextDouble();
        int feet_in_mile = 5280;
        double amount_of_miles = feet / feet_in_mile;
        System.out.println(feet + " feet is " + amount_of_miles + " miles");
    }

    static void task9 ()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the deposited amount: ");
        double deposit = scanner.nextDouble();
        double new_amount = (deposit/100) + deposit;
        System.out.println("your amount after one year will be " + new_amount);
    }

    public static void main (String []Args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the task number you wish to run: ");
        String ans = scanner.next();
        switch (ans)
        {
            case "1":
                System.out.println("Hello World!!");     // hello world
                break;
            case "2":
                task2();
                break;
            case "3":
                task3();
                break;
            case "4":
                task4();
                break;
            case "5":
                task5();
                break;
            case "6":
                task6();
                break;
            case "7":
                task7();
                break;
            case "8":
                task8();
                break;
            case "9":
                task9();
                break;
        }
    }
}