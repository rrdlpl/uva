import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/***
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=734
 * @author R
 * 793 - Network Connections
 *
 */

public class NetworkConnections {
	
	public static class UnionSet {
		private int [] parents;
		private int [] ranks;
		private int sets;
		public UnionSet(int n){
			parents = new int[n];
			ranks = new int[n];
			for (int i = 0; i < parents.length; i++) {
				parents[i] = i;
			}
			sets = n;
		}
		
		public void unionSet(int i, int j){
			int pi = findSet(i);
			int pj = findSet(j);
			if(pi == pj) return;
			sets--;
			if(ranks[pi]>ranks[pj]){
				parents[pj] = pi;
				return;
			}			
			parents[pi] = pj;
			if(ranks[pi] == ranks[pj]) ranks[pj] +=1;
		}
		
		
		public int findSet(int i){
			if(parents[i] == i) return i;			
			return parents[i] = findSet(parents[i]);
		}
		
		public boolean isSameSet(int i, int j){
			return findSet(i) == findSet(j);
		}
		
		public int getNumberDisjointSets(){
			return sets;
		}
		
		public int sizeOfSet(int i){
			int pi = findSet(i);
			int size = 0;
			for (int j = 0; j < parents.length; j++) {
				if(parents[j]==pi);
					size++;
			}
			return size;
		}		
	}
	
	
	public static void main( String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//StringTokenizer tokenizer = new StringTokenizer(in.readLine());
		int n=0;
		
		String linea = in.readLine();		
		int testCases = Integer.parseInt(linea);
		linea = in.readLine();	 		
		for (int c = 0; c < testCases; c++) {		
			linea = in.readLine();
			n = Integer.parseInt(linea);
			int correct=0, wrong=0;			
			NetworkConnections.UnionSet uset = new NetworkConnections.UnionSet(n);
			while((linea = in.readLine()) != null&& linea.length()>0){
				StringTokenizer  tokenizer = new StringTokenizer(linea);
				char action = tokenizer.nextToken().charAt(0);
				int i = Integer.parseInt(tokenizer.nextToken())-1;
				int j = Integer.parseInt(tokenizer.nextToken())-1;
				if(action == 'c'){
					uset.unionSet(i, j);
				}else{
					if(uset.isSameSet(i, j)) 
						correct++;
					else 
						wrong++;
				}
			}
			if(c>0)
				System.out.println();
			System.out.println(correct+","+wrong);
			
		}
		in.close();
	}


}
