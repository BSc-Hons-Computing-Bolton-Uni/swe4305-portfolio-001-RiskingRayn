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

    static void task2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your grade A,B,C,D,E,F");
        String original_grade = scanner.next();
        original_grade = original_grade.toLowerCase();
        String new_grade = "";
        switch (original_grade) {
            case "a":
                new_grade = "1st";
                break;
            case "b":
                new_grade = "2:1";
                break;
            case "c":
                new_grade = "2:2";
                break;
            case "d":
                new_grade = "3rd";
                break;
            case "e":
                new_grade = "ordanary";
                break;
            case "f":
                new_grade = "Fail";
                break;
            default:
                new_grade = "invalid value enterd";
                break;
        }
        System.out.println("your university grade is " + new_grade);
    }

    static void task3()
    {
        for (int i = 0 ; i < 10; i += 1) System.out.println(i);
    }

    public static void main(String args[])
    {
        task3();

    }
}
