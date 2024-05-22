import java.util.*;

public class _5_Area {
    
   public double calculateArea(double a){
    double areaofSquare = a*a;
    return areaofSquare;
   }
   public double calculateArea(double a, double b){
    double areaofRect =a*b;
    return areaofRect;
   }
   public float calculateArea(float r){
    float pi =3.14f;
    float areaofCircle=r*r*pi;
    return areaofCircle;
   }
  public static void main(String[]args){
    _5_Area obj =new _5_Area();

    Scanner scan = new Scanner(System.in);

    
    while(true){
        System.out.println("Enter Input from the menu");
        System.out.println("1. Area of Rectangle");
        System.out.println("2. Area of Square");
        System.out.println("3. Area of Circle");
        System.out.println("4. Exit");
        
        int input = scan.nextInt();  
        switch(input){
            case 1: 
            System.out.println("Area of Rectangle");
            System.out.println("Please enter the input for Sides of Rectangle");
            double a=scan.nextDouble();
            System.out.println("2nd Side");
            double b=scan.nextInt();
            System.out.println(obj.calculateArea(a,b));
            break;
            case 2:
            System.out.println("Area of Square");
            System.out.println("Enter the side of Square");
            double side =scan.nextDouble();
            System.out.println("Area of Square"+obj.calculateArea(side));

            break;
            case 3:
            System.out.println("Area of Circle");
            System.out.println("Enter Radius of Circle");
            float radius =scan.nextFloat();
            System.out.println("Area of Cicle"+ obj.calculateArea(radius));
            break;
            case 4:
            System.out.println("Exit");
            System.exit(0);

            default:
        }
    }
  }
}
 /*5.	Implement a Java program for calculating the area of geometric shapes. The program should support calculating the area of a rectangle, a square, and a circle. Each shape has a different method to calculate its area. Your task is to implement a Java program that demonstrates method overloading by providing multiple versions of the calculateArea() method to calculate the area of each shape. (Use method overloading) */