import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class WhatIsMedian {
	
	static long [] array = new long[10010];
	static long [] aux   = new long[10010];
	
	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int i = 0;		
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		while (st.hasMoreElements()) {
			long x = Long.parseLong(st.nextToken());	
			array[i++] = x;		
			mergeSort(0, i);
			long median;
			if(i%2==1){
				median = array[i/2];
			}else{
				median = (array[i/2-1]+array[i/2])/2;
			}
			sb.append(median).append("\n");
			st = new StringTokenizer(in.readLine());
		}
		System.out.print(sb.toString());
		in.close();		
		System.exit(0);
	}
	
	public static void mergeSort(int low, int high){
		if(high-low<=1) return;
		int mid = (high+low)/2;
		mergeSort(low,mid);
		mergeSort(mid,high);
		merge(low, mid, high);
	}

	private static void merge(int start, int mid, int end) {
		int i = start, j = mid, k= start;
		while (i < mid && j < end && k <end) {
			if(array[i] < array[j]){
				aux[k] = array[i++];				
			}else{
				aux[k] =array[j++];				
			}
			k++;
		}
		while(i<mid && k<end){
			aux[k++] = array[i++];			
		}
		while(j<end && k < end){
			aux[k++] = array[j++];			
		}
		for (k = start; k < end; k++) {
			array[k] = aux[k];
		}		
	}
	
	
	

}
