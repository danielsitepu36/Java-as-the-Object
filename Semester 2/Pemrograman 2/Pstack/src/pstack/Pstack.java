package pstack;
import java.util.Scanner;

public class Pstack {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.print("Tuliskan string : ");
        String str = input.nextLine();
        Kalimat kal=new Kalimat();
        //kal.balik(str);
         //kal.balance(str);
        //kal.balikUTS(str);
       System.out.println(kal.palindrom(str));
    }
    
}