package pertemuan2interface;

public class Pertemuan2Interface {

    public static void main(String[] args) {

        Shape s1 = new Rectangle(1, 2); // upcast
        System.out.println(s1);
        System.out.println("Area is " + s1.getArea());
        Shape s2 = new Triangle(3, 4); // upcast
        System.out.println(s2);
        System.out.println("Area is " + s2.getArea());
        // Cannot create instance of an interface
        //Shape s3 = new Shape("green"); // Compilation Error!!
    }
}
