package pertemuan2;

public class Rectangle extends Shape{
    private int length;
    private int width;
    
    public Rectangle(String color, int length, int width){
        super(color);
        this.length=length;
        this.width=width;
    }
    
    @Override
    public String toString(){
        return "Rectaangle[length=" + length + ",width=" + width + "," + super.toString() + "]";
    }
    
    @Override
    public double getArea(){        //HARUS ADA
        return length*width;
    }
}
