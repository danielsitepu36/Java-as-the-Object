package sortsederhana;
import java.util.Scanner;
import java.util.Random;

public class SortSederhana {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.print("banyak data = ");
        int n = input.nextInt();
        int[] x=new int[n];
        Random r=new Random();
        for(int i=0;i<n;i++){
            x[i]=r.nextInt(100)+1;  
          }
        
       // Statistics s=new Statistics();
       // int[] x=new int[n];
        //s.insert(x,n);
        for(int i=0;i<n;i++){
          System.out.print(x[i]+" ");
          if (i%10==9) System.out.println();
        }
        System.out.println();
       // System.out.println("median = "+s.median(x,n));
        Cetak c=new Cetak();
        //System.out.println("Data sebelum terurut :");
        //c.cetak(x, n);
        double start=System.nanoTime();
        Bubble hasil=new Bubble();
       // Sekuensial hasil=new Sekuensial();
        //Insertion hasil=new Insertion();
        hasil.sort(x, n);
        double finish=System.nanoTime();
        //System.out.println("Data terurut :");
        c.cetak(x, n);
        System.out.println("waktu proses = "+(finish-start)/1.0E9+" detik");
    }
}
