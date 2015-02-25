import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SendingEmail {
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
		int N = Integer.parseInt(in.readLine());
		for (int j = 1; j <= N; j++) {
			StringTokenizer tokenizer = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(tokenizer.nextToken());
			int m = Integer.parseInt(tokenizer.nextToken());
			int s = Integer.parseInt(tokenizer.nextToken());
			int t = Integer.parseInt(tokenizer.nextToken());
			graph = new ArrayList[n+1];
			dist = new int[n+1];
			for (int i = 0; i <= n; i++) {
				dist[i] = Integer.MAX_VALUE; 
				graph[i] = new ArrayList<Edge>();
			}
			for (int i = 0; i < m ; i++) {
				tokenizer = new StringTokenizer(in.readLine());
				int u = Integer.parseInt(tokenizer.nextToken());
				int v = Integer.parseInt(tokenizer.nextToken());
				int time = Integer.parseInt(tokenizer.nextToken());
				Edge edgeU = new Edge(u, time);
				Edge edgeV = new Edge(v, time);
				graph[u].add(edgeV);
				graph[v].add(edgeU);				
			}
			dijkstra(s);
			sb.append("Case #").append(j).append(": ").append(dist[t] != Integer.MAX_VALUE ? dist[t]:"unreachable").append("\n");
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
