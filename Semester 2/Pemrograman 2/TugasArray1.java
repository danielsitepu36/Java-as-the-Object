/* 
 * 	Made by:
 * 	Juandito Batara Kuncoro
 * 	18/427582/PA/18542
 */

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class TugasArray1 {
	private static Random rd = new Random();
	private static Scanner scan;
	
	private static void Sorting(float arr[], int n) {
		int min;
		float tmp;
	    for(int i=0;i<n-1;i++){
	    	min = i;
	    	for(int j=i+1;j<n;j++){
	    		if (arr[j] < arr[min]){
	    			min = j;
	    		}
	            }
	            tmp = arr[i];
	            arr[i] = arr[min];
	            arr[min] = tmp;
	}}

	private static int doSearch(float query, int low, int high, float arr[]) {
		int mid = low + (high-low) / 2;
		if (low <= high) {
			if (arr[mid] == query) {
				return mid;
			}
			if (arr[mid] > query) {
				return doSearch(query,low,(mid-1),arr);
			}
			return doSearch(query,(mid+1),high,arr);
		}  	
		return -1;
		}
	
	public static void main (String[] args){
		int done = 0, resultCont = 0, same = 0;
		float searchTarget = 0;
		scan = new Scanner(System.in);
		System.out.print("Input jumlah data IPK: ");
		int n = scan.nextInt();
		float[] IPKArray = new float[(n+1)];
		
		for (int i=0; i<n; i++) {
			IPKArray[i] = rd.nextFloat() * 4;
			IPKArray[i] = (float) (Math.round(IPKArray[i]*100) / 100.0);
			System.out.println((i+1) + ". " + IPKArray[i]);
		}
		
		Sorting(IPKArray, n);
		
		System.out.println("\nSetelah sort: ");
		for (int i=0; i<n; i++) {
			System.out.println((i+1) + ". " + IPKArray[i]);
		}
		
		do {
		try {
			System.out.println("\nInput nilai yang akan dicari: ");
			done = 1;
			searchTarget = scan.nextFloat();
		}
		catch(InputMismatchException e) {
			System.out.println("Wrong input datatype!");
			scan.next();
		}
		} while (done == 0);
		
		int result = doSearch(searchTarget,0,n,IPKArray);
		
		if (result != -1) {
			int check = 0;
            resultCont = result;
			do {
			    if (IPKArray[resultCont+1] == IPKArray[result]) {
                same++;
                resultCont++;
			    } else check = 1;
            } while (check == 0);
            System.out.println(same);
			if (resultCont != result) {
				System.out.println("Nilai " + searchTarget + " yang ditemukan adalah data ke-" + (result+1) + " hingga data ke-" + (result+same+1) + ".");
			} else System.out.println("Nilai " + searchTarget + " yang ditemukan adalah data ke-" + (result+1) + ".");
		} else System.out.println("Data tidak ditemukan!");
		scan.close();
}
}
