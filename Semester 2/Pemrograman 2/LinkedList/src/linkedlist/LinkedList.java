package linkedlist;

import java.util.Scanner;
import java.util.Random;

public class LinkedList {

    public static void main(String[] args) {
        //List L=new List();
        List L = new List();
        List L2= new List();
        Scanner input = new Scanner(System.in);
        System.out.print("banyak data = ");
        int n = input.nextInt();
        Random r = new Random();
        for (int i = 1; i <= n; i++) {
            int rd = r.nextInt(100) + 1;
            Node p = new Node();
            p.data = rd;
            p.next = null;
            //L.InsertSorted(p);
            //L.addFirst(p);
            //L.addLast(p);
            //L.insertAfterFirst(p);
            L.insertSorted(p);
            System.out.print(rd + " ");
        }
        System.out.println();
        for (int i = 1; i <= n; i++) {
            int rd = r.nextInt(100) + 1;
            Node p2 = new Node();
            p2.data = rd;
            p2.next = null;
            //L.InsertSorted(p);
            //L.addFirst(p);
            //L.addLast(p);
            //L.insertAfterFirst(p);
            L2.insertSorted(p2);
            System.out.print(rd + " ");
        }
        System.out.println();
        System.out.println("Sorted = \n");
        L.printNode();
        L2.printNode();
        //System.out.print(" data key = ");
        //int k = input.nextInt();
        //Node q=new Node();q.data=101;q.next=null;
        //L.insertBefore(k,q);
        //L.remove(k);
        //L.find(k);
        //System.out.println();
        // double start=System.nanoTime();
        //L.head=L.mergeSort(L.head);
        //double finish=System.nanoTime();
        // System.out.println("waktu proses = "+(finish-start)/1.0E9+" detik");
        //System.out.println(L.getLength(L.head));
        // L.printNode();
        L.sortedMerge(L.head, L2.head);
    }
}
