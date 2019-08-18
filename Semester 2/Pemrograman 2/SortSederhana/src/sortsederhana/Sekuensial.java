package sortsederhana;
public class Sekuensial {
    void sort(int[] x,int n){
        for(int i=1;i<=n-1;i++)
            for(int j=i+1;j<=n;j++)
                if(x[i]>x[j]) {
                  int temp=x[i];x[i]=x[j];x[j]=temp;    
                }
    }
}
