package pbucketsort;
class Node {
    char data;
    Node next; }
class List {
  Node head; Node tail;
  boolean isEmpty(){ return (head==null);}
  void enqueue(Node input){
    if (isEmpty()){	//Jika linked list masih kosong,
	head = input;	//maka head dan tail sama dengan node input
	tail = input;}
    else {
        tail.next = input; //Jika linked list sudah berisi,
	tail = input;}	//maka input akan di belakang dan menjadi tail
  }
  char dequeue(){
    if (!isEmpty()){
   	if (head == tail){
            char x=head.data;head = tail = null;//maka head dan tail menjadi null
            return x; }	//sehingga linked list kosong
   	else {
            char x=head.data;
            head = head.next;		//kemudian head dipindah ke temp
            return x;}
    }
    else {
        System.out.println("Queue is empty!");
        return 0;  }  
 }
       	void printNode(){
  		Node temp;
  		temp = head;
  		while (temp != null){
   			System.out.print(temp.data+" ");
   			temp = temp.next;
  		}
                System.out.println();
 	}
        
        
         void potong(List Q2){
            Node t=head;
            int n=1;
            while(t!=tail) {t=t.next;n++;}
            t=head;
            int mid=n/2;
            for(int i=1;i<mid;i++)t=t.next;
            if(n%2==1) Q2.head=t.next.next; else Q2.head=t.next;
            Q2.tail=tail;
            tail=t;
            t.next=null;
        }
}


