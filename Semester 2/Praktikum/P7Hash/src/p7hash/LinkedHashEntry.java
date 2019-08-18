package p7hash;

public class LinkedHashEntry {
    String key;
    int value;
    
    LinkedHashEntry next;
    
    LinkedHashEntry(String key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
