package tugas2;

public class Kontak {

    String nama;
    List listhp = new List();
    Node hp = new Node();
    int i=0;

    public Kontak() {
    }

    public void setPhone(String hp) {
        i++;
        Node HP = new Node();
        HP.data = hp;
        HP.next = null;
        listhp.addLast(HP);
    }
    
    public void showPhone(){
        listhp.printNode();
    }
}
