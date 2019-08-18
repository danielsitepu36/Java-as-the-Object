package sortsederhana;

public class Cetak {
    void cetak(int[] x,int n){
        for(int i=0;i<n;i++){
            System.out.print(x[i]+" ");
            if(i%20==19) System.out.println();
        }
        System.out.println();
        
    }
}
