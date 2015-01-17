import java.io.IOException;
import java.util.Scanner;

/***
 * 11926 - Multitasking
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3077
 * 
 * @author R 
 */
public class Multitasking {
	
	public static class RBitSet{	
		
		
		private static final int nBits = 32;
		public int [] bitset; 
		public RBitSet(int n){		
			bitset = new int[(n>>5)+1]; //n/32
		}
		
		public boolean isOn(int i){
			int t = bitset[(i>>5)]&(1<<(i % nBits));
			return t !=0;
		}
		
		public void turnOn(int j){
			int t = (1<<j % nBits);
			bitset[j>>5] |= t;
		}
		
		public boolean isAnyOn(int start, int end){		
			boolean ans = false;
			if(start == end) return isOn(start);
			for (int i = start; i <= end; i++) {
				if(ans) break;			
				ans |=isOn(i);
			}		
			return ans;		
		}	
		
		public void turnOn(int start,int end){
			if(start==end)			
				turnOn(start);
			
			for (int i = start; i <= end; i++) {			
				turnOn(i);
			}		
		}
		
		public boolean isAllOn(){
			boolean ans = true;
			for (int i = 1; i < bitset.length-1; i++) {
				if(!ans) break;
				ans &= (bitset[i]== Integer.MAX_VALUE);
			}
			return ans;
		}
	}
	
	public static void main(String [] args) throws IOException{
		
		RBitSet bitset = new Multitasking.RBitSet(1000000);
		boolean conflict = false;	
		StringBuilder sb = new StringBuilder();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		
		while(!(m==0&&n==0)){		
			//one time tasks
			for (int i = 0; i < n; i++) {				
				int start = in.nextInt();
				int end = in.nextInt();
				if(conflict) continue;
				conflict = isThereConflict(bitset, conflict, start, end);
			}			
			for (int i = 0; i < m ; i++) {
				int start = in.nextInt();
				int end = in.nextInt();
				int interval = in.nextInt();
				if(conflict) continue;
				for (int j = 0 ; j*interval*(start+end) <= 1000000 ; j++) {
					int localStart = (start +j*interval);
					int localEnd = Math.min(1000000,j*interval + end);					
					conflict = isThereConflict(bitset, conflict, localStart, localEnd);
					if(conflict) {											
						break;						
					}
				}				
			}			
			sb.append(conflict? "CONFLICT\n" :"NO CONFLICT\n");
			conflict = false;		
			n = in.nextInt();
			m = in.nextInt();
			bitset = new RBitSet(1000000);			
		};
		in.close();
		
		System.out.print(sb.toString());
	}

	private static boolean isThereConflict(RBitSet bitset, boolean conflict,int start, int end) {
		if(bitset.isOn(start)&&bitset.isOn(end)){
			conflict |= end-start > 1? bitset.isAnyOn(start+1, end-1):true;
		}else if(bitset.isOn(start)){
			conflict |= bitset.isAnyOn(start+1, end);
		}else if (bitset.isOn(end)) {
			conflict |= bitset.isAnyOn(start, end-1);
		}else {
			conflict |= bitset.isAnyOn(start, end);
		}		
		if(!conflict) {
			bitset.turnOn(start, end);
		}
		return conflict;
	}
}
