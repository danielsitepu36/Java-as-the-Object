package pertemuan1;

public class Cylinder extends Circle {

    private double height = 1.0;

    public Cylinder() {
        super();
    }

    public Cylinder(double height) {
        super();
        this.height = height;
    }

    public Cylinder(double height, double radius) {
        super(radius);
        this.height = height;
    }

    public Cylinder(double height, double radius, String color) {
        super(radius,color);    
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cylinder with radius " + getRadius() + " color " + getColor()
                + " and height " + height + " have volume = " + getArea();
    }

    public double getVolume() {
        return (getArea() * this.height);
    }
}
