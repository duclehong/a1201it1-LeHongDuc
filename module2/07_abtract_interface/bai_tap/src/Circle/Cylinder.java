package Circle;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public Cylinder(double radius, String color, boolean filled, double height) {
        super(radius, color, filled);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getTheTich(){
        return this.height*super.getArea();
    }

    @Override
    public String toString() {
        return "A Clylinder with radius="
                + super.getRadius()
                + "and height = "
                + getHeight()
                + ", which is a subclass of "
                + super.toString();
    }
}
