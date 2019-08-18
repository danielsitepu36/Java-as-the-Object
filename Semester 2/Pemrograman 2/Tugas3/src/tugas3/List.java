package tugas3;

class Node {

    SubList nohp = new SubList();
    String data;
    Node next;
    Node prev;
}

class List {

    Node head;
    Node tail;
    Node tmp;

    int i = 0;

    boolean isEmpty() {
        return (head == null);
    }

    void addFirst(Node input) {
        if (isEmpty()) {	//Jika linked list masih kosong,
            head = input;	//maka head dan tail sama dengan node input
            tail = input;
        } else {
            input.next = head;	//Jika linked list sudah berisi,
            head.prev = input;
            head = input;	//maka input akan di depan dan menjadi head
        }
    }

    void addLast(Node input) {
        if (isEmpty()) {	//Jika linked list masih kosong,
            head = input;	//maka head dan tail sama dengan node input
            tail = input;
        } else {
            tail.next = input;	//Jika linked list sudah berisi,
            input.prev = tail;
            tail = input;	//maka input akan di belakang dan menjadi tail
        }
    }

    void insertAfter(String key, Node input) {
        Node temp = head;
        do {
            if (temp.data.equals(key)) {	//Jika data sama dengan key, maka input
                input.prev = temp;
                input.next = temp.next; //disambung diantara temp dan temp.next
                temp.next = input;
                System.out.println("Insert data is succeed.");
                break;	//dari temp --> temp.next menjadi :
            }			//temp --> input --> temp.next
            temp = temp.next;
        } while (temp != null);
    }

    void insertBefore(String key, Node input) {
        Node temp = head;
        while (temp != null) {
            if ((temp.data.equals(key)) && (temp == head)) {
                this.addFirst(input);
                /* jika insert pada awal linked list
 							maka call method addFirst */
                System.out.println("Insert data is succeed.");
                break;
            } else if (temp.next.data.equals(key)) {
                input.prev = temp;
                input.next = temp.next;	//dari temp --> temp.next menjadi
                temp.next = input;			//temp --> input --> temp.next
                System.out.println("Insert data is succeed.");
                break;
            }
            temp = temp.next;
        }
    }

    void insertSorted(Node input) {
        //Int check = input.data.compareTo(head.data);
        if (isEmpty()) {	//Jika linked list masih kosong,
            head = input;	//maka head dan tail sama dengan node input
            tail = input;
        } else {
            if (input.data.compareTo(head.data) < 0) {
                this.addFirst(input);
            } else if (input.data.compareTo(tail.data) > 0) {
                this.addLast(input);
            } else {
                Node t = head;
                while (input.data.compareTo(t.next.data) > 0) {
                    t = t.next;
                }
                input.next = t.next;
                t.next = input;
                input.prev = t;
                input.next.prev = input;
            }
        }
        tmp=input;
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
                head.prev = null;
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
                //temp.prev = tail;
                temp.next = null;		//temp.next di-null,dan jadi akhir LL
                tail = temp;		//tail dipindah ke temp
            }
        } else {
            System.out.println("Data is empty!");
        }
    }

    void remove(String key) {
        Node temp = head;
        if (!isEmpty()) {
            while (temp != null) {
                if (temp.next.data.equals(key)) {	//mengganti temp.next dengan
                    temp.next = temp.next.next; //temp.next.next
                    temp.next.prev = temp;
                    break;	//dari temp --> temp.next -->temp.next.next
                } //menjadi temp --> temp.next.next
                else if ((temp.data.equals(key)) && (temp == head)) {
                    this.removeFirst();//jika key berada pada awal linked list,
                    break;		//maka call method removeFirst
                }
                temp = temp.next;
            }
        } else {
            System.out.println("Data is empty!");
        }
    }

    boolean find(String key) {
        int left = 0;
        boolean found = false;
        Node temp = head;
        int right = getLength(temp);
        int middle, tomiddle = 0, x;
        while (!found && left <= right) {
            middle = (left + right) / 2;
            if (middle > tomiddle) {
                for (x = 0; x < middle - tomiddle; x++) {
                    temp = temp.next;
                }
            } else {
                for (x = 0; x < tomiddle - middle; x++) {
                    temp = temp.prev;
                }
            }
            tomiddle = middle;
            if (temp.data.compareToIgnoreCase(key) < 0) {
                left = middle + 1;
            } else if (temp.data.equalsIgnoreCase(key)) {
                found = true;
                tmp = temp;
            } else {
                right = middle - 1;
            }
        }
        if (!found) {
            return false;
        }
        else return found;
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

    void printNode() {
        Node temp;
        temp = head;
        while (temp != null) {
            System.out.print(temp.data + ": \n");
            temp.nohp.printNode();
            temp = temp.next;
        }
        System.out.println();
    }

    public void setData(String isi) {
        i++;
        Node x = new Node();
        x.data = isi;
        x.next = null;
        addLast(x);
    }

    public void newData(String isi) {
        Node s = new Node();
        s.data = isi;
        s.next = null;
        insertSorted(s);
    }
}
