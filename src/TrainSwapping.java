import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class TrainSwapping {
		static int []array;
		static int []aux;
		
		public static void main(String []args) throws IOException{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer tk = new StringTokenizer(in.readLine());
			int t = Integer.parseInt(tk.nextToken());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < t; i++) {
				tk = new StringTokenizer(in.readLine());
				int n = Integer.parseInt(tk.nextToken());
				array = new int[n];
				aux = new int[n];
				tk = new StringTokenizer(in.readLine());
				for (int j = 0; j < n; j++) {
					array[j] = Integer.parseInt(tk.nextToken());
				}
				sb.append("Optimal train swapping takes ").append(countInversions(0, n)).append(" swaps.\n");
			}
			System.out.println(sb.toString());
			in.close();
			System.exit(0);
		}
		
		public static int countInversions(int low, int high){
			if(high-low<= 1) return 0;
			int mid =(high+low)/2;
			int li = countInversions(low, mid);
			int ri = countInversions(mid, high);
			int spInv = countSplitInversion(low, mid, high);
			return li+ri+spInv;
			
		}

		private static  int countSplitInversion(int low, int mid, int high) {
			// TODO Auto-generated method stub
			int i = low, j = mid, k = low;
			int count = 0;
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
