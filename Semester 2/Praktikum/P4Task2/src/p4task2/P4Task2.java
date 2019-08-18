package p4task2;

import java.util.Scanner;

public class P4Task2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        QueueInit q = new QueueInit(6);
        
        q.insert(10);
        q.insert(2);
        q.insert(3);
        q.insert(15);
        q.insert(2);
        q.insert(4);
        
        q.remove();     //remove 10
        
        q.insert(4);
        
        q.remove();     //remove 2
        
        q.insert(10);
        q.insert(5);
        q.display();
        q.Sum();
    }

}
    