package sortsederhana;

public class Insertion {
    void sort(int[] x,int n){
        for(int i=2;i<=n;i++){
            int j=i-1;int a=x[i];
            while (j>0 && x[j]>a){
              x[j+1]=x[j];j--;
            } 
            x[j+1]=a;
       }
    }
}
