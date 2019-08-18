package tugas1;

public class Square extends Rectangle {                             //Deklarasi class Square yang mengekstensi kelas Rectangle dan mewarisi atribut dari Rectangle dan Shape

    public Square() {                                               //Constructor objek Square
    }

    public Square(double side) {                                    //Constructor objek Square dengan perimeter side
        this.length = side;                                         //Mengubah atribut side menjadi atribut length dan width milik Rectangle
        this.width = side;
    }

    public Square(double side, String color, boolean filled) {      //Constructor objek Square dengan perimeter side, color, dan filled
        this.length = side;                                         //Mengubah atribut side menjadi atribut length dan width milik Rectangle
        this.width = side;
        this.color = color;
        this.filled = filled;
    }

    public double getSide() {                                       //Menampilkan side dari objek Square, diambil dari length Rectangle
        return length;
    }

    public void setSide(double side) {                              //Mengubah side dari objek Square
        this.length = side;                                         //Mengubah melalui atribut length dan width objek Rectangle
        this.width = side;
    }

    @Override
    public void setWidth(double side) {                             //Mengoverride method setWidth super menjadi pengubah side
        this.width = side;
    }

    @Override
    public void setLength(double side) {                            //Mengoverride method setLength super menjadi pengubah side
        this.length = side;
    }

    @Override
    public String toString() {                                      //Menunjukkan keluaran default ketika objek Square dipanggil
        return "Square with side = " + getSide() + " has an area = " + getArea()
                + " and perimeter = " + getPerimeter();
    }
}
