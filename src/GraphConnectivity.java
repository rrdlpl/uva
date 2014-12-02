import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/***
 * UVA 459 - Graph connectivity  
 * @author R
 *  http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=400
 */
public class GraphConnectivity {
	
	
	static ArrayList<ArrayList<Integer>> grafo = new ArrayList<ArrayList<Integer>>(); 
	static  Boolean [] visitados;
	
	
	public static void main(String [] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));		
		String linea = in.readLine();		
		int testCases = Integer.parseInt(linea);
		linea = in.readLine();			
		for (int i = 0; i < testCases; i++) {			
			
			while((linea = in.readLine())!= null && linea.length()>0){			
				
				int n = getNodeEtiqueta(linea,0); //Primera linea				
				initializeGraph(n);				
				while ((linea = in.readLine()) != null&& linea.length()>0) {										
					int x = getNodeEtiqueta(linea, 0);
					int y = getNodeEtiqueta(linea, 1);					
					grafo.get(x).add(y);
					grafo.get(y).add(x);
					
				}					
				int numeroComponentes = getNumeroComponentesBFS();	
				if(i>0)
				{
					System.out.println("\n");
					
				}
				
				System.out.println(numeroComponentes+"\n");
				
				
			}		
			
		}
		in.close();
	}

	private static void initializeGraph(int n) {
		grafo = new ArrayList<ArrayList<Integer>>();
		visitados = new Boolean[n+1];
		for (int i = 0; i <= n; i++) {
			visitados[i] = false;
			grafo.add(new ArrayList<Integer>());
		}
		
	}

	private static int getNumeroComponentesDFS() {
		int componentes = 0;
		for (int i = 0; i < grafo.size(); i++){
			if(!visitados[i]){				
				DFS(i);
				componentes++;
			}
		}
		return componentes;
	}
	
	public static int getNumeroComponentesBFS(){
		int componentes = 0;
		for (int i = 0; i < grafo.size(); i++){
			if(!visitados[i]){				
				BFS(i);
				componentes++;
			}
		}
		return componentes;		
	}

	private static void BFS(int i) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(i);
		visitados[i] = true;
		while(!queue.isEmpty()){
			int v = queue.poll();
			for (Integer ady : grafo.get(v)) {
				if(!visitados[ady]){
					visitados[ady] = true;
					queue.add(ady);
				}
			}
		}		
	}

	private static void DFS(int i) {
		visitados[i] = true;		
		for (Integer ady : grafo.get(i)) {
			if(!visitados[ady])
				DFS(ady);
		}		
	}

	private static int getNodeEtiqueta(String linea, int i) {
		return linea.charAt(i) - 'A';
	}
}
