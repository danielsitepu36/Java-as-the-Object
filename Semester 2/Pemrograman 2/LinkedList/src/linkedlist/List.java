package linkedlist;

class Node {

    int data;
    Node next;
}

class List {

    Node head;
    Node tail;

    boolean isEmpty() {
        return (head == null);
    }

    void addFirst(Node input) {
        if (isEmpty()) {	//Jika linked list masih kosong,
            head = input;	//maka head dan tail sama dengan node input
            tail = input;
        } else {
            input.next = head;	//Jika linked list sudah berisi,
            head = input;	//maka input akan di depan dan menjadi head
        }
    }

    void addLast(Node input) {
        if (isEmpty()) {	//Jika linked list masih kosong,
            head = input;	//maka head dan tail sama dengan node input
            tail = input;
        } else {
            tail.next = input;	//Jika linked list sudah berisi,
            tail = input;	//maka input akan di belakang dan menjadi tail
        }
    }

    void insertAfter(int key, Node input) {
        Node temp = head;
        do {
            if (temp.data == key) {	//Jika data sama dengan key, maka input
                input.next = temp.next; //disambung diantara temp dan temp.next
                temp.next = input;
                System.out.println("Insert data is succeed.");
                break;	//dari temp --> temp.next menjadi :
            }			//temp --> input --> temp.next
            temp = temp.next;
        } while (temp != null);
    }

    void insertBefore(int key, Node input) {
        Node temp = head;
        while (temp != null) {
            if ((temp.data == key) && (temp == head)) {
                this.addFirst(input);
                /* jika insert pada awal linked list
 							maka call method addFirst */
                System.out.println("Insert data is succeed.");
                break;
            } else if (temp.next.data == key) {
                input.next = temp.next;	//dari temp --> temp.next menjadi
                temp.next = input;			//temp --> input --> temp.next
                System.out.println("Insert data is succeed.");
                break;
            }
            temp = temp.next;
        }
    }

    void insertSorted(Node input) {
        if (isEmpty()) {	//Jika linked list masih kosong,
            head = input;	//maka head dan tail sama dengan node input
            tail = input;
        } else {
            if (input.data < head.data) {
                this.addFirst(input);
            } else if (input.data > tail.data) {
                this.addLast(input);
            } else {
                Node t = head;
                while (t.next.data <= input.data) {
                    t = t.next;
                }
                input.next = t.next;
                t.next = input;
            }
        }
    }

    void removeFirst() {
        //Node temp = head;
        if (!isEmpty()) {
            if (head == tail) {		//jika element linked list hanya 1,
                head = tail = null;		//maka head dan tail menjadi null
            } //sehingga linked list kosong
            else {
                //temp = temp.next;		//memajukan temp ke temp.next
                head = head.next;		//kemudian head dipindah ke temp
            }
        } else {
            System.out.println("Data is empty!");
        }
    }

    void removeLast() {
        Node temp = head;
        if (!isEmpty()) {
            if (tail == head) {		//jika element linked list hanya 1
                head = tail = null;		//maka head dan tail menjadi null
            } //sehingga linked list kosong
            else {
                while (temp.next != tail) {
                    temp = temp.next;	//memajukan temp hingga satu elemen
                }						//sebelum tail.
                temp.next = null;		//temp.next di-null,dan jadi akhir LL
                tail = temp;		//tail dipindah ke temp
            }
        } else {
            System.out.println("Data is empty!");
        }
    }

    void remove(int key) {
        Node temp = head;
        if (!isEmpty()) {
            while (temp != null) {
                if (temp.next.data == key) {	//mengganti temp.next dengan
                    temp.next = temp.next.next; //temp.next.next
                    break;	//dari temp --> temp.next -->temp.next.next
                } //menjadi temp --> temp.next.next
                else if ((temp.data == key) && (temp == head)) {
                    this.removeFirst();//jika key berada pada awal linked list,
                    break;		//maka call method removeFirst
                }
                temp = temp.next;
            }
        } else {
            System.out.println("Data is empty!");
        }
    }

    void find(int key) {
        int i = 0;
        boolean found = false;
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                found = true;
                break;
            }
            i++;
            temp = temp.next;
        }
        if (found) {
            System.out.println(key + " is found at index " + i);
        } else {
            System.out.println("Data isn't found");
        }
    }

    int getLength(Node a) {
        int c = 0;
        Node t = a;
        while (t != null) {
            c++;
            t = t.next;
        }
        return c;
    }

    Node mergeR(Node a, Node b) {
        Node result;
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.data <= b.data) {
            result = a;
            result.next = mergeR(a.next, b);
        } else {
            result = b;
            result.next = mergeR(a, b.next);
        }
        return result;
    }

    Node merge(Node a, Node b) {
        Node result = null, temp, p = null;
        do {
            if (a.data <= b.data) {
                temp = a;
                a = a.next;
            } else {
                temp = b;
                b = b.next;
            }
            if (result == null && p == null) {
                result = temp;
                p = temp;
            } else {
                p.next = temp;
                p = p.next;
            }
        } while ((a != null) && (b != null));
        if (a == null) {
            p.next = b;
        }
        if (b == null) {
            p.next = a;
        }
        return result;
    }

    Node mergeSort(Node a) {
        if (a.next == null) {
            return a;
        } else {
            int mid = getLength(a) / 2;
            Node L1 = a;
            Node t = a;
            while (mid - 1 > 0) {
                t = t.next;
                mid--;
            }
            Node L2 = t.next;
            t.next = null;
            Node l1 = mergeSort(L1);
            Node l2 = mergeSort(L2);
            return merge(l1, l2);
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

    void sortedMerge(Node headA, Node headB) {
        /* a dummy first node to  
       hang the result on */
        Node Ltemp = new Node();
        List L1 = new List();

        /* tail points to the  
    last result node */
        Node lt = Ltemp;
        while (true) {

            /* if either list runs out,  
        use the other list */
            if (headA == null) {
                lt.next = headB;
                break;
            }
            if (headB == null) {
                lt.next = headA;
                break;
            }

            /* Compare the data of the two 
        lists whichever lists' data is  
        smaller, append it into tail and 
        advance the head to the next Node 
             */
            if (headA.data <= headB.data) {
                lt.next = headA;
                headA = headA.next;
            } else {
                lt.next = headB;
                headB = headB.next;
            }

            /* Advance the tail */
            lt = lt.next;
            L1.insertSorted(lt);
        }
        L1.printNode();
        /*Node temp;
        temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }*/
    }
}
