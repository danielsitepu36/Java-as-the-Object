package pertemuan1;

public class Circle {

    double radius = 1.0;
    String color = "red";

    //Jika private tidak bisa diakses di main dengan
    //c1.color = Yellow
    //Private>Protected(Packgage)>Public
    public Circle() {

    }

    public Circle(double radius) {
        //Jika radius diganti r , tidak harus pakai this.
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle with radius " + radius + " and color "
                + color + " have area = " + getArea();
    }
}
