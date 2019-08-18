package pbucketsort;
import java.util.Scanner;
import java.util.Random;
public class PbucketSort {
    public static void bucketSort(char[] x,int n){
    List[] AQ=new List[26];
    for(int k=0;k<26;k++) 
       AQ[k]=new List();
    for(int i=0;i<n;i++){
        int j=x[i]-65; 
         Node p=new Node();p.data=x[i];p.next=null;
        AQ[j].enqueue(p);
    }
    int i=0;
    for(int k=0;k<26;k++){
      while (!AQ[k].isEmpty()){
        x[i]=AQ[k].dequeue();
        i++;
       }
      }
    }
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.print("Banyak data : ");
        int n = input.nextInt();
        char[] x=new char[n];
        Random r=new Random();
        for(int i=0;i<n;i++){
            x[i]=(char)(r.nextInt(26)+65);
            System.out.print(x[i]+" ");
        }
        System.out.println();
        bucketSort(x,n);
        for(int i=0;i<n;i++) 
            System.out.print(x[i]+" ");            
        System.out.println();
    }
    
}
