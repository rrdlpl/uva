import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SortAlgorithms {
	
	public static void main(String []args) throws NumberFormatException, IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//int t = Integer.parseInt(in.readLine());
		int []a = new int[]{1,3,4,60,50,70};
		int []aux = new int[6];
		
		
		mergeSort(a,aux, 0, a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	
	public static void mergeSort(int []a, int []aux, int low, int high){
		if(high-low <= 1)
			return;			
		int middle =(high+low)/2;
		mergeSort(a, aux,low,middle);
		mergeSort(a, aux,middle, high);
		merge(a, aux, low, middle, high);
	}
	
	public static void merge(int []a, int []aux, int low, int mid, int high){
		int i = low, j = mid, k= low;
		while (i < mid && j < high && k <high)		
			aux[k++] = a[i]<a[j]? a[i++] : a[j++];
		while(i<mid && k<high)
			aux[k++] = a[i++];		
		while(j<high && k < high)
			aux[k++] = a[j++];			
		for (k = low; k < high; k++) 
			a[k] = aux[k];		
	}	
	
}
