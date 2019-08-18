package pqueue;
import java.util.Scanner;
import java.util.Random;

public class Pqueue {
    
    public static void olah(){
     char x[]={'U','G','M','J','U','A','R','A','1'}; 
   // char x[]={'I','L','K','O','M','U','G','M'}; 
     Queue Q=new Queue();
     for(int i=0;i<=8;i++) if(x[i]<75) Q.enqueueM(x[i]);
     Q.displayM(); //G J A A 1       
     Q.dequeueM(); Q.enqueueM('O');Q.dequeueM();Q.enqueueM('K'); //A A 1 O K
     Q.dequeueM();Q.enqueueM('E'); Q.dequeueM();Q.enqueueM('Y');// 1 O K E Y
     Q.enqueueM('A');
     Q.displayM();
     for(int i=0; i<Q.max_data; i++)
            System.out.print(Q.item[i]+" "); //O K E Y 1
   }
    public static void main(String[] args) {
        olah();
      /*  Scanner input =new Scanner(System.in);
        System.out.print("Banyak data : ");
        int n = input.nextInt();
        Queue Q=new Queue();
        Random r=new Random();
        for(int i=1;i<=n;i++){
            char x=(char)(r.nextInt(26)+65);
            Q.enqueue(x);
        }
        Q.displayM();
        Q.dequeueM();Q.dequeueM();//Q.dequeueM();
        Q.displayM();
        Q.enqueueM('T');
        Q.displayM();
        Q.enqueueM('U');
        Q.displayM();
        Q.enqueueM('V');
        Q.displayM();
        for(int i=0; i<Q.max_data; i++)
            System.out.print(Q.item[i]+" ");
    */
    }
    
}
