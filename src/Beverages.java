import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Beverages {

	static HashMap<String, Integer> beverages;
	static HashMap<Integer, String> beveragesName;
	static int firstEdge;
	static Stack<Integer> stack;
	static boolean [] visited;
	static int [] inDegree;
	static ArrayList<Integer> [] graph;
	

	public static void main(String []args) throws IOException{
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int  t = 0;
		String line;
		while((line = in.readLine()) != null){
			int N = Integer.parseInt(line);
			beverages = new HashMap<String, Integer>();
			beveragesName = new HashMap<Integer, String>();
			visited = new boolean[N];
			inDegree = new int[N];
			graph = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				String name = in.readLine();
				beverages.put(name, i);
				beveragesName.put(i, name);
				graph[i] = new ArrayList<Integer>();
			}
			int M = Integer.parseInt(in.readLine());

			for (int i = 0; i < M; i++) {
				StringTokenizer tokenizer = new StringTokenizer(in.readLine());
				String b1 = tokenizer.nextToken();
				String b2 = tokenizer.nextToken();
				int u = beverages.get(b1);                                                          
				int v = beverages.get(b2);
				inDegree[v]++;
				graph[u].add(v);                                                             
			}			
			sb.append("Case #").append(++t).append(": Dilbert should drink beverages in this order:");
			sb.append(topsortBFS()).append("\n");
			in.readLine();
		}		
		System.out.print(sb.toString());
		in.close();
		System.exit(0);                
	}
	
	private static String topsortBFS(){
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();		
		for (int v = 0; v < inDegree.length; v++) {
			if(inDegree[v]==0)
				priorityQueue.add(v);
		}
		StringBuilder sb = new StringBuilder();
		while(!priorityQueue.isEmpty()){
			int u = priorityQueue.poll();
			sb.append(" ").append(beveragesName.get(u));
			for (int ady : graph[u]) {
				if(--inDegree[ady] == 0)
					priorityQueue.add(ady);
			}
		}
		sb.append(".\n");
		return sb.toString();
	}

	private static String topsort() {
		stack = new Stack<Integer>();                  
		DFS(firstEdge);
		for (int i = 0; i < visited.length; i++) {
			if(!visited[i])
				DFS(i);
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()){
			sb.append(beveragesName.get(stack.pop())).append(!stack.isEmpty() ? " ": "");
		}
		sb.append("\n");
		return sb.toString();
	}

	public static void DFS(int i){
		visited[i] = true;               
		for (int ady : graph[i]) {
			if(!visited[ady])
				DFS(ady);                                           
		}
		stack.push(i);
	}
}