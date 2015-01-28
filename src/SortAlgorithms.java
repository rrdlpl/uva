import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SortAlgorithms {
	
	public static void main(String []args) throws NumberFormatException, IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		int []a = new int[]{1,3,4,60,50,70};
		int []aux = new int[6];
		//for (int i = 0; i < a.length; i++) {
		//	a[i] = Integer.parseInt(in.readLine());
		//}
		
		mergeSort(a,aux, 0, a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	
	public static void mergeSort(int []a, int []aux, int start, int end){
		if(end-start <= 1)
			return;			
		int middle = start+ (end-start)/2;
		mergeSort(a, aux,start,middle);
		mergeSort(a, aux,middle, end);
		merge(a, aux, start, middle, end);
	}
	
	public static void merge(int []a, int []aux, int start, int mid, int end){
		int i = start, j = mid, k= start;
		while (i < mid && j < end && k <end) {
			if(a[i] < a[j]){
				aux[k] = a[i];
				i++;
			}else{
				aux[k] = a[j];
				j++;
			}
			k++;
		}
		while(i<mid && k<end){
			aux[k] = a[i];
			k++;
			i++;
		}
		while(j<end && k < end){
			aux[k] = a[j];
			k++;
			j++;
		}
		for (k = start; k < end; k++) {
			a[k] = aux[k];
		}
	}	
	
}
