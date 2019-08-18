package penjualanbarang;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PenjualanBarang {

    public static void binarySearch(Barang[] x, int aw, int ak, String nm) {
        int mid;
        if (aw <= ak) {
            mid = (aw + ak) / 2;
            if (x[mid].nama.compareTo(nm) == 0) {
                System.out.println("Jumlah barang = " + x[mid].cacah);
            } else if (x[mid].nama.compareTo(nm) > 0) {
                binarySearch(x, aw, mid - 1, nm);
            } else {
                binarySearch(x, mid + 1, ak, nm);
            }
        } else {
            System.out.print("Barang tidak ada");
        }
    }

    public static void main(String[] args) {
        File fileinput = new File("databarang.txt");//file yang dibaca
        Barang[] x = new Barang[100];
        int n = 0;
        try {
            Scanner scanfile = new Scanner(fileinput);
            int i = 0, total = 0;
            boolean cek;
            while (scanfile.hasNextLine()) //Check token berikutnya
            {
                Barang data = new Barang();
                data.nama = scanfile.nextLine();
                data.cacah = Integer.valueOf(scanfile.nextLine());
                total += data.cacah;
                if (i == 0) {
                    x[i] = data;
                    i++;
                } else {
                    int j = i - 1;
                    cek = true;
                    while (cek && j >= 0 && x[j].nama.compareTo(data.nama) >= 0) {
                        if (x[j].nama.compareTo(data.nama) == 0) {
                            x[j].cacah += data.cacah;
                            cek = false;
                            for (int k = j + 1; k < i; k++) {
                                x[k] = x[k + 1];
                            }
                        } else {
                            x[j + 1] = x[j];
                        }
                        j--;
                    }
                    if (cek) {
                        x[j + 1] = data;
                        i++;
                    }
                }

            }
            n = i;
            for (i = 0; i < n; i++) {
                System.out.println(x[i].nama + " " + x[i].cacah);
            }
            System.out.println("Total jumlah barang = " + total);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner input = new Scanner(System.in);
        System.out.print("nama barang = ");
        String nm = input.nextLine();
        binarySearch(x, 0, n - 1, nm);
    }
}
