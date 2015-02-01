import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class FroshWeek {
	
	static int [] array;
	static int [] aux;
	public static void main(String []args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		StringBuilder sb = new StringBuilder();
		while((line=in.readLine())!= null){
			int n = Integer.parseInt(line);
			array = new int[n];
			aux = new int[n];
			for (int i = 0; i < n; i++) {
				int st = Integer.parseInt(in.readLine());
				array[i] = st;				
			}
			sb.append(countInversionsAndMerge(0, n)).append("\n");			
		}		
		System.out.print(sb.toString());
		in.close();
		System.exit(0);
	}
	
	static long countInversionsAndMerge(int low, int high){
		if(high-low<=1) return 0;
		int mid = (high+low)>>1;
		long c = countInversionsAndMerge(low, mid); //left
		c += countInversionsAndMerge(mid, high); //right
		c += countSplitsAndSort(low, mid, high);
		return c;
			
	}

	private static long countSplitsAndSort(int low, int mid, int high) {
		// TODO Auto-generated method stub
		int i = low, j = mid, k= low;
		long c = 0;
		while(i<mid&&j<high&&k<high){
			if(array[i]<=array[j]){
				aux[k++] = array[i++];
			}else{
				aux[k++] = array[j++];
				c += mid-i; 
			}
		}
		while(i<mid&&k<high){
			aux[k++] = array[i++];
		}
		while(j<high&&k<high){
			aux[k++] = array[j++];
		}
		for (int l = low; l < high; l++) {
			array[l] = aux[l];
		}
		return c;
	}

}
