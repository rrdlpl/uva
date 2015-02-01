import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
 
 
public class DNASorting {
               
                static class Output implements Comparable<Output>{
                                int unsortedness;
                                int i;
                                public Output(int u, int i){
                                                this.unsortedness = u;
                                                this.i = i;
                                }             
                               
                                public int compareTo(Output o) {
                                                if(this.unsortedness == o.unsortedness) return this.i-o.i;
                                                return this.unsortedness-o.unsortedness;
                                }
                               
                }
               
                static char [][] dna;
                static char [] array;
                static char [] aux;
               
               
                public static void main(String []args) throws IOException{
                    BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
                    StringTokenizer tokenizer = new StringTokenizer(in.readLine());
                    int M = Integer.parseInt(tokenizer.nextToken());
                    StringBuilder sb = new StringBuilder();                  
                    for (int i = 0; i < M; i++) {
                        in.readLine();
                        tokenizer = new StringTokenizer(in.readLine());                                               
                        int n = Integer.parseInt(tokenizer.nextToken());
                        int m = Integer.parseInt(tokenizer.nextToken());                                            
                        dna = new char[m][n];
                        array = new char[n];
                        aux = new char [n];
                        ArrayList<Output> outputs = new ArrayList<Output>();
                        for (int j = 0; j < m; j++) {
	                        String DNA = in.readLine();
	                        dna[j] =  DNA.toCharArray();
	                        array =  DNA.toCharArray();                                       
	                        int unsortedness = countInversions(array,0, n);
	                        Output out = new Output(unsortedness, j);                       
	                        outputs.add(out);
                        }
                        Collections.sort(outputs);
                        if(i>=1)
                            sb.append("\n");
                        for (Output output : outputs) {
                            sb.append(dna[output.i]).append("\n");
                        }
                    }
                    System.out.print(sb.toString());                               
                    in.close();
                    System.exit(0);
                }
 
                private static int countInversions(char[] array, int low, int high) {
	                if(high-low<= 1) return 0;
	                int mid = (high+low)/2;
	                int l = countInversions(array, low, mid);
	                int r = countInversions(array, mid, high);
	                int s = countSplitInversions(array, low, mid, high);                           
	                return l+r+s;
                }
 
                private static int countSplitInversions(char[] array, int low, int mid,int high) {
	                int c = 0;
	                int i = low, j = mid, k = low;
	                while(i<mid&&j<high&&k<high){
		                if(array[i]>array[j]){
	                        aux[k] = array[j++];
	                        c += mid-i;
		                }else{
		                	aux[k] = array[i++];                                                        
		                }
		                k++;
	                }
	                while(i<mid&&k<high){
                        aux[k++] = array[i++];
	                }
	                while(j<high&&k<high){
                        aux[k++] = array[j++];
	                }                             
	                for (int l = low; l< high; l++) {
	                	array[l] = aux[l];
	                }                             
	                return c;                              
                }
               
 
}