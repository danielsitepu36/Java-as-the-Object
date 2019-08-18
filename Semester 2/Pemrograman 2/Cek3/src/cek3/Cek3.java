package cek3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cek3 {
    
    public static void findreplace(List kontak, String query) {
        try {
            String q, fitur, nomor, qnomor;
            Scanner input = new Scanner(System.in);
            if (kontak.find(query)) {
                System.out.println("\nDITEMUKAN !");
                do {
                    System.out.println("Menu :");
                    System.out.println("A) Tampilkan data kontak");
                    System.out.println("B) Tambah Nomor");
                    System.out.println("C) Ubah Nomor");
                    System.out.println("D) Hapus Nomor");
                    System.out.println("E) Ubah data yang ingin diganti");
                    System.out.println("F) Kembali ke menu");
                    System.out.print("Masukkan pilihan (A/B/C/D/E/F) : ");
                    fitur = input.next();
                    System.out.println();
                    switch (fitur) {
                        case "A":
                            System.out.println(kontak.tmp.data + " : ");
                            kontak.tmp.nohp.printNode();
                            break;
                        case "B":
                            System.out.print("Masukkan nomor baru : ");
                            input.nextLine();
                            nomor = input.next() + " ";
                            kontak.tmp.nohp.setData(nomor);
                            break;
                        case "C":
                            System.out.print("Masukkan nomor yang ingin diganti : ");
                            input.nextLine();
                            qnomor = input.next() + " ";
                            if (kontak.tmp.nohp.find(qnomor)) {
                                System.out.print("Masukkan nomor baru : ");
                                input.nextLine();
                                nomor = input.next() + " ";
                                kontak.tmp.nohp.replace(qnomor, nomor);
                            } else {
                                System.out.println("Data tidak ditemukan");
                            }
                            break;
                        case "D":
                            System.out.print("Masukkan nomor yang ingin dihapus : ");
                            input.nextLine();
                            nomor = input.next() + " ";
                            kontak.tmp.nohp.remove(nomor);
                            break;
                        case "E":
                            System.out.print("Masukkan nama kontak yang ingin anda cari (Harap perhatikan huruf kapital kontak) : ");
                            input.nextLine();
                            q = input.nextLine() + " ";
                            findreplace(kontak, q);
                            break;
                        case "F":
                            break;
                        default:
                            System.out.println("ERROR, harap masukkan pilihan (A/B/C/D/E/F) !");
                            break;
                    }
                } while (!"F".equals(fitur));
            } else {
                System.out.println("Data tidak ditemukan !");
                findreplace(kontak, query);
            }
            System.out.println();
            input.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void menu(List kontak, String DataString) {
        try {
            String query;
            String selesai;
            String menu;
            Scanner input = new Scanner(System.in);
            do {
                System.out.println("Menu :");
                System.out.println("A) Tampilkan data kontak di textfile");
                System.out.println("B) Urutkan data kontak dan tampilkan");
                System.out.println("C) Cari data kontak");
                System.out.println("D) Keluar");
                System.out.print("Masukkan pilihan (A/B/C/D) : ");
                menu = input.next();
                switch (menu) {
                    case "A":
                        System.out.println(DataString + "\n");
                        if (kontak.head == null) {
                            System.out.println("Tidak ditemukan data dalam daftar kontak anda, tidak dapat melanjutkan program !");
                            selesai = "Y";
                            break;
                        }
                        break;
                    case "B":
                        System.out.println("\nSetelah data diurutkan :");
                        show(kontak);
                        break;
                    case "C":
                        System.out.print("Masukkan nama kontak yang ingin anda cari (Harap perhatikan huruf kapital kontak) : ");
                        input.nextLine();
                        query = input.nextLine() + " ";
                        findreplace(kontak, query);
                        System.out.println();
                        break;
                    case "D":
                        break;
                    default:
                        System.out.println("ERROR, harap masukkan pilihan (A/B/C/D) !");
                        break;
                }
            } while (!"D".equals(menu));
            input.close();
            System.out.println();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void show(List kontak) {
        System.out.println("DAFTAR KONTAK ANDA :");
        kontak.printNode();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List kontak = new List();
        List tp = new List();
        boolean found, empty;
        String A, B, X = " ", Y = " ";
        String DataString = "";

        File f = new File("daftarkontak.txt");

        try (Scanner inFile = new Scanner(f)) {

            while (inFile.hasNextLine()) {
                found = false;
                empty = false;
                Node temp = kontak.head;
                A = "";
                while (inFile.hasNext("[a-zA-Z]+")) {
                    A += inFile.next() + " ";
                }
                if (kontak.isEmpty()) {
                    empty = true;
                    kontak.setData(X);
                    kontak.head.nohp.setData(Y);
                }
                DataString += "\n" + A + ": ";
                while (temp != null) {
                    if (temp.data.equals(A)) {
                        while (inFile.hasNext("[0-9]+")) {
                            B = inFile.next() + " ";
                            temp.nohp.setData(B);
                            DataString += B;
                        }
                        found = true;
                        break;
                    }
                    temp = temp.next;
                }
                temp = kontak.head;
                if (!found) {
                    kontak.newData(A);
                    while (temp != null) {
                        if (temp.data.equals(A)) {
                            while (inFile.hasNext("[0-9]+")) {
                                B = inFile.next() + " ";
                                DataString += B;
                                temp.nohp.setData(B);
                            }
                            break;
                        }
                        temp = temp.next;
                    }
                }
            }
            inFile.close();
            kontak.removeFirst();

            menu(kontak, DataString);
        } catch (FileNotFoundException e) {
            System.out.println("Data kontak tidak ditemukan ! Silakan masukkan data kedalam folder Tugas2");
        }
        System.out.println("Terima kasih");
        input.close();
    }

}
