package LogBook.Week1;

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
    public static void main (String []Args)
    {
        task5();

    }
}