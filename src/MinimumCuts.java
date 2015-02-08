import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.StringTokenizer;


public class MinimumCuts {

	static HashMap<Integer,ArrayList<Integer>> graph;
	static HashMap<Integer,ArrayList<Integer>> copyGraph;
	static int [] contraction;
	static ArrayList<Integer> anotherContractions;
	public static void main(String []args) throws IOException{
		int N = 200;
		contraction = new int[N+1];
		graph = new HashMap<Integer, ArrayList<Integer>>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		anotherContractions = new ArrayList<Integer>();
		anotherContractions.add(0);
		for (int i = 1; i <= N; i++) {
			contraction[i] = i;
			anotherContractions.add(i);
			StringTokenizer tokenizer = new StringTokenizer(in.readLine());
			int key = Integer.parseInt(tokenizer.nextToken());
			ArrayList<Integer> edges = new ArrayList<Integer>();
			for(;tokenizer.hasMoreTokens();){
				int edge = Integer.parseInt(tokenizer.nextToken());
				edges.add(edge);
			}
			graph.put(key, edges);
		}		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N*(N-1); i++) {
			cloneGraph();
			min = Math.min(min, minCut());
		}
		System.out.print(min);
		
		in.close();
		System.exit(0);
	}
	public static void cloneGraph(){
		copyGraph = new HashMap<Integer, ArrayList<Integer>>();
		anotherContractions = new ArrayList<Integer>();
		anotherContractions.add(0);
		for (int key : graph.keySet()) {
			anotherContractions.add(key);
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int edge : graph.get(key)) {
				list.add(edge);
			}
			copyGraph.put(key, list);
		}
	}
	



	public static int minCut(){
		int U = -1;
		while(copyGraph.size()>2){
			Random rand = new Random();
			int u = rand.nextInt(anotherContractions.size()-1)+1;
			//System.out.println("Random u "+u);
			u = anotherContractions.get(u);
			//System.out.println("Contracted u "+u);
			int v = rand.nextInt(copyGraph.get(u).size());			
			v  = copyGraph.get(u).get(v);			
			///System.out.println("Merging u,v = "+u+","+v);
			merge(u, v);
			U = u;
		}
		return copyGraph.get(U).size();
	}

	private static void merge(int u, int v) {
		if(u == v) return;		
		int indexV = copyGraph.get(u).indexOf(v);
		while(indexV  != -1) {
			copyGraph.get(u).remove(indexV);
			indexV = copyGraph.get(u).indexOf(v);
		}		
		for (int edge : copyGraph.get(v)) {
			if(edge==u) continue;
			copyGraph.get(u).add(edge); //Merge edges from v in u
		}
		copyGraph.remove(v); //Removes [v]
		indexV = anotherContractions.indexOf(v);		
		anotherContractions.remove(indexV);
		//update all v references;
		for (int key : copyGraph.keySet()) {
			if(key == u) continue;
			indexV = copyGraph.get(key).indexOf(v);
			while(indexV  != -1) {
				copyGraph.get(key).set(indexV, u);
				indexV = copyGraph.get(key).indexOf(v);
			}			
		}
	}
}
