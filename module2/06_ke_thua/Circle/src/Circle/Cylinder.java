package Circle;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(double height, double radius , String color) {
        super(color,radius);
        this.height = height;
    }
    public double getTheTich(){
        return this.height*super.getArea();
    }
}
