package pertemuan2;

public class Pertemuan2 {

    
    public static void main(String[] args) {
        Shape s1 = new Rectangle("red", 4, 5);
        System.out.println(s1);
        System.out.println("Area is " + s1.getArea());
        
        s1 = new Triangle("yellow", 9, 10);                    //POLYMORPHISM
        System.out.println(s1);
        System.out.println("Area is " + s1.getArea());
        
        Shape s2 = new Triangle("blue", 4, 5);
        System.out.println(s2);
        System.out.println("Area is " + s2.getArea());
        
        
    }
    
}
