package tugas2pemrogjuan;

class Node {

    String data;
    Node next;
}

class List {

    Node head;
    Node tail;

    boolean isEmpty() {
        return (head == null);
    }

    void addLast(Node input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            tail.next = input;
            tail = input;
        }
    }

    void printNode() {
        Node temp;
        temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
