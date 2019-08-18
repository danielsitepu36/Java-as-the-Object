package p6heap;

public class P6Heap {

    public static void main(String[] args) {
        Heap heap = new Heap(7);
        heap.insert(6);
        heap.insert(10);
        heap.insert(5);
        heap.insert(3);
        heap.insert(12);
        heap.insert(14);
        heap.insert(9);

        heap.displayHeap();

        System.out.print("Removed (Heap Sort): ");
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();

        System.out.println();
        heap.displayHeap();
    }

}
