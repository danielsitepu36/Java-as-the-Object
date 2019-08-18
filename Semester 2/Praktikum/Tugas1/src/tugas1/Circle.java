package tugas1;

public class Circle extends Shape {                                 //Deklarasi class Circle yang mengekstensi kelas Shape dan mewarisi atribut dari Shape

    protected double radius;                                        //Deklarasi variabel radius berupa double dengan jenis protected

    public Circle() {                                               //Constructor objek Circle
    }

    public Circle(double radius) {                                  //Constructor objek Circle dengan perimeter radius
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {    //Constructor objek Circle dengan perimeter radius, color, dan filled
        this.radius = radius;
        this.color = color;
        this.filled = filled;
    }

    public double getRadius() {                                     //Menampilkan radius dari objek Circle
        return radius;
    }

    public void setRadius(double radius) {                          //Mengubah radius dari objek Circle
        this.radius = radius;
    }

    @Override
    public double getArea() {                                       //Menampilkan luas area dari objek Circle yang mengoverride method super
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {                                  //Menampilkan keliling dari objek Circle yang mengoverride method super
        return Math.PI * radius * 2;
    }

    @Override
    public String toString() {                                      //Menunjukkan keluaran default ketika objek Circle dipanggil
        return "Circle with radius = " + radius + " has an area = " + getArea()
                + " and perimeter = " + getPerimeter() + super.toString();
    }
}
