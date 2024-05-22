// import java.util.Scanner;

import java.util.Scanner;

public class _1_Student_Manager {
    public static void main(String[] args) {
        int age = 18;
        String name = "Shreyas";
        float marks = 3.38f;
        // int input =4;
        while(true){
            System.out.println("Please Enter Input between 1 - 4");
            System.out.println("1. Name");
            System.out.println("2. Age");
            System.out.println("3. Scores");
            System.out.println("4. Exit");
            Scanner scan = new Scanner(System.in);
            int input = scan.nextInt();
            switch (input) {
            case 1:
                System.out.println("My Name is " + name);
                break;
            case 2:
                System.out.println("My Age is " + age);
                break;
            case 3:
                System.out.println("My Scores are" + marks);
                break;
            case 4:
                System.out.println("Exit");
                System.exit(0);

            default:
                break;
        }
    }
        // System.out.println("My Name is "+ name +"\nMy age is "+ age+"\nMy Scores are
        // "+marks);
    }

}

// class Student {
// int rollno;
// char grade;
// String name;

// Student()
// Student obj =new Student()
// }