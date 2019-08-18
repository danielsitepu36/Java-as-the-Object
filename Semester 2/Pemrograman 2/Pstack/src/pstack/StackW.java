package pstack;

public class StackW {
    int top;
    int max_data = 100;
    String[] item = new String[max_data];
    public StackW(){
        top = -1;
    }//end of constructor
    public boolean isFull(){
        return(top==(max_data-1));
    }//end of isFull method
    public boolean isEmpty(){
        return(top==-1);
    }//end of isEmptyl method
    public void push(String data){
        if(!isFull()){
            item[++top] = data;
       }
        else{
            System.out.println("Stack sudah penuh");
        }
    }//end of push method
    public String pop(){
        if(!isEmpty()){
            String x = item[top--];
            return x;
        }else {
            System.out.println("Stack Masih Kosong!\n");
            return null;
        }
    }
    public void Display(){
        System.out.println("Isi Stack Adalah : ");
        for(int i=top; i>=0; i--){
            System.out.println(item[i]+" ");
        }
     }    
}
