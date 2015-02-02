import java.util.Scanner;


public class Quicksort {

	public static void main(String []args){
		int []array = new int[10000];		
		Scanner in = new Scanner(System.in);	
		for (int i = 0; i < array.length &&in.hasNextInt(); i++) {
			array[i] = in.nextInt();			
		}
		System.out.println("Comparitions: "+quicksort(array, 0, array.length-1));
	}

	
	private static int quicksort(int[] array, int low, int high) {
		if(high-low<0)return 0;
		int piv = partition(array, low, high);
		int m= high-low;		
		m += quicksort(array, low, piv-1);
		m += quicksort(array, piv+1, high);	
		return m;
	}


	private static int partition(int[] array, int low, int high) {
		int piv = getPivotMedian(array,low, high);
		int pivote = array[piv];
		int i = low+1;
		swap(array, low, piv); //If not first
		for (int j = i; j <= high; j++) {
			if(array[j]<pivote){
				swap(array, j, i);
				i++;
			}			
		}
		swap(array,low,  --i);
		return i;
	}


	private static int getPivotMedian(int[]array,int low, int high) {
		int a = array[low];
		int med = (high+low)/2;
		int b = array[med];
		int c=  array[high];		
		int sum = a+b+c;
		int max = Math.max(a, Math.max(b, c));
		int min = Math.min(a, Math.min(b,c));
		sum = sum-max-min; 
		return sum == a? low: sum == c? high : med;
	}


	private static void swap(int[] array, int i, int j) {
		int aux = array[j];
		array[j] = array[i];
		array[i] = aux;
	}
	
	private static int anotherPartition(int []array, int low, int high){
		int piv = low; // getPivot
		int pivot = array[piv];
		int i = low+1;
		swap(array, piv, low);
		for (int j = i; j <= high; j++) {
			if (array[j]<pivot) {
				swap(array, i, j);
				i++;
			}
		}
		swap(array, low, --i);
		return i;
	}
}
