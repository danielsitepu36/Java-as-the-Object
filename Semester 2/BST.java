package pertemuan5;

class Node{
    public int val;
    public Node left;
    public Node right;
    public Node parent;
    
    public Node(int val){
        this.val=val;
    }
    public int getVal(){
        return val;
    }
}

public class BST {
    Node root;
    public boolean isEmpty(){
        return root==null;
    }
    public void addNode(Node in){
        if(isEmpty()){
            root=in;
        }
        else{
            insertNode(root, in);
        }
    }
    
    public void insertNode(Node parent,Node in){
        if(parent.left==null){
            if(parent.right==null){
                if(parent.getVal()>in.getVal()){
                    parent.left=in;
                }
                else parent.right=in;
            }
            else{
                if(parent.getVal()>in.getVal()){
                    parent.left=in;
                }
                else insertNode(parent.right,in);
            }
        }
        else if(parent.right==null){
            if(parent.getVal()>in.getVal()){
                    insertNode(parent.left,in);
            }
            else parent.right=in;
        }
        else{
            if(parent.getVal()>in.getVal()){
                    insertNode(parent.left,in);
            }
            else insertNode(parent.right,in);
        }
    }
    
    public boolean search(Node root,int q){
        if(root==null)return false;
        else{
            if(root.val==q){
                return true;
            }
            else if(root.val<q){
                return search(root.right,q);
            }
            else{
                return search(root.left,q);
            }
        }
    }
    
    public void pre(Node root){
        if(root!=null){
            System.out.print(root.val+" ");
            pre(root.left);
            pre(root.right);
        }
    }
    public void in(Node root){
        if(root!=null){
            pre(root.left);
            System.out.print(root.val+" ");
            pre(root.right);
        }
    }
    public void post(Node root){
        if(root!=null){
            pre(root.left);
            pre(root.right);
            System.out.print(root.val+" ");
        }
    }
    public boolean delete(int q){
        Node parent=root;
        Node current=root;
        
        if(isEmpty())return false;
        
        boolean left=false;
        //cari q
        while(current.getVal()!=q){
            parent=current;
            if(current==null)return false;
            if(current.getVal()>q){
                left=true;
                current=current.left;
            }
            else{
                left=false;
                current=current.right;
            }
        }
        //nochild
        if(current.left==null&&current.right==null){
            if(current==root) root=null;
            else if(left)parent.left=null;
            else parent.right=null;
        }
        //1childl
        else if(current.right==null){
            if(current==root) root=root.left;
            else if(left)parent.left=current.left;
            else parent.right=current.left;
        }
        //1childr
        else if(current.left==null){
            if(current==root) root=root.right;
            else if(left)parent.left=current.right;
            else parent.right=current.right;
        }
        //2child
        else{
            
        }
        return true;
    }
}
