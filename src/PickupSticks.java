import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;


public class PickupSticks {

	static boolean [] visited;
	static boolean [] anotherVisited;
	static ArrayList<Integer> [] graph;
	static boolean ans;
	static Stack<Integer> stack;
	
	public static void main(String []args) throws IOException{
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer tokenizer = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());
		while(!(N == 0 && M==0)){
			init(N+1);
			ans = true;
			for (int i = 0; i < M; i++) {
				tokenizer = new StringTokenizer(in.readLine());
				int u = Integer.parseInt(tokenizer.nextToken());
				int v = Integer.parseInt(tokenizer.nextToken());
				if(graph[u] == null) graph[u] = new ArrayList<Integer>();
				graph[u].add(v);
			}
			topsort();
			sb.append(ans ? getAnswer() : "IMPOSSIBLE\n" );
			tokenizer = new StringTokenizer(in.readLine());
			N = Integer.parseInt(tokenizer.nextToken());
			M = Integer.parseInt(tokenizer.nextToken());
		}		
		
		System.out.print(sb.toString());
		in.close();
		System.exit(0);                
	}
	private static void topsort(){
		for (int v = 1; v <= visited.length-1 && ans; v++) {
			if(!visited[v])
				DFS(v);
		}
	}
	
	private static void DFS(int i){
		visited[i] = true;
		anotherVisited[i] = true;
		if(graph[i]!=null)
			for (int  ady : graph[i]) {
				if(!visited[ady])
					DFS(ady);
				else
					if(anotherVisited[ady]){
						ans = false;
						return;
					}
			}
		anotherVisited[i] = false;
		stack.push(i);
	}
	
	private static String getAnswer(){
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()){
			sb.append(stack.pop()).append("\n");
		}
		return sb.toString();
	}

	private static void init(int n) {
		visited = new boolean[n];
		anotherVisited = new boolean[n];
		graph = new ArrayList[n];
		stack = new Stack<Integer>();
		
	}
}
