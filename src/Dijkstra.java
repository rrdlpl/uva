
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Dijkstra {

	static class Edge implements Comparable<Edge> {

		int i, distance;
		public Edge(int v, int weight2) {
			this.i = v;
			this.distance = weight2;
		}
		
		//@Override
		public int compareTo(Edge o) {                                 
			return this.distance-o.distance;
		}                             
	}


	static ArrayList<Edge> [] graph;
	static int []dist;
	static boolean [] visited;
	static int N = 200;
	static int [] output = new int[]{7,37,59,82,99,115,133,165,188,197};
	public static void main(String []args) throws IOException{
		graph = new ArrayList[N+1];
		dist = new int[N+1];
		visited = new boolean[N+1];
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			StringTokenizer tokenizer  = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(tokenizer.nextToken());
			if(graph[u] == null) graph[u] = new ArrayList<Dijkstra.Edge>();
			while(tokenizer.hasMoreTokens()){
				String []token = tokenizer.nextToken().split(",");
				int v = Integer.parseInt(token[0]);
				int weight = Integer.parseInt(token[1]);
				Edge edge = new Dijkstra.Edge(v,weight);                                                         

				graph[u].add(edge);
                                  
			}                                             
			dist[i] = Integer.MAX_VALUE;
		}                             
		dijkstra(1);		
		displayOutput();
		in.close();
		System.exit(0);
	}

	private static void displayOutput() {
		for (int i = 0; i < output.length; i++) {
			System.out.print(dist[output[i]]+",");
		}
	}

	public static void dijkstra(int i){
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		dist[i] = 0;		
		queue.add(new Edge(i, 0));
		while(!queue.isEmpty()){
			Edge min = queue.poll();
			for (Edge edge : graph[min.i]) {
				int distance = dist[min.i] + edge.distance;
				int distE = dist[edge.i];				
				if(distance < distE){					
					dist[edge.i] = distance;
					queue.add(edge);
				}                                                             
			}
		}             
	}

}