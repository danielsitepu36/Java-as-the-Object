package tugas4;

//DANIEL SURANTA S - 18/424185/PA/18290
import java.util.Scanner;

public class Tugas4 {

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

        System.out.println("PROGRAM SORT STRING DENGAN BUCKETSORT");
        System.out.print("Masukkan jumlah kata yang diinginkan : ");
        int n = input.nextInt();
        System.out.print("Masukkan panjang kata yang diinginkan : ");
        int k = input.nextInt();

        String[] kata = new String[n];
        String[] hasil = new String[n];
        int h;
        int l = 1;

        //Declare the key of each bucket [A-Z]
        Bucket[] bucket = new Bucket[26];
        for (int i = 0; i < 26; i++) {
            bucket[i] = new Bucket((char) (i + 65));
        }

        //Create n random string with length = k
        for (int i = 0; i < n; i++) {
            kata[i] = randomAlphaNumeric(k);
            hasil[i] = kata[i];
        }

        System.out.println("Data Sebelum Sorting :");
        for (int i = 0; i < n; i++) {
            System.out.print(kata[i] + " ");
        }
        System.out.println("\n");

        //Sort char from k-1 to 0
        for (int i = (k - 1); i >= 0; i--) {
            System.out.println("BucketSort ke - " + l++ + " (Indeks char ke - " + (i + 1) + " : ");
            //Sort for n times
            for (int j = 0; j < n; j++) {
                //Sort to Bucket [A-Z]
                for (int m = 0; m < 26; m++) {
                    if (hasil[j].charAt(i) == bucket[m].key) {
                        bucket[m].insert(hasil[j]);
                    }
                }
            }
            //Return string from the top of each Bucket to Array [from last index]
            h = n - 1;
            for (int m = 25; m >= 0; m--) {
                while (bucket[m].i >= 0) {
                    hasil[h] = bucket[m].getTop();
                    h--;
                }
                //Remove bucket
                if (!bucket[m].data.isEmpty()) {
                    bucket[m].remove();
                }
            }
            //Print the steps for debugging
            for (int m = 0; m < n; m++) {
                System.out.print(hasil[m] + " ");
            }
            System.out.println();
        }

        System.out.println("\nHasil Sorting :");
        for (int i = 0; i < n; i++) {
            System.out.print(hasil[i] + " ");
        }
    }
}
