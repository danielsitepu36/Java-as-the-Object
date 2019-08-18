package pstack;
public class Stack {
    int top;
    int max_data = 100;
    char[] item = new char[max_data];
    public Stack(){
        top = -1;
    }//end of constructor
    public boolean isFull(){
        return(top==(max_data-1));
    }//end of isFull method
    public boolean isEmpty(){
        return(top==-1);
    }//end of isEmptyl method
    public void push(char data){
        if(!isFull()){
            item[++top] = data;
       }
        else{
            System.out.println("Stack sudah penuh");
        }
    }//end of push method
    public char pop(){
        if(!isEmpty()){
            char x = item[top--];
            return x;
        }else {
            System.out.println("Stack Masih Kosong!\n");
            return 0;
        }
    }
    public void Display(){
        System.out.println("Isi Stack Adalah : ");
        for(int i=top; i>=0; i--){
            System.out.println(item[i]);
        }
     }
}
