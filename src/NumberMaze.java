import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class NumberMaze {
	static class Edge implements Comparable<Edge>{
		int v, weight,e;
		public Edge(int v,int e, int w){
			this.v = v;
			this.e = e;
			this.weight = w;
		}
		
		public int compareTo(Edge e) { 
			return this.weight- e.weight;
		}		
	}
	static int N, M, T;		
	
	static boolean [][] visited;
	static int [][]grid;
	static int [][] weight;
	static PriorityQueue<Edge> queue;
	
	public static void main(String []args) throws IOException{				
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T= Integer.parseInt(in.readLine());
		grid = new int[999][999];
		weight = new int[999][999];
		for (int i = 0; i < T; i++){
			N = Integer.parseInt(in.readLine());
			M = Integer.parseInt(in.readLine());
			//grid = new int[N][M];
			//weight = new int[N][M];
		//	
			visited = new boolean[N][M];
			for (int j = 0; j < N; j++) {
				StringTokenizer tokenizer = new StringTokenizer(in.readLine());
				for (int k = 0; k < M; k++) {
					grid[j][k] =  Integer.parseInt(tokenizer.nextToken());//new Edge(j, k, Integer.parseInt(tokenizer.nextToken()));
					weight[j][k] = Integer.MAX_VALUE;
				}				
			}
			
			dijkastra();
			sb.append((weight[N-1][M-1])).append("\n");
		}
		System.out.print(sb.toString());
		in.close();
		System.exit(0);
	}


	private static void dijkastra(){
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		weight[0][0] = grid[0][0];		
		//queue.add(grid[0][0]);
		queue.add(new Edge(0, 0, weight[0][0]));
		while(!queue.isEmpty()){
			Edge edge = queue.poll();			
			if(edge.v== N-1 && edge.e == M-1) break;
			if(visited[edge.v][edge.e]) continue;
			visited[edge.v][edge.e] = true;
			for (int i = 0; i < y.length; i++) {
				if(!canMove(i, edge)) continue;
				int X = x[i]+edge.v;
				int Y = y[i]+edge.e;
				if(visited[X][Y]) continue;
				int w = weight[edge.v][edge.e] + grid[X][Y];
				if(w < weight[X][Y]){
					weight[X][Y] = w;
					queue.add(new Edge(X, Y, w));
					
				}					
			}			
		}  
	}
	
	

	
	private static boolean canMove(int i, Edge edge) {
		// TODO Auto-generated method stub
		return x[i]+ edge.v < N && x[i]+edge.v>=0 
			&& y[i]+ edge.e < M && y[i]+edge.e>=0;
	}




	static int []y = new int[]{1,0,-1,0};
	static int []x = new int[]{0,1,0,-1};

	

}
