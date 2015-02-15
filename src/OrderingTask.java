import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;


public class OrderingTask {

	static ArrayList<Integer> [] graph;
	static boolean [] visited;
	static Stack<Integer> stack;
	public static void main(String []args) throws IOException{
		//graph = new ArrayList<ArrayList<Integer>>();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();	
		StringTokenizer tokenizer = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());
		while(!(n==0&&m==0)){
			graph = new ArrayList[n+1];
			visited = new boolean[n+1];
			stack = new Stack<Integer>();
			for (int i = 0; i < graph.length; i++) {
				graph[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < m; i++) {
				tokenizer = new StringTokenizer(in.readLine());
				int u =  Integer.parseInt(tokenizer.nextToken());
				int v =  Integer.parseInt(tokenizer.nextToken());
				graph[u].add(v);
			}			
			topoSort();
			sb.append(getAnswer()).append("\n");
			tokenizer = new StringTokenizer(in.readLine());
			n = Integer.parseInt(tokenizer.nextToken());
			m = Integer.parseInt(tokenizer.nextToken());
		}		
		System.out.print(sb.toString());
		in.close();
		System.exit(0);	
		
	}
	
	private static String getAnswer() {
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
			sb.append(stack.isEmpty() ? "": " ");			
		}
		return sb.toString();
	}

	static void topoSort(){
		for (int i = 1; i < visited.length; i++) {
			if(!visited[i])
				DFS(i);
		}		
	}	
	
	static void DFS(int i){
		visited[i] = true;
		for (int ady : graph[i]) {
			if(!visited[ady])
				DFS(ady);
		}
		stack.push(i);
	}
	
}
