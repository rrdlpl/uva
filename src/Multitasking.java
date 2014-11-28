/***
 * 11926 - Multitasking
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3077
 * 
 * @author R 
 */
public class Multitasking {
	
	public static void main(String [] args){
		
		int [] freePlaces = new int[31250];
		boolean canFill = true;
		int start = 0, end = 0;
		int n=0, m=0;
		for (int i = 0; i < n; i++) {
			//TODO read start, and end;
			if(!canFill) continue;
			int size = end - start;
			int index = start/32;
			if(size/32 > 0){
				canFill &= canFill(freePlaces, index, start,end, size/32);
			}
			else{
				canFill &= canFill(freePlaces, index, start,end);				
			}
		}		
	}
	
	public static boolean canFill(int[] freePlaces, int index, int start,
			int end, int size) {		
		
		boolean canFill = true;		
		canFill &= canFill(freePlaces, index, start % 32, 32);
		for (int i = index; i < index+size; i++) {
			if(!canFill) break;	
			canFill &= canFill(freePlaces, i,0, 32 % end);
		}		
		return canFill;
	}

	public static boolean canFill(int [] freePlaces, int index, int start, int end){
		int i = (1<<(end-start))-1; //we turn a range of bits to one
		i = i << (start);           //we move it n bits to the left
		boolean hasSpace = (freePlaces[index] & i) == 0; //boolean touchingBegin = (freePlaces[index]&(1<<j))!=0;
		freePlaces[index] |= i;											//boolean touchingEnd = (freePlaces[index]&(1<<k))!=0;
		if (hasSpace){
			 return true;
		 }
		 return false; 			   //There is place or touch

	}
	
	public static boolean isTouching(int freePlaces[], int start , int end){
		
		return (freePlaces[start>>5]&(1<<start%32 ))!=0 ||
			   (freePlaces[end>>5] & (1<<(32 % end)))!=0;
	}
	
	
	

}
