import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class MorningWalk {

	static int [] degree;
	static boolean [] visited;
	static ArrayList<Integer> [] graph;
	public static void main(String []args) throws IOException{
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = in.readLine()) != null && !line.equals("")){
			StringTokenizer tokenizer = new StringTokenizer(line);
			int N = Integer.parseInt(tokenizer.nextToken());
			int R = Integer.parseInt(tokenizer.nextToken());
			degree = new int[N];			
			visited  = new boolean[N];
			graph = new ArrayList[N];
			for (int i = 0; i < R; i++) {
				tokenizer = new StringTokenizer(in.readLine());
				int c1 = Integer.parseInt(tokenizer.nextToken());
				int c2 = Integer.parseInt(tokenizer.nextToken());
				degree[c1]++;
				degree[c2]++;
				if(graph[c1] == null) graph[c1] = new ArrayList<Integer>();
				if(graph[c2] == null) graph[c2] = new ArrayList<Integer>();
				graph[c1].add(c2);
				graph[c2].add(c1);
			}                                             
			sb.append(  esConexo() && R>0 ? "Possible": "Not Possible").append("\n");
			
		}
		System.out.print(sb.toString());
		in.close();
		System.exit(0);
	}
	
	private static boolean esConexo() {
		for (int i = 0; i < degree.length; i++) {
			if(degree[i]>0){
				DFS(i);
				break;
			}				
		}
		
		for (int i = 0; i < visited.length; i++)
			if((!visited[i] && degree[i]>0)||(visited[i] && (degree[i] % 2 == 1)))				
					return false;     
		

		return true;

	}
	private static void DFS(int i) {
		visited[i] = true;
		if(graph[i] == null) return;
		for (int ady : graph[i]) {
			if(!visited[ady])
				DFS(ady);
		}
	}

}