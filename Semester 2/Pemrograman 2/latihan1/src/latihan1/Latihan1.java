package latihan1;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Latihan1 {    
    public static void main(String[] args) {
        File fileinput = new File("data.txt");//file yang dibaca
        try
        {   int i=0;
            Mhs[] x = new Mhs[10];
            Scanner scanfile = new Scanner(fileinput);
            while (scanfile.hasNextLine()) //Check token berikutnya
            {   
                x[i]=new Mhs();
                x[i].nama = scanfile.nextLine();
                x[i].nilai = Integer.valueOf(scanfile.nextLine());
                i++;
            }
            int n=i;
            for(i=0;i<n;i++){
            System.out.println(x[i].nama+" "+x[i].nilai);}
            Sort hasil=new Sort();
            hasil.sort(x,n);
            System.out.println("Data setelah diurutkan :");
            for(i=0;i<n;i++){
            System.out.println(x[i].nama+" "+x[i].nilai);}
            
        }
        catch (FileNotFoundException error) {
            System.out.println("File not found");
        }
             
    }
}
