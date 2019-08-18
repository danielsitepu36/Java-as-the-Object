
package p5task1;

public class P5Task1 {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        
        bt.addNode(new Node(10));
        bt.addNode(new Node(5));
        bt.addNode(new Node(20));
        bt.addNode(new Node(3));
        bt.addNode(new Node(15));
        bt.addNode(new Node(30));
        bt.addNode(new Node(19));
        
        System.out.println(BinaryTree.searchValue((bt.root), 5));
        
        bt.delete(3);
        bt.display(bt.root);
    }   
}
