package tugas1;

public class Rectangle extends Shape {                              //Deklarasi class Rectangle yang mengekstensi kelas Shape dan mewarisi atribut dari Shape

    protected double width;                                         //Deklarasi variabel width berupa double dengan jenis protected
    protected double length;                                        //Deklarasi variabel length berupa double dengan jenis protected

    public Rectangle() {                                            //Constructor objek Rectangle
    }

    public Rectangle(double width, double length) {                 //Constructor objek Rectangle dengan perimeter width dan length
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        this.width = width;
        this.length = length;                                       //Constructor objek Rectangle dengan perimeter width, length, color, dan filled
        this.color = color;
        this.filled = filled;
    }

    public double getWidth() {                                      //Menampilkan width dari objek Rectangle
        return width;
    }

    public void setWidth(double width) {                            //Mengubah width dari objek Rectangle
        this.width = width;
    }

    public double getLength() {                                     //Menampilkan length dari objek Rectangle
        return length;
    }

    public void setLength(double length) {                          //Mengubah length dari objek Rectangle
        this.length = length;
    }

    @Override
    public double getArea() {                                       //Menampilkan luas area dari objek Rectangle yang mengoverride method super
        return length * width;
    }

    @Override
    public double getPerimeter() {                                  //Menampilkan luas area dari objek Rectangle yang mengoverride method super
        return 2 * (length + width);
    }

    @Override
    public String toString() {                                      //Menunjukkan keluaran default ketika objek Rectangle dipanggil
        return "Rectangle with width = " + getWidth()
                + " and length = " + getLength()
                + " has an area = " + getArea()
                + " and perimeter = " + getPerimeter() + super.toString();
    }
}
