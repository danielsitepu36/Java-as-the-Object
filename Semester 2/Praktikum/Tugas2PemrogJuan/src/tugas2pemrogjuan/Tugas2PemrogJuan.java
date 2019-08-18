package tugas2pemrogjuan;

/* Created by:
 * Juandito Batara K.
 * 18/427582/PA/18542
 */
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;

public class Tugas2PemrogJuan {
    // Untuk sorting data
    public static void selectSort(int index, Contact[] kontak) {
        Contact[] temp = new Contact[2];
        int min;
        for (int i = 0; i < index - 1; i++) {
            min = i;
            for (int j = i + 1; j < index; j++) {
                if (kontak[i].name.compareTo(kontak[j].name) > 0) {
                    min = j;
                    temp[1] = kontak[min];
                    kontak[min] = kontak[i];
                    kontak[i] = temp[1];
                }
            }
        }
    }

    // Untuk searching nama data
    public static void doSearch(int index, String nama, Contact[] kontak) {
        int i = 0;
        boolean found = false;
        System.out.println("\n\nSearching name...\n");
        for (i = 0; i < index; i++) {
            if (kontak[i].name.contains(nama)) {
                found = true;
            }
            if (found) {
                System.out.println("Data Found!");
                kontak[0].printFound(i, kontak);
                break;
            }
        }
        if (!found) {
            System.out.println("Data not found!");
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        int start = 0, current = 0, index = 0;

        // Pertama, input nama file yang akan dibaca (tanpa .txt)
        Scanner input = new Scanner(System.in);
        System.out.println("Input file name (Default = 'text'): ");
        String filename = input.nextLine() + ".txt";

        // File dibaca dan dipakai untuk masukan data
        File inputfile = new File(filename);
        Contact[] kontak = new Contact[999];
        Scanner scan = new Scanner(inputfile);

        while (scan.hasNext()) {
            String storage = "";
            kontak[start] = new Contact();
            // Membaca data yang mengandung alphabet
            while (scan.hasNext("[a-zA-Z]+")) {
                storage += scan.next() + " ";
                start++;
            }
            current = index;
            // Untuk jaga-jaga apabila terdapat nama yang diulang
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
            if (kontak[index].name == null) {
                index--;
            } else {
                index++;
                kontak[index] = new Contact();
            }
        }

        // Print data yang belum di-sort
        System.out.println("Data textfile:\n");
        kontak[0].printEverything(index, kontak);
        scan.close();

        // Sorting dan print data
        selectSort(index, kontak);
        System.out.println("\nData setelah sorting:\n");
        kontak[0].printEverything(index, kontak);

        // Bagian untuk searching
        System.out.println("Input nama orang yang akan dicari (Case Sensitive): ");
        String search = input.nextLine() + " ";
        doSearch(index, search, kontak);
        input.close();
    }
}
