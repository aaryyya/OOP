import java.util.*;
public class _6_Calculator1 {
static final double pi =3.14;
static{
// System.out.println("Welcome To Calculator");
}
public void Calculator1(){
    System.out.println("Welcome To Calculator object created");
}
{ 
    System.out.println("New Calculator instance");

}
   public double Add(double num1, double num2) {
    return num1+num2;
   }
   public double Subtract(double num1, double num2){
    return num1-num2;
   }
   public double Multiply(double num1,double num2){
    return num1*num2;
   }
   public double Divide(double num1, double num2){
    return num1/num2;
   }

   public static void main(String[]args){
    _6_Calculator1 obj =new _6_Calculator1();
    Scanner scan =new Scanner(System.in);
    double num1;
    double num2;

    while(true){
        System.out.println("Enter input between 1-5");
        System.out.println("1.Addition");
        System.out.println("2.Subtraction");
        System.out.println("3.Multiplication");
        System.out.println("4.Division");
        System.out.println("5.Exit");
        
        int input = scan.nextInt();
        switch(input){
            case 1:
            System.out.println("1. Addition");
            System.out.println("No. 1");
            num1=scan.nextDouble();
            System.out.println("No. 2");
             num2=scan.nextDouble();
            System.out.println( "Addition is "+obj.Add(num1,num2));
            break;
            case 2:
            System.out.println("2. Subtraction");
            System.out.println("No. 1");
             num1=scan.nextDouble();
            System.out.println("No. 2");
             num2=scan.nextDouble();
            System.out.println( "Subtraction is "+obj.Subtract(num1,num2));
            break;
            case 3:
            System.out.println("3. Multiplication");
            System.out.println("No. 1");
             num1=scan.nextDouble();
            System.out.println("No. 2");
             num2=scan.nextDouble();
            System.out.println( "Multiplication is "+obj.Multiply(num1,num2));
            break;
            case 4:
            System.out.println("4. Division");
            System.out.println("No. 1");
             num1=scan.nextDouble();
            System.out.println("No. 2");
             num2=scan.nextDouble();
            System.out.println( "Division is "+obj.Divide(num1,num2));
            break;
            case 5:
            System.out.println("Exit");
            System.exit(0);

        }
    }


   }
}
