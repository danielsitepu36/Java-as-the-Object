package tugas2;

//DANIEL SURANTA SITEPU
//18-424185-PA-18290
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tugas2 {

    public static void show(int n, Kontak[] daftar) {
        int i;
        System.out.println("DAFTAR KONTAK ANDA :");
        for (i = 0; i < n; i++) {
            System.out.print(daftar[i].nama + "(" + daftar[i].i + " Nomor HP) : ");
            daftar[i].showPhone();
        }
        System.out.println();
    }

    public static void search(int n, String query, Kontak[] daftar) {
        int i;
        boolean found = false;
        for (i = 0; i < n; i++) {
            if (daftar[i].nama.equals(query)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Kontak ditemukan :");
            System.out.print(daftar[i].nama + "(" + daftar[i].i + " Nomor HP) : ");
            daftar[i].showPhone();
        } else {
            System.out.println("Kontak tidak dapat ditemukan !");
        }
        System.out.println();
    }

    public static void sort(int n, Kontak[] daftar) {
        int min;
        Kontak temp = new Kontak();
        for (int i = 0; i < n - 1; i++) {
            min = i;
            for (int j = i + 1; j < n; j++) {
                if (daftar[j].nama.compareTo(daftar[min].nama) < 0) {
                    min = j;
                }
            }
            temp = daftar[i];
            daftar[i] = daftar[min];
            daftar[min] = temp;
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int i = 0, j = 0, t = 0, n = 0;
        String A;
        String B;
        Kontak[] daftar = new Kontak[10000];

        //String currentDir = System.getProperty("user.dir");
        //File f = new File(currentDir + "\\src\\tugas2\\daftarkontak.txt");
        File f = new File("daftarkontak.txt");

        try (Scanner inFile = new Scanner(f)) {
            daftar[0] = new Kontak();
            while (inFile.hasNextLine()) {
                A = "";
                while (inFile.hasNext("[a-zA-Z]+")) {
                    A += inFile.next() + " ";
                }
                t = i;
                for (j = 0; j < t; j++) {
                    if (daftar[j].nama.equals(A)) {
                        t = j;
                    }
                }
                if (t == i) {
                    daftar[t].nama = A;
                }
                while (inFile.hasNext("[0-9]+")) {
                    B = inFile.next() + " ";
                    daftar[t].setPhone(B);
                }
                if (daftar[i].nama != null) {
                    i++;
                    daftar[i] = new Kontak();
                }
            }
            n = i;
            inFile.close();

            //MENU
            String menu;
            String selesai = null;
            String query;
            do {

                System.out.println("Menu :");
                System.out.println("A) Tampilkan data kontak");
                System.out.println("B) Urutkan data kontak dan tampilkan");
                System.out.println("C) Cari data kontak");
                System.out.println("D) Keluar");
                System.out.print("Masukkan pilihan (A/B/C/D) : ");
                menu = input.next();
                System.out.println();
                switch (menu) {
                    case "A":
                        show(n, daftar);
                        if (daftar[0].nama == null) {
                            System.out.println("Tidak ditemukan data dalam daftar kontak anda, tidak dapat melanjutkan program !");
                            selesai = "Y";
                            break;
                        }
                        /*do {
                        System.out.print("Apakah anda ingin mengakhiri program ? (N menuju ke menu / Y mengakhiri program) : ");
                        selesai = input.next();
                        if (!"Y".equals(selesai) && !"N".equals(selesai)) {
                            System.out.println("Input salah, silakan masukkan (N/Y) !");
                        }
                    } while (!"Y".equals(selesai) && !"N".equals(selesai));*/
                        break;
                    case "B":
                        System.out.println("Setelah data diurutkan :");
                        sort(n, daftar);
                        show(n, daftar);
                        break;
                    case "C":
                        System.out.print("Masukkan nama kontak yang ingin anda cari (Harap perhatikan huruf kapital kontak) : ");
                        input.nextLine();
                        query = input.nextLine() + " ";
                        search(n, query, daftar);
                        break;
                    case "D":
                        break;
                    default:
                        System.out.println("ERROR, harap masukkan pilihan (A/B/C/D) !");
                        break;
                }
            } while (!"D".equals(menu) /*&& "N".equals(selesai)*/);
        } catch (FileNotFoundException e) {
            System.out.println("Data kontak tidak ditemukan ! Silakan masukkan data kedalam folder Tugas2");
        }
        System.out.println("Terima kasih");
    }
}

