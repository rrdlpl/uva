
import java.io.IOException;
import java.util.Scanner;



public class CountInversion {

	static int []array;
	static int []aux;
	
	public static void main(String []args) throws IOException{
		array = new int[100000];
		aux = new int[100000];
		Scanner in = new Scanner(System.in);
		
		for (int i = 0; i < array.length &&in.hasNextInt(); i++) {
			array[i] = in.nextInt();
			
		}
		System.out.print(countInversions(0, array.length));
		in.close();
		System.exit(0);
	}
	
	public static long countInversions(int low, int high){
		if(high-low<= 1) return 0;
		int mid =(high+low)/2;
		long li = countInversions(low, mid);
		long ri = countInversions(mid, high);
		long spInv = countSplitInversion(low, mid, high);
		return li+ri+spInv;
		
	}

	private static  long countSplitInversion(int low, int mid, int high) {
		// TODO Auto-generated method stub
		int i = low, j = mid, k = low;
		long count = 0;
		while(i < mid && j< high &&k<high){
			if(array[i]<array[j]){
				aux[k++] =array[i++];				
			}else if(array[i]> array[j]){
				aux[k++] = array[j++];
				count += mid -i;
			}
		}
		while(i<mid&&k<high){
			aux[k++] = array[i++];
		}
		while(j<high&&k<high){
			aux[k++] =array[j++];			
		}
		for (int l = low; l < high; l++) {
			array[l] = aux[l];
		}
		
		return count;
	}
}
