/***
 * 10264 - The Most Potent Corner
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1205
 * @author R
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class MostPotentCorner {
	
	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    for (String s = in.readLine(); s != null; s = in.readLine()){
	    	int n = Integer.parseInt(s.trim());	    	
			int[] v = new int[1<<n];
			for (int i = 0; i < 1<<n; i++) {
				s = in.readLine();
				v[i] = Integer.parseInt(s);
			}
			System.out.println(getMostPotentCorner(v,n));
	    }		
	}
	
	private static int getMostPotentCorner(int[] v, int n) {
		int [] potencies = new int[1<<n]; 	
		for (int i = 0; i < v.length; i++) {
			int potencyOfCorner = potencyOfCorner(v, n, i);			
			potencies[i] = potencyOfCorner;			
		}
		int max = 0;
		for (int i = 0; i < potencies.length; i++) {
			int potencyOfCorner = getMaxSumOfPotencies(potencies, n, i);
			max = Math.max(max, potencyOfCorner);
		}
		return max;
	}

	private static int getMaxSumOfPotencies(int []v, int n, int i ) {
		int max =0;		
		for (int j = 0; j < n; j++) {
			int ady = i;
			ady ^= (1<<j);
			max = Math.max(max, v[ady]);
		}
		return max + v[i];
	}

	public static int potencyOfCorner(int []v, int n, int i){
		int sum = 0;
		for (int j = 0; j < n; j++) {
			int ady = i;
			ady ^= (1<<j);			
			sum += v[ady];
		}
		return sum;				
	}
	
	
}
