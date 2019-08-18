package Hackerrank1;

import java.io.*;
import java.util.*;

public class Hackerrank1 {

    public static int checkSize(int[] h,int n){     //Method untuk mengecek total nilai stack
        int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+h[i];
        }
        return sum;                                 //Mengembalikan total nilai isi stack sebagai integer
    }
    
    public static int equalStacks(int[] h1, int[] h2, int[] h3, int n1, int n2, int n3){
        int itr1=0;                         //Deklarasi iterator untuk stack 1, 2, dan 3
        int itr2=0;
        int itr3=0;
        int size1=checkSize(h1,n1);         //Mengambil total nilai dari isi stack 1, 2, dan 3
        int size2=checkSize(h2,n2);
        int size3=checkSize(h3,n3);
        do{                                 //Looping dilakukan sampai ketiga stack memiliki nilai sama
            while(size1 != size2){          //Looping pertama untuk menyamakan total nilai stack 1 dan 2
                if(size1>size2){            //Jika total nilai stack 1 lebih besar, akan dikurangi nilai yang paling atas
                    size1-=h1[itr1++];      //Total nilai dikurangi nilai top, dan indeks top akan turun
                }
                else if(size1<size2){       //Jika total nilai stack 2 lebih besar, akan dikurangi nilai yang paling atas 
                    size2-=h2[itr2++];      //Total nilai dikurangi nilai top, dan indeks top akan turun
                }
                if(size1<=0 || size2<=0){   //Jika ada salah satu stack yang total nilainya sudah 0, maka semua stack akan
                    return 0;               //seimbang di titik 0, maka return 0
                }
            }
            while(size2 != size3){          //Looping kedua untuk menyamakan total nilai stack 1 dan 2
                if(size2>size3){            //Jika total nilai stack 2 lebih besar, akan dikurangi nilai yang paling atas
                    size2-=h2[itr2++];      //Total nilai dikurangi nilai top, dan indeks top akan turun
                }
                else if(size2<size3){       //Jika total nilai stack 3 lebih besar, akan dikurangi nilai yang paling atas
                    size3-=h3[itr3++];      //Total nilai dikurangi nilai top, dan indeks top akan turun
                }
                if(size2<=0 || size3<=0){   //Jika ada salah satu stack yang total nilainya sudah 0, maka semua stack akan
                    return 0;               //seimbang di titik 0, maka return 0
                }
            }
        }while(size1 != size2 || size2 != size3);   //Apabila baru 2 stack yang memiliki nilai sama, dilakukan looping lagi
        return size2;                       //Jika total nilai sudah seimbang, akan mengembalikan nilai salah 1 stack
    }

    private static final Scanner scanner = new Scanner(System.in);      //Deklarasi Scanner sebagai variabel global

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));   //Read input

        String[] n1N2N3 = scanner.nextLine().split(" ");    //Scan line sebagai banyak tumpukan pada stack

        int n1 = Integer.parseInt(n1N2N3[0].trim());        //Scan jumlah tumpukan stack 1

        int n2 = Integer.parseInt(n1N2N3[1].trim());        //Scan jumlah tumpukan stack 2

        int n3 = Integer.parseInt(n1N2N3[2].trim());        //Scan jumlah tumpukan stack 3

        int[] h1 = new int[n1];                             //Deklarasi array untuk stack 1

        String[] h1Items = scanner.nextLine().split(" ");   //Scan line untuk memasukan nilai stack

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {          //Memasukan nilai stack 1 dari bawah ke atas (Paling atas = 0)
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];                             //Deklarasi array untuk stack 2

        String[] h2Items = scanner.nextLine().split(" ");   //Scan line untuk memasukan nilai stack

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {          //Memasukan nilai stack 2 dari bawah ke atas (Paling atas = 0)
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];                             //Deklarasi array untuk stack 3

        String[] h3Items = scanner.nextLine().split(" ");   //Scan line untuk memasukan nilai stack

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {          //Memasukan nilai stack 3 dari bawah ke atas (Paling atas = 0)
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }
        int result = equalStacks(h1, h2, h3, n1, n2, n3);   //Mengambil titik saat total nilai ketiga stack seimbang,
                                                            //Dengan parameter array dan ukurannya
        bufferedWriter.write(String.valueOf(result));       //Menampilkan hasilnya
        bufferedWriter.newLine();

        bufferedWriter.close();                             //Menutup penggunaan BufferedWriter
    }
}
