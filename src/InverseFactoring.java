
/***
 * SRM 425  
 * @author R
 *
 */
public class InverseFactoring {

	public int getTheNumber(int[] factors){
		int [] aux = new int[factors.length];
		mergeSort(factors, aux, 0, factors.length);
		
		
		return factors[0]*aux[factors.length-1];
	}
	
	private void mergeSort(int[] factors, int[] aux, int start, int end) {
		// TODO Auto-generated method stub
		if(end-start <= 1) return;
		int middle = start+(end-start)/2;
		
		mergeSort(factors, aux, start, middle);
		mergeSort(factors, aux, middle, end);
		merge(factors, aux, start, middle,end);
	}

	private void merge(int[] factors, int[] aux, int start, int middle, int end) {
		int i = start, j = middle , k=start;
		while (i<middle && j<end &&k<end) {
			if(factors[i]>factors[j]){
				aux[k] = factors[j];				
				j++;						
			}else{
				aux[k] = factors[i];				
				i++;	
			}
			k++;
		}
		while(i<middle && k<end){
			aux[k] = factors[i];
			i++;
			k++;
		}
		while(j<end&& k<end){
			aux[k] = factors[j];
			j++;
			k++;
		}
		for (k = start; k < end; k++) {
			factors[k]= aux[k];
		}
	}

	public static void main(String [] args){
	
		
	}
}
