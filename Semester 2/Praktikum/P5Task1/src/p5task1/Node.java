package p5task1;

public class Node {
    private int value;
    public Node leftChild;
    public Node rightChild;
    
    Node(int value){
        this.value=value;
    }
    
    public int getValue(){
        return value;
    }
}
