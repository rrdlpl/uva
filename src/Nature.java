import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
/***
 * http://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1626
 * @author R
 * 10685 - Nature
 */

public class Nature {
	public static class NatureSet{
		 int [] parents;
		 int [] rank;
		 int [] sizeSets;
		 int maxSet = 1;
		 int sets;
		public NatureSet(int n){
			parents = new int[n];
			rank= new int[n];
			sizeSets = new int[n];
			sets  = n;
			for (int i = 0; i < parents.length; i++) {
				parents[i] = i;
				sizeSets[i] = 1;
			}
			
		}
		
		public  void unionSet(int i, int j){
			int pi = findSet(i);
			int pj = findSet(j);
			if(pi == pj) return;
			sets--;
			if(rank[pi] > rank[pj]){
				parents[pj] = pi;
				sizeSets[pi] += sizeSets[pj];
				maxSet = Math.max(maxSet, sizeSets[pi]);
				return;
			}
			parents[pi] = pj;
			sizeSets[pj] += sizeSets[pi];
			maxSet = Math.max(maxSet, sizeSets[pj]);			
			if(rank[pi] == rank[pj]){
				rank[pj]++;
			}
		}		
		
		public  int findSet(int i){
			if(parents[i] == i) return i;			
			return parents[i] = findSet(parents[i]);			
		}
		
		public  boolean isSameSet(int i, int j){
			return findSet(i) == findSet(j);
		}
		
		public int getMaxSet(){
			return maxSet;
		}
	}
	
	

	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));		
		String linea = in.readLine();		
		StringTokenizer tokenizer = new StringTokenizer(linea);
		int c = Integer.parseInt(tokenizer.nextToken());
		int r = Integer.parseInt(tokenizer.nextToken());
		StringBuilder sb = new StringBuilder();
		while(!(c==0&&r==0)){
			Nature.NatureSet NSet = new NatureSet(c);
			HashMap<String, Integer> hashMap = new HashMap<String,Integer>(c);
			for (int i = 0; i < c; i++) {
				linea = in.readLine(); //creature name;
				hashMap.put(linea,i);			
			}
			for (int i = 0; i < r; i++) {
				tokenizer = new StringTokenizer(in.readLine());
				NSet.unionSet(hashMap.get(tokenizer.nextToken()), hashMap.get(tokenizer.nextToken()));
			}
			sb.append(NSet.getMaxSet()+"\n");
			in.readLine();
			tokenizer = new StringTokenizer(in.readLine());
			c = Integer.parseInt(tokenizer.nextToken());
			r = Integer.parseInt(tokenizer.nextToken());
			
		}
		System.out.print(sb.toString());
		
	}
}
