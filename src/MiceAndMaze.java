import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;




public class MiceAndMaze {

	static class Edge implements Comparable<Edge> {

		int u, time;
		public Edge(int v, int t) {
			this.u = v;
			this.time = t;
		}
		
		public int compareTo(Edge o) {                                 
			return this.time-o.time;
		}                             
	}


	static ArrayList<Edge> [] graph;
	static int []dist;
	static boolean [] visited;
	//static int N = 200;
	public static void main(String []args) throws IOException{
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(in.readLine());
		for (int j = 0; j < TC; j++) {
			in.readLine();
			int N =  Integer.parseInt(in.readLine());
			int E =  Integer.parseInt(in.readLine());
			int T =  Integer.parseInt(in.readLine());
			int M =  Integer.parseInt(in.readLine());
			graph = new ArrayList[N+1];
			dist = new int[N+1];
			
			for (int i = 1; i <= N; i++) {
				dist[i] = Integer.MAX_VALUE; 
				graph[i] = new ArrayList<Edge>();
			}
			for (int  i = 0; i < M; i++) {
				StringTokenizer tokenizer  = new StringTokenizer(in.readLine());
				int u = Integer.parseInt(tokenizer.nextToken());
				int v = Integer.parseInt(tokenizer.nextToken());
				int t = Integer.parseInt(tokenizer.nextToken());				
				Edge edge = new Edge(u,t);
				graph[v].add(edge); //Reversed edges
						
			}
			dijkstra(E);
			int c = 0;
			for (int i = 1; i <= N; i++) {
				if(dist[i]<=T) c++;
			}
			if(j>0) sb.append("\n");
			sb.append(c).append("\n");
		}
		System.out.print(sb.toString());
		in.close();
		System.exit(0);
	}

	public static void dijkstra(int i){
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		dist[i] = 0;		
		queue.add(new Edge(i, 0));
		while(!queue.isEmpty()){
			Edge min = queue.poll();
			for (Edge edge : graph[min.u]) {
				int distance = dist[min.u] + edge.time;
				if(distance < dist[edge.u] ){
					queue.add(edge);
					dist[edge.u] = distance;					
				}                                                             
			}
		}             
	}
}