import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Sortsolo{
    public static class HeapSort { 
        public void sort(int arr[]){ 
            int len = arr.length; 
            for (int i = len / 2 - 1; i >= 0; i--) 
                heapify(arr, len, i); 
            for (int i=len-1; i>=0; i--) {
                int temp = arr[0]; 
                arr[0] = arr[i]; 
                arr[i] = temp;
                heapify(arr, i, 0); 
            } 
        } 
        void heapify(int arr[], int n, int i) { 
            int max = i;
            int l = 2*i + 1;
            int r = 2*i + 2;

            if (l < n && arr[l] > arr[max]) 
                max = l; 
            if (r < n && arr[r] > arr[max]) 
                max = r; 
            if (max != i) { 
                int swap = arr[i]; 
                arr[i] = arr[max]; 
                arr[max] = swap; 

                heapify(arr, n, max); 
            } 
        }
    }

    public static class MergeSort {
        public void sort(int[] arr) {
            int[] arr2 = new int[arr.length];
            mergeSort(arr, arr2, 0, arr.length - 1);
        }
    
        public void mergeSort(int[] arr, int[] arr2, int low, int high) {
            if (low < high) {
                int mid = low + (high - low) / 2;
                mergeSort(arr, arr2, low, mid);
                mergeSort(arr, arr2, mid + 1, high);
                if (arr[mid + 1] >= arr[mid]) {
                    return;
                }
                merge(arr, arr2, low, mid, high);
            }
        }
    
        public void merge(int[] arr, int[] arr2, int low, int mid, int high) {
            for (int k = low; k <= high; k++) {
                arr2[k] = arr[k];
            }
    
            int left = low, right = mid + 1;
            for (int k = low; k <= high; k++) {
                if (left > mid)
                    arr[k] = arr2[right++];
                else if (right > high)
                    arr[k] = arr2[left++];
                else if (arr2[right] < arr2[left])
                    arr[k] = arr2[right++];
                else
                    arr[k] = arr2[left++];
            }
        }
    }

    public static class QuickSort { 
        int partition(int arr[], int low, int high) { 
            int pv = arr[high];  
            int i = (low-1);
            for (int j=low; j<high; j++) { 
                if (arr[j] <= pv) { 
                    i++; 
                    int temp = arr[i]; 
                    arr[i] = arr[j]; 
                    arr[j] = temp; 
                } 
            } 
        
            int temp = arr[i+1]; 
            arr[i+1] = arr[high]; 
            arr[high] = temp; 
        
            return i+1; 
        } 

        void sort(int arr[], int low, int high) { 
            if (low < high) { 
                int pi = partition(arr, low, high); 
            
                sort(arr, low, pi-1); 
                sort(arr, pi+1, high); 
            } 
        }
    }

    public static void printTime(long starttime,long endtime){
        long time = endtime-starttime;
        long s = time/1000000000;
        time%=1000000000;
        long ms = time/1000000;
        time%=1000000;
        long ns = time;
        System.out.println("Sorting time : " + s + "." + ms + " Seconds ");
        System.out.println("Sorting time : " + s + "s " + ms + "ms " + ns + "ns");
    }

    public static void main(String[] args) throws NoSuchElementException{
        Scanner input = new Scanner(System.in);
        int i = 0;

        System.out.print("\nInput file name (number) : ");
        String name=input.next();

        File f = new File("randomNumber" + name + ".txt");
        try(Scanner inFile = new Scanner(f)){
            System.out.println("Data found !");
            System.out.print("Input data size : ");
            int size=input.nextInt();
    
            int[] Arr=new int[size];

            System.out.println("\nTransfering number... (may take seconds for big data)");
            while(inFile.hasNextInt()){
                Arr[i] = inFile.nextInt();
                i++;
            }
            inFile.close();
            System.out.println("Transfer success !");

            String menu;
            boolean end=false;
            long starttime;
            long endtime;
            System.out.println("\nSorting method :");
            System.out.println("A) Heap Sort");
            System.out.println("B) Merge Sort");
            System.out.println("C) Quick Sort");
            System.out.println("D) Exit");
            System.out.print("Your input (A/B/C/D) : ");
            menu = input.next();
            switch (menu) {
                case "A":
                    System.out.println("\nHEAP SORT STARTED");
                    starttime = System.nanoTime();
                    HeapSort HS = new HeapSort(); 
                    HS.sort(Arr); 
                    endtime = System.nanoTime();
                    System.out.println("SORTED !");
                    printTime(starttime, endtime);
                    break;
                case "B":
                    System.out.println("\nMERGE SORT STARTED");
                    starttime = System.nanoTime();
                    MergeSort MS = new MergeSort(); 
                    MS.sort(Arr); 
                    endtime = System.nanoTime();
                    System.out.println("SORTED !");
                    printTime(starttime, endtime);
                    break;
                case "C":
                    System.out.println("\nQUICK SORT STARTED");
                    starttime = System.nanoTime();
                    QuickSort QS = new QuickSort(); 
                    QS.sort(Arr,0,size-1); 
                    endtime = System.nanoTime();
                    System.out.println("SORTED !");
                    printTime(starttime, endtime);
                    break;
                case "D":
                    end=true;
                    break;
                default :
                    System.out.println("Wrong input ! Please input A/B/C/D !");
            }
        } catch (FileNotFoundException e) {
        System.out.println("Data not found ! Please put your file inside this folder !");
        }
        System.out.println("Thank you !");
        input.close();
    }
}