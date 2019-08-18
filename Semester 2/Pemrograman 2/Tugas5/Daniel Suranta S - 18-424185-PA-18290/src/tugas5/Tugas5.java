package tugas5;

//DANIEL SURANTA SITEPU
//18.424185.PA.18290
import java.util.Arrays;
import java.util.Scanner;

public class Tugas5 {

    private static final String ALPHA_NUM_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int c = (int) (Math.random() * ALPHA_NUM_STRING.length());
            builder.append(ALPHA_NUM_STRING.charAt(c));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m, k, n, l;

        System.out.println("PROGRAM MERGE STRING");
        System.out.print("Masukkan jumlah kata pada array A yang diinginkan : ");
        m = input.nextInt();
        while (true) {
            System.out.print("Masukkan panjang kata di array A yang diinginkan (Berapa char) : ");
            k = input.nextInt();
            if (m <= (Math.pow(26, k))) {
                break;
            }
            System.out.println("Tidak bisa input >" + (Math.pow(26, k)) + " kata untuk " + k + " char");
        }
        System.out.print("Masukkan jumlah kata pada array B yang diinginkan : ");
        n = input.nextInt();
        while (true) {
            System.out.print("Masukkan panjang kata di array B yang diinginkan (Berapa char) : ");
            l = input.nextInt();
            if (n <= (Math.pow(26, l))) {
                break;
            }
            System.out.println("Tidak bisa input >" + (Math.pow(26, l)) + " kata untuk " + l + " char");
        }

        String[] A = new String[m];
        String[] B = new String[n];
        String[] Hasil = new String[m + n];
        String temp;
        boolean found;

        for (int i = 0; i < m; i++) {
            found = false;
            temp = randomAlphaNumeric(k);
            for (int j = 0; j < i; j++) {
                if (temp.equals(A[j])) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                A[i] = temp;
            } else {
                i--;
            }
        }
        for (int i = 0; i < n; i++) {
            found = false;
            temp = randomAlphaNumeric(l);
            for (int j = 0; j < i; j++) {
                if (temp.equals(B[j])) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                B[i] = temp;
            } else {
                i--;
            }
        }

        Arrays.sort(A);
        Arrays.sort(B);

        System.out.print("\nIsi array A terurut = ");
        for (int i = 0; i < m; i++) {
            System.out.print(A[i] + ", ");
        }

        System.out.print("\nIsi array B terurut = ");
        for (int i = 0; i < n; i++) {
            System.out.print(B[i] + ", ");
        }

        int x = 0, y = 0, h = 0;
        while (true) {
            if (m == 0) {
                while (n != 0) {
                    Hasil[h++] = B[y++];
                    n--;
                }
                break;
            } else if (n == 0) {
                while (m != 0) {
                    Hasil[h++] = A[x++];
                    m--;
                }
                break;
            }
            if (A[x].compareTo(B[y]) < 0) {
                Hasil[h++] = A[x++];
                m--;
            } else if (A[x].compareTo(B[y]) > 0) {
                Hasil[h++] = B[y++];
                n--;
            } else {
                Hasil[h++] = A[x++];
                y++;
                m--;
                n--;
            }
        }
        System.out.print("\nHasil = ");
        for (int i = 0; i < h; i++) {
            System.out.print(Hasil[i] + " ");
        }
    }

}
