package tugas3joe;

import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;

public class Tugas3Joe {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        int start = 0, current = 0, index = 0;

        // Pertama, input nama file yang akan dibaca (tanpa .txt)
        Scanner input = new Scanner(System.in);
        System.out.println("Input file name (Default = 'text'): ");
        String filename = input.nextLine() + ".txt";

        // File dibaca dan dipakai untuk masukan data
        File inputfile = new File(filename);
        List contacts = new List();
        Scanner scan = new Scanner(inputfile);

        while (scan.hasNext()) {
            String storage = "";
            if(contacts.isEmpty()) {
                
            }
            // Membaca data yang mengandung alphabet
            while (scan.hasNext("[a-zA-Z]+")) {
                storage += scan.next() + " ";
                start++;
            }
            current = index;
            // Untuk memeriksa apabila ada nama yang sudah terdaftar
            for (int x = 0; x < current - 1; x++) {
                if (kontak[x].name.equals(storage)) {
                    current = x;
                }
            }
            if (current == index) {
                kontak[current].name = storage;
            }
            // Untuk membaca nomor dengan digit 0-9 dan +
            while (scan.hasNext("[0-9+]+")) {
                kontak[current].setContact(scan.next() + " ");
            }
            // Periksa apabila nama kontak tidak tersedia, maka max - 1
            // Bila ada namanya, maka index dilanjutkan untuk input berikutnya
            if (kontak[index].name == null) {
                index--;
            } else {
                index++;
                kontak[index] = new Contact();
            }
        }

    }

}
