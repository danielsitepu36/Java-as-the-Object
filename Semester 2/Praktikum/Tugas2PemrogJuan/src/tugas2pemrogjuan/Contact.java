package tugas2pemrogjuan;

public class Contact {

    String name;
    List CP = new List();

    // Constructor
    public Contact() {

    }

    // Untuk print nomor
    public void printContact() {
        CP.printNode();
        System.out.println();
    }

    // Untuk penambahan kontak
    public void setContact(String nomor) {
        Node pos = new Node();
        pos.data = nomor;
        pos.next = null;
        CP.addLast(pos);
    }

    // Print semua kontak
    public void printEverything(int a, Contact[] kontak) {
        for (int i = 0; i < a; i++) {
            System.out.println("Name	: " + kontak[i].name);
            System.out.print("CP	: ");
            kontak[i].printContact();
        }
    }

    // Print data yang ditemukan
    public void printFound(int i, Contact[] kontak) {
        System.out.println("Index	: " + (i + 1));
        System.out.println("Name	: " + kontak[i].name);
        System.out.print("CP	: ");
        kontak[i].printContact();
    }

}
