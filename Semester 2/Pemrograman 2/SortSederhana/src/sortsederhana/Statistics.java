package sortsederhana;
import java.util.Random;

public class Statistics {
public void insert(int[]x,int n){
   Random r=new Random();
   int a;
   for(int i=0;i<n;i++){
       int j=i-1;a=r.nextInt(100)+1;
        while (j>-1 && x[j]>a){
          x[j+1]=x[j];j--;
        } 
        x[j+1]=a;
   }    
}
    
public double median(int[] x,int n){
  if(n%2==0) return (x[n/2-1]+x[n/2])/2.0;
  else return x[n/2];
}
}
