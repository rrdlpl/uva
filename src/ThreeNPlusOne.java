import java.io.IOException;
import java.util.Scanner;
public class ThreeNPlusOne {

	

		private static boolean isOn(int s, int j){
			return (s & (1<<j))!=0;		
		}

		private static boolean isPair(int n) {
			return !isOn(n, 0);
		}
		private static int getCycleLength(int n){
			if(n == 1) return n;
			if (isPair(n))
				return 1+getCycleLength(n>>1);			
			else
				return 1+getCycleLength(3*n+1);	
			
		}
		
		public static int getMaxCycleLength(int i, int j){
			int max = 0;
			for(int k = i; k<=j;k++){
				max = Math.max(max, getCycleLength(k));
			}
			return max;
		}	
		
		public static void main(String [] args) throws IOException{
			
				 Scanner in = new Scanner(System.in);
				 
				 while (in.hasNextInt()) {
					int i =  in.nextInt();
					int j = in.nextInt();				
					
					int from = Math.min(i,j);
					int to = Math.max(i, j);
					int maxCycleLength = getMaxCycleLength(from, to);
					String ans = i+" "+j+" "+ maxCycleLength;
					System.out.println(ans);
				 }
				 in.close();
		}

	

}
