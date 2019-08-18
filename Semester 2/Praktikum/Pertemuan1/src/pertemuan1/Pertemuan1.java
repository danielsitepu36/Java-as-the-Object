package pertemuan1;
        //sout
        //psvm
        //alt+shift+f - Design
        //ctrl+space - Obj
public class Pertemuan1 {

    public static void main(String[] args) {
        Circle c1 = new Circle(65);
        Cylinder c2 = new Cylinder(10,10,"Blue");
        c1.setColor("Yellow");
        c1.setRadius(7);
        System.out.println(c1);
        double Area = c1.getArea();
        System.out.println(Area);
        System.out.println(c2);
    }
}
