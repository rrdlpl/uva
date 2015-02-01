import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class UltraQuicksort {

	static long []array;
	static long []aux;

	public static void main(String []args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		StringBuilder sb = new StringBuilder();
		while(n!=0){                                                                                      
			array = new long[n];
			aux = new long[n];                                         
			for (int j = 0; j < n; j++) {
				tk = new StringTokenizer(in.readLine());
				array[j] = Integer.parseInt(tk.nextToken());
			}
			sb.append(countInversions(0, n)).append("\n");
			tk = new StringTokenizer(in.readLine());
			n = Integer.parseInt(tk.nextToken());
		}
		System.out.print(sb.toString());
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
			if(array[i]<=array[j]){
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