import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

class Tugas1 {
    public static void sorting(double[] X,int n){
        int min;
        double temp;
        for(int i=0;i<n-1;i++){
            min=i;
            for(int j=i+1;j<n;j++){
                if(X[j]<X[min]){
                    min=j;
                }
            }
            temp=X[i];
            X[i]=X[min];
            X[min]=temp;
        }
    }

    public static void searching(double[] X,int n, double query){
        int i=0,k=0,l=0,m=0,j=n;
        boolean found=false;
        while(!found && i<=j){
            k=(i+j)/2;
            if(X[k]<query){
                i=k+1;
            }
            else if(X[k]==query){
                found=true;
            }
            else{
                j=k-1;
            }
        }
        if(found){
            l=k;
            m=k;
            while((l-1)>=0 && X[l-1]==X[l]){
                l--;
            }
            while((m+1)<=n && X[m+1]==X[m]){
                m++;
            }
            if(l==m){
                System.out.println(" 1 data ditemukan : IPK ke-" + (k+1) + " yaitu " + X[k]);
            }
            else{
                System.out.println("Ditemukan " + (m-l+1) + " data, yaitu : ");
                System.out.println("IPK ke-" + (l+1) + " sampai " + (m+1) + " yaitu " + X[k]);
            }
        }
        else{
            System.out.println("Data tidak ditemukan !");
        }
    }

    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        double query=0;
        boolean truequery=false,truedone=false,selesai=true;
        char done;

        System.out.print("Masukkan jumlah data IPK = ");
        int n = input.nextInt();
        double[] X = new double[n];
        for(int i=0;i<n;i++){
            X[i] = Math.round((Math.random() * 4)*100)/100.00 ;
        }
        for(int i=0;i<n;i++)
        {
            System.out.println("IPK ke-"+(i+1)+" = "+X[i]);
        }
        
        sorting(X, n);
        System.out.println("\nData setelah diurutkan : ");
        for(int i=0;i<n;i++){
            System.out.println("IPK ke-"+(i+1)+" = "+X[i]);
        }
        do{
            do{
                try{
                    System.out.print("\nMasukkan data nilai IPK yang ingin dicari = ");
                    query = input.nextDouble();
                    truequery=true;
                }catch(InputMismatchException e){
                    System.out.println("Input nilai data salah, harap masukkan data berupa bilangan real !");
                    input.next();
                    truequery=false;
                }
            }while(!truequery);
            searching(X, (n-1), query);
            do{
                System.out.println("\nApakah anda ingin mengulangi searching ? (Y/N)");
                done = input.next().charAt(0);
                truedone=true;
                if(done=='Y'){
                    selesai=false;
                }
                else if(done=='N'){
                    selesai=true;
                }
                else{
                    System.out.println("Input salah ! Harap masukkan Y untuk mengulangi searching / N untuk mengakhiri program !");
                    truedone=false;
                }
            }while(!truedone);
        }while(!selesai);
        System.out.println("Terima Kasih");
        input.close();  
    }
}