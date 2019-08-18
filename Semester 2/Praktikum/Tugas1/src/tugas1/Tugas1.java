//DANIEL SURANTA SITEPU - 18/424185/PA/18290
package tugas1;                                                 //Deklarasi package dari project ini

public class Tugas1 {                                           //Deklarasi class Tugas1 (Main class)

    public static void main(String[] args) {                    //Deklarasi method main, yang merupakan method utama saat program dijalankan
        Shape s1 = new Circle(5.5, "RED", false);               //Membuat objek baru s1 berupa Circle dari class Shape : Upcast
        System.out.println(s1);                                 //Mengeprint default objek s1 : Method toString class Circle yang mengoverride super class Shape
        System.out.println(s1.getArea());                       //Mengeprint method getArea class Circle yang mengoverride method abstract di class Shape
        System.out.println(s1.getPerimeter());                  //Mengeprint method getPerimeter class Circle yang mengoverride method abstract di class Shape
        System.out.println(s1.getColor());                      //Mengeprint method getColor dari class Shape
        System.out.println(s1.isFilled());                      //Mengeprint method isFilled dari class Shape
        System.out.println(s1.getRadius());                     //ERROR, karena di dalam class Shape s1 tidak ada method getRadius

        Circle c1 = (Circle) s1;                                //Membuat objek baru c1 yang memiliki sifat seperti s1 namun dari class Circle : Downcast
        System.out.println(c1);                                 //Mengeprint default objek c1 : Method toString class Circle
        System.out.println(c1.getArea());                       //Mengeprint method getArea class Circle yang mengoverride method abstract di class Shape
        System.out.println(c1.getPerimeter());                  //Mengeprint method getPerimeter class Circle yang mengoverride method abstract di class Shape
        System.out.println(c1.getColor());                      //Mengeprint method getColor dari super class Shape
        System.out.println(c1.isFilled());                      //Mengeprint method isFilled dari super class Shape
        System.out.println(c1.getRadius());                     //Bisa berjalan, yaitu mengeprint method getRadius pada class Circle

        Shape s2 = new Shape();                                 //ERROR, karena class Shape adalah abstract class yang tidak bisa di construct
        
        Shape s3 = new Rectangle(1.0, 2.0, "RED", false);       //Membuat objek baru s3 berupa Rectangle dari class Shape : Upcast
        System.out.println(s3);                                 //Mengeprint default objek s3 : Method toString class Rectangle yang mengoverride super class Shape
        System.out.println(s3.getArea());                       //Mengeprint method getArea class Rectangle yang mengoverride method abstract di class Shape
        System.out.println(s3.getPerimeter());                  //Mengeprint method getPerimeter class Rectangle yang mengoverride method abstract di class Shape
        System.out.println(s3.getColor());                      //Mengeprint method getColor dari super class Shape
        System.out.println(s3.getLength());                     //ERROR, karena di dalam class Shape s3 tidak ada method getLength

        Rectangle r1 = (Rectangle) s3;                          //Membuat objek baru r1 yang memiliki sifat seperti s3 namun dari class Rectangle : Downcast
        System.out.println(r1);                                 //Mengeprint default objek r1 : Method toString class Rectangle
        System.out.println(r1.getArea());                       //Mengeprint method getArea class Rectangle yang mengoverride method abstract di class Shape
        System.out.println(r1.getColor());                      //Mengeprint method getColor dari super class Shape
        System.out.println(r1.getLength());                     //Bisa berjalan, yaitu mengeprint method getLength pada class Rectangle

        Shape s4 = new Square(6.6);                             //Membuat objek baru s4 berupa Square dari class Shape : Upcast
        System.out.println(s4);                                 //Mengeprint default objek s4 : Method toString class Square yang mengoverride super class Shape
        System.out.println(s4.getArea());                       //Mengeprint method getArea class Square yang mengoverride method abstract di class Shape   
        System.out.println(s4.getColor());                      //Mengeprint method getColor dari super class Shape
        System.out.println(s4.getSide());                       //ERROR, karena di dalam class Shape s4 tidak ada method getSide

        Rectangle r2 = (Rectangle) s4;                          //Membuat objek baru r2 yang memiliki sifat seperti s4 namun dari class Rectangle : Downcast
        System.out.println(r2);                                 //Mengeprint default objek r2 : Method toString class Square yang mengoverride super class Rectangle
        System.out.println(r2.getArea());                       //Mengeprint method getArea class Rectangle yang mengoverride method abstract di class Shape
        System.out.println(r2.getColor());                      //Mengeprint method getColor dari super class Shape
        System.out.println(r2.getSide());                       //ERROR, karena di dalam class Rectangle r2 tidak ada method getSide
        System.out.println(r2.getLength());                     //Mengeprint method getLength dari class Rectangle yang telah di override class Square

        Square sq1 = (Square) r2;                               //Membuat objek baru sq1 yang memiliki sifat seperti r2 namun dari class Square : Downcast
        System.out.println(sq1);                                //Mengeprint default objek sq1 : Method toString class Square yang mengoverride super class Rectangle
        System.out.println(sq1.getArea());                      //Mengeprint method getArea class Square yang mengoverride method abstract di class Shape
        System.out.println(sq1.getColor());                     //Mengeprint method getColor dari super class Shape
        System.out.println(sq1.getSide());                      //Bisa berjalan, mengeprint method getSide class Square
        System.out.println(sq1.getLength());                    //Mengeprint method getLength dari class Square yang mengoverride class Rectangle
    }

}
