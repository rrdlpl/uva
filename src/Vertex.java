import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Vertex {
	static boolean []visited;
	static ArrayList<Integer> [] graph;

	public static void main(String []args) throws IOException{
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int  N = Integer.parseInt(in.readLine());
		//String line;
		while(N!=0){                                     
			graph = new ArrayList[N+1];
			StringTokenizer tokenizer = new StringTokenizer(in.readLine());
			while (tokenizer.hasMoreTokens()) {
				int vertex = Integer.parseInt(tokenizer.nextToken());
				if(vertex==0) break;
				int edge;
				if(graph[vertex] == null) graph[vertex] = new ArrayList<Integer>();
				while((edge  = Integer.parseInt(tokenizer.nextToken()))!= 0){
					graph[vertex].add(edge);
				}
				tokenizer = new StringTokenizer(in.readLine());                                                              
			}
			tokenizer = new StringTokenizer(in.readLine());
			int queries = Integer.parseInt(tokenizer.nextToken());
			for (int i = 0; i < queries; i++) {
				int startVertex = Integer.parseInt(tokenizer.nextToken());
				visited = new boolean[N+1];
				DFS(startVertex);
				sb.append(getAnswer()).append("\n");                                                              
			}
			N = Integer.parseInt(in.readLine());
		}                             

		System.out.print(sb.toString());
		in.close();
		System.exit(0);                
	}

	public static void DFS(int v){
		if(graph[v] != null){
			for (int ady: graph[v]) {
				if(!visited[ady]){
					visited[ady] = true;
					DFS(ady);
				}
			}                                             
		}

	}

	public static String getAnswer(){
		StringBuilder sb = new StringBuilder();
		int c = 0;
		for (int i = 1; i < visited.length; i++) {
			if(!visited[i]){
				sb.append(" ").append(i);
				c++;
			}                                                             
		}
		return c+sb.toString();
	}


}