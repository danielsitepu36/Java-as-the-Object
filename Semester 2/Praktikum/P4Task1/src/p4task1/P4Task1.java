package p4task1;

//import java.io.IOException;
//import java.util.Scanner;

public class P4Task1 {

    public static void main(String[] args) {
        String a = "Level";
        StackInit s = new StackInit(a.length());
        for (int i = 0; i < a.length(); i++) {
            s.push(a.charAt(i));
        }

        String b = "";
        for (int i = 0; i < a.length(); i++) {
            b+=s.pop();
        }
        if(b.equalsIgnoreCase(a)){
            System.out.println("PALINDROM");
        }
        else{
            System.out.println("NOT A PALINDROM");
        }
    }

}
