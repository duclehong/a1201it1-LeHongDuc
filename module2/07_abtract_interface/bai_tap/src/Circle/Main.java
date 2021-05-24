package Circle;

import Shape.Shape;

public class Main {
    public static void main(String[] args) {
        Cylinder a = new Cylinder(9, "red", false, 5);
        System.out.println(a.getTheTich());
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3);
        shapes[1] = new Rectangle(3, 4);
        shapes[2] = new Square(3);
//        Resizeable b = new Square(3);
//        System.out.println(b);
        for (Shape shape : shapes) {
            System.out.println(shape);
            System.out.println("Dien tich la: "+ shape.getArea());
            shape.resize(50);
            System.out.println("Shapes after resize:" + shape.getArea());
            System.out.println("---------------------------------");

        }

//        for (Resizeable shape : shapes) {
//            shape.resize(50);
//            System.out.println(shape);
//        }
    }

}
