


public class Quickselect {
	
	static int kTh;
	
	public static void main(String []args){
		
		int [] array = new int [1000];
		for (int i = 0; i < array.length; i++) {
			array[i] = array.length-i;
		}
		quickselect(array, 0, array.length-1, 997);
		System.out.println(kTh);
	}
	
	public static void quickselect(int []array, int low, int high, int k){
		if(high-low <0) return;		
		int piv = select(array, low, high, k);
		if (piv == k){
			kTh = array[k];
		}
		if(k < piv){
			quickselect(array, low, piv-1, k);
		}else{
			quickselect(array, piv+1, high, k);
		}
		
	}

	private static int select(int []array, int low, int high, int k) {
		int piv = k;
		int pivote = array[piv];
		int i = low+1;
		swap(array, piv, low);
		for (int j = i; j <= high; j++) {
			if(array[j]<pivote){
				swap(array, i++, j);				
			}
			
		}
		swap(array, low, --i);
		return i;
	}

	private static void swap(int[] array, int i, int j) {
		int aux = array[j];
		array[j] = array[i];
		array[i] = aux;
	}

}


