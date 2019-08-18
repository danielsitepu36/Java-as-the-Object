package pqueue;

public class Queue {
    int front,rear;
    int max_data = 5;
    char[] item = new char[max_data];
    public Queue(){
        front = 0;rear=-1;
        for(int i=0;i<max_data;i++) item[i]=(char)48;
    }//end of constructor
    public void enqueueM(char data){
        if((item[(rear+1)%max_data])==(char)48) {
            rear=++rear % max_data;
            item[rear]=data ;}
        else{
            System.out.println("Queue Full");
        }
    }
    public char dequeueM(){
        if(item[front]==(char)48) {
            System.out.println("Empty");
            return 0;
        }
        else {
           char x=item[front] ;
           item[front]=(char)48;
           front=++front%max_data;
           return x;
        }
   }
    public void displayM(){
     for(int i=0;i<max_data;i++){
     if(item[(front+i)%max_data]!= (char)48){
        System.out.print(item[(front+i)%max_data]+" ");}
     }
     System.out.println();
   }

    public boolean isFull(){
        return(rear==(max_data-1));
    }//end of isFull method
    public boolean isEmpty(){
        return(front>rear);
    }//end of isEmptyl method
    public void enqueue(char data){
        if(!isFull()){
            item[++rear] = data;
       }
        else{
            System.out.println("Queue Full");
        }
    }//end of enqueue method
    public char dequeue(){
        if(!isEmpty()){
            char x = item[front++];
            return x;
        }else {
            System.out.println("Queue Kosong!\n");
            return 0;
        }
    }
    public char dequeueG(){
        if(!isEmpty()){
            char x = item[0];
            rear--;
            for(int i=0;i<=rear;i++) item[i]=item[i+1];
            return x;
        }else {
            System.out.println("Queue Kosong!\n");
            return 0;
        }
    }
    
    public void display(){
        System.out.println("Isi Queue Adalah : ");
        for(int i=front; i<=rear; i++){
            System.out.print(item[i]+" ");
        }
        System.out.println();
     }   
}
