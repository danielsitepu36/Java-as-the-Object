package p4task2;

public class QueueInit {

    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public QueueInit(int s) // constructor
    {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(long j) // put item at rear of queue
    {
        if (!this.isFull()) {
            if (rear == maxSize - 1) // deal with wraparound
            {
                rear = -1;
            }
            queArray[++rear] = j; // increment rear and insert
            nItems++; // one more item
        }
        else{
            System.out.println("Queue is full for inserting " + j);
        }
    }

    public long remove() // take item from front of queue
    {
        long temp = queArray[front++]; // get value and incr front
        if (front == maxSize) // deal with wraparound
        {
            front = 0;
        }
        nItems--; // one less item
        return temp;
    }

    public long peekFront() // peek at front of queue
    {
        return queArray[front];
    }

    public boolean isEmpty() // true if queue is empty
    {
        return (nItems == 0);
    }

    public boolean isFull() // true if queue is full
    {
        return (nItems == maxSize);
    }

    public int size() // number of items in queue
    {
        return nItems;
    }
    
    public void display(){
        int i=front;
        for(int x=0;x<nItems;x++){
            System.out.print(queArray[i++]+" ");
            if(i==nItems && rear<i){
                i=0;
            }
        }
    }
    
    public void Sum(){
        int i=front;
        long sum=0;
        for(int x=0;x<nItems;x++){
            sum+=queArray[i++];
            if(i==nItems && rear<i){
                i=0;
            }
        }
        System.out.println("\n" + sum);
    }
}
