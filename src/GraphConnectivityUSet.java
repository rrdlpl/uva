import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class GraphConnectivityUSet {

	public static class GUnionSet {
		private int [] parents;
		private int [] ranks;
		private int sets;
		public GUnionSet(int n){
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
	
	public static void main(String [] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));		
		String linea = in.readLine();		
		int testCases = Integer.parseInt(linea);
		linea = in.readLine();	 		
		for (int i = 0; i < testCases; i++) {		
			linea = in.readLine();
			int n = getNodeEtiqueta(linea,0); //Primera linea
			GUnionSet grafo = new GraphConnectivityUSet.GUnionSet(n+1);
			//initializeGraph(n);				
			while ((linea = in.readLine()) != null&& linea.length()>0) {										
				int x = getNodeEtiqueta(linea, 0);
				int y = getNodeEtiqueta(linea, 1);					
				grafo.unionSet(x, y);
			}					
			int numeroComponentes = grafo.getNumberDisjointSets();
			if(i>0)				
				System.out.println();
			System.out.println(numeroComponentes);
		}
		in.close();
	}
	
	private static int getNodeEtiqueta(String linea, int i) {
		return linea.charAt(i) - 'A';
	}
}
