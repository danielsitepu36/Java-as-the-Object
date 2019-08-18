 package p5task1;

public class BinaryTree {

    public Node root;

    public void addNode(Node node) {
        if (root == null) {
            root = node;
        } else {
            insertNode(root, node);
        }
    }

    private void insertNode(Node parent, Node node) {
        if (parent.getValue() > node.getValue()) {
            if (parent.leftChild == null) {
                parent.leftChild = node;
            } else {
                insertNode(parent.leftChild, node);
            }
        } else {
            if (parent.rightChild == null) {
                parent.rightChild = node;
            } else {
                insertNode(parent.rightChild, node);
            }
        }
    }

    public static boolean searchValue(Node root, int value) {
        if (root == null) {
            return false;
        } else {
            if (root.getValue() == value) {
                return true;
            } else if (root.getValue() > value) {
                return searchValue(root.leftChild, value);
            } else {
                return searchValue(root.rightChild, value);
            }
        }
    }

    public void display(Node root) {
        if (root != null) {
            display(root.leftChild);
            System.out.print(root.getValue() + " ");
            display(root.rightChild);
        }
    }

    public Node RightMin(Node node){
        while(node.leftChild != null){
            node = node.leftChild;
        }
        return node;
    }
    
    public boolean delete(int value) {
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;

        //Check Left / Right
        while (current.getValue() != value) {
            parent = current;
            if (current.getValue() > value) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }

        if (current.leftChild == null && current.rightChild == null) {
            if (current.equals(root)) {
                root = null;
            }
            if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.leftChild == null) {
            if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else if (current.rightChild == null) {
            if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else {
            Node RM = RightMin(current.rightChild);
            Node RMx = new Node(RM.getValue());
            if(isLeftChild){
                RMx.leftChild = parent.leftChild.leftChild;
                parent.leftChild = RMx;
            } else{
                RMx.rightChild = parent.rightChild.rightChild;
                parent.rightChild = RMx;
            }
            delete(RM.getValue());
        }
        return true;
    }
}
