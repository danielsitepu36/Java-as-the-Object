package sortsederhana;
public class Bubble {
    void sort(int[] x,int n){
        for(int i=0;i<n-1;i++)
            for(int j=0;j<n-1-i;j++)
                if(x[j]>x[j+1]) {
                  int temp=x[j];x[j]=x[j+1];x[j+1]=temp;    
                }
    }
}
