package pertemuan5;

/**
 *
 * @author USER
 */
public class BST_Main {

    public static void main(String[] args) {
        BST bst=new BST();
        
        bst.addNode(new Node(5));
        bst.addNode(new Node(12));
        bst.addNode(new Node(4));
        bst.addNode(new Node(57));
        bst.addNode(new Node(8));
        bst.addNode(new Node(1));
        bst.addNode(new Node(2));
        bst.addNode(new Node(10));
        bst.addNode(new Node(3));
        bst.pre(bst.root);
        System.out.println("");
        bst.in(bst.root);
        System.out.println("");
        bst.post(bst.root);
        System.out.println("");
    }
    
}
