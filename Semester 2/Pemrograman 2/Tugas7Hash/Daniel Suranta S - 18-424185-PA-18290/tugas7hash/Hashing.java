package tugas7hash;

import java.util.LinkedList;
import java.util.Queue;

public class Hashing {

    private int size;
    private int[] Data;
    private int probeIndeks = 0;
    Queue<Integer> queue = new LinkedList<>();

    public Hashing(int n) {
        size = nextPrime(n);
        Data = new int[size];
        for (int i = 0; i < size; i++) {
            Data[i] = 0;
        }
        System.out.println("N = " + n);
        System.out.println("P = " + size);
    }

    private static boolean isPrime(int num) {
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        for (int i = 5; i <= Math.sqrt(num); i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    private static int nextPrime(int p) {
        while (true) {
            boolean prime = isPrime(p);
            if (prime) {
                break;
            }
            p++;
        }
        return p;
    }

    public int modMethod(int key) {
        return (key % size);
    }

    public void insert(int key) {
        int indexArr = modMethod(key);
        if (Data[indexArr] == 0) {
            Data[indexArr] = key;
        } else {
            queue.add(key);
        }
        probeIndeks++;
    }

    public void insertQueue() {
        int collision = queue.size();
        System.out.println("\nJumlah key bertabrakan: " + collision);
        while (!queue.isEmpty()) {
            int key = queue.poll();
            int Indeks = modMethod(key);
            while (Data[Indeks] != 0) {
                Indeks++;
                probeIndeks++;
                Indeks %= size;
            }
            Data[Indeks] = key;
        }
        System.out.println("Rerata probing = " + (float)(probeIndeks) / (float)(size));
    }

    public void find(int key) {
        int Indeks = modMethod(key);
        int findProbing = 0;
        int lastIndeks = Indeks - 1;
        if (lastIndeks < 0) {
            lastIndeks = size - 1;
        }
        while (Data[Indeks] != key && Data[Indeks] != 0) {
            Indeks++;
            Indeks %= size;
            findProbing++;
            if (Indeks == lastIndeks) {
                break;
            }
        }
        if (Data[Indeks] == key) {
            System.out.println("Key ditemukan pada indeks ke - " + Indeks);
        } else {
            System.out.println("Key tidak ditemukan !");
        }
        System.out.println(findProbing + " kali probing\n");
    }

    public void print() {
        System.out.print("Data = ");
        for (int i = 0; i < size; i++) {
            System.out.print(Data[i] + " ");
        }
        System.out.println();
    }
}
