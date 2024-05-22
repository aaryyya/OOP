import java.util.*;

interface Drawable {
    void draw();
}

interface Resizable {
    void resize(double factor);
}

class Circle implements Drawable, Resizable {
    double radius;

    public Circle(double rad) {
        this.radius = rad;
    }

    public void draw() {

        System.out.println("Circle is Drawable");
    }

    public void resize(double factor) {
        double save = radius*factor;
        System.out.println("Resized to "+ save);
    }
}

class Rectangle implements Drawable {
    public void draw() {
        System.out.println("Rectangle is Drawable");
    }
}

public class _7_Interfacing {

    public static void main(String[] args) {
        Circle obj = new Circle(10);
        Rectangle obj1 = new Rectangle();
        obj.resize(4);
        obj.draw();
        obj1.draw();

    }
}
/*
 * 7. Implement a Java program to represent a shape hierarchy. The program
 * should have interfaces for different types of shapes, such as Drawable for
 * shapes that can be drawn and Resizable for shapes that can be resized.
 * Interface Drawable has draw() method
 * Interface Resizable has resize(double factor) method
 * Implement classes for specific shapes such as circle, rectangle and
 * demonstrate multiple inheritance by implementing both Drawable and Resizable
 * interfaces in appropriate classes.
 * Circle implements both interfaces and implements both methods
 * Rectangle implements only Drawable interface and implements draw() method.
 */
