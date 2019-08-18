package latihan1;
public class Sort {
    void sort(Mhs[] x,int n){
        Mhs a;
        for(int i=1;i<n;i++){
            int j=i-1;a=x[i];
            while (j>=0 && x[j].nama.compareTo(a.nama)>0){
              x[j+1]=x[j];j--;
            } 
            x[j+1]=a;
       }
    }   
}
