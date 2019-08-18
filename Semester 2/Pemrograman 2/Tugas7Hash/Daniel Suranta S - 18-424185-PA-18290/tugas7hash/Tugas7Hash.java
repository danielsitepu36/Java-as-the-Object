package tugas7hash;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Scanner;

/*DANIEL SURANTA SITEPU
18/424185/PA/18290 */

public class Tugas7Hash {

    public static void main(String[] args) throws NoSuchProviderException, NoSuchAlgorithmException {
        Scanner scan = new Scanner(System.in);
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
        System.out.print("Masukkan nilai N = ");
        int N = scan.nextInt();
        Hashing hashTable = new Hashing(N);
        for (int i = 0; i < N; i++) {
            hashTable.insert(random.nextInt(99999) + 1);
        }
        System.out.println("Data sebelum queue dimasukkan = ");
        hashTable.print();
        hashTable.insertQueue();
        System.out.println("Data setelah queue dimasukkan = ");
        hashTable.print();
        System.out.println();
        while (true) {
            System.out.println("Masukkan 0 untuk keluar");
            System.out.print("Masukkan key yang ingin dicari = ");
            int find;
            try {
                find = scan.nextInt();
            } catch (Exception e) {
                scan.nextLine();
                continue;
            }
            if (find == 0) {
                break;
            }
            hashTable.find(find);
        }
        scan.close();
    }
}
