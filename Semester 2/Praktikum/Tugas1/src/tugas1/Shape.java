package tugas1;

abstract public class Shape {                                   //Deklarasi class Shape yang berupa abstract class

    protected String color;                                     //Deklarasi variabel color berupa String dengan jenis protected
    protected boolean filled;                                   //Deklarasi variabel filled berupa boolean dengan jenis protected

    public Shape() {                                            //Constructor objek Shape, belum bisa dipanggil karena masih dalam abstract class
    }

    public Shape(String color, boolean filled) {                //Constructor objek Shape dengan perimeter
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {                                  //Menampilkan color dari objek Shape
        return color;
    }

    public void setColor(String color) {                        //Mengubah color dari objek Shape
        this.color = color;
    }

    public boolean isFilled() {                                 //Menampilkan atribut filled dari objek Shape
        return filled;
    }

    public void setFilled(boolean filled) {                     //Mengubah atribut filled dari objek Shape
        this.filled = filled;
    }

    abstract public double getArea();                           //Method abstract getArea yang harus dioverride pada subclasses nya

    abstract public double getPerimeter();                      //Method abstract getArea yang harus dioverride pada subclasses nya

    @Override
    public String toString() {                                  //Method toString milik class Shape
        return "\nColor = " + color
                + "\nFilled = " + filled;
    }
}
