package tugas3;

class SubNode {

    String data;
    SubNode next;
    SubNode prev;
}

public class SubList {

    SubNode head;
    SubNode tail;
    SubNode tmp;

    int i = 0;

    boolean isEmpty() {
        return (head == null);
    }

    void addFirst(SubNode input) {
        if (isEmpty()) {	//Jika linked list masih kosong,
            head = input;	//maka head dan tail sama dengan node input
            tail = input;
        } else {
            input.next = head;	//Jika linked list sudah berisi,
            head.prev = input;
            head = input;	//maka input akan di depan dan menjadi head
        }
    }

    void addLast(SubNode input) {
        if (isEmpty()) {	//Jika linked list masih kosong,
            head = input;	//maka head dan tail sama dengan node input
            tail = input;
        } else {
            tail.next = input;	//Jika linked list sudah berisi,
            input.prev = tail;
            tail = input;	//maka input akan di belakang dan menjadi tail
        }
    }

    void insertAfter(String key, SubNode input) {
        SubNode temp = head;
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

    void insertBefore(String key, SubNode input) {
        SubNode temp = head;
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

    void insertSorted(SubNode input) {
        //Int check = input.data.compareTo(head.data);
        if (isEmpty()) {	//Jika linked list masih kosong,
            head = input;	//maka head dan tail sama dengan node input
            tail = input;
        } else {
            if (input.data.compareTo(head.data) < 0) {
                this.addFirst(input);
            } else if (input.data.compareTo(head.data) > 0) {
                this.addLast(input);
            } else {
                SubNode t = head;
                while (t.next.data.compareTo(input.data) <= 0) {
                    t = t.next;
                }
                input.next = t.next;
                t.next = input;
                input.prev = t;
                input.next.prev = input;
            }
        }
    }

    void removeFirst() {
        //SubNode temp = head;
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
        SubNode temp = head;
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
        SubNode temp = head;
        boolean found=false;
        if (!isEmpty()) {
            if ((temp.data.equals(key)) && (temp == head)) {
                this.removeFirst();
            } else {
                while (temp.next != null) {
                    if (temp.next.data.equals(key)) {
                        temp.next = temp.next.next;
                        found=true;
                        break;
                    }
                    temp = temp.next;
                }
            }
        } else {
            System.out.println("Data is empty!");
        }
        if(!found){
            System.out.println("Data tidak ditemukan!");
        }
    }

    boolean find(String key) {
        int left = 0;
        boolean found = false;
        SubNode temp = head;
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

    void replace(String query, String key) {
        SubNode temp = head;
        if (!isEmpty()) {
            if (temp.data.equals(key) && (temp == head)) {
                this.removeFirst();
                this.setFirst(key);
            } else {
                while (temp.next != null) {
                    if (temp.next.data.equals(query)) {
                        temp.next.data = key;
                        break;
                    }
                    temp = temp.next;
                }
            }
        } else {
            System.out.println("Data is empty!");
        }
    }

    int getLength(SubNode a) {
        int c = 0;
        SubNode t = a;
        while (t != null) {
            c++;
            t = t.next;
        }
        return c;
    }

    void printNode() {
        int x = 1;
        SubNode temp;
        temp = head;
        while (temp != null) {
            System.out.println("Nomor ke-" + x + " = " + temp.data);
            temp = temp.next;
            x++;
        }
        System.out.println();
    }

    public void setFirst(String isi) {
        SubNode x = new SubNode();
        x.data = isi;
        x.next = null;
        addFirst(x);
        i++;
    }

    public void setData(String isi) {
        SubNode x = new SubNode();
        x.data = isi;
        x.next = null;
        addLast(x);
        i++;
    }
}
