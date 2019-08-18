package p4task1;

public class StackInit {
    private final int maxSize;
    private final char[] stackArray;
    private int top;
    
    public StackInit(int s){
        maxSize=s;
        stackArray = new char[maxSize];
        top=-1;
    }
    
    public void push(char j){
        stackArray[++top]=j;
    }
    
    public char pop(){
        return stackArray[top--];
    }
    
    public boolean isEmpty(){
        return(top==-1);
    }
}
